package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import system.ResetSystem;
import system.ScreenshotSystem;

import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gameutil.MenuActionListener;
import jdbc.Dao;

import static resource.Resource.path;
import static resource.Resource.easyMap;
import static resource.Resource.hardMap;
import static resource.Resource.isDBOn;

/***
 * 
 * @author Sang Ik Park
 *
 */
public class MainFrame extends MouseAdapter {

	private JFrame frame;
	private CardLayout card;
	private IntroPanel introPanel;
	private SelectionPanel selectionPanel;
	private Game gamePanel;
	private EndPanel endPanel;
	private int result;
	private LeaderBoardPanel leaderboardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("Sonic Tails Run");
		frame.setBounds(100, 100, 800, 530);
		frame.setIconImage(new ImageIcon(MainFrame.class.getResource("/icon/icon.png")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		card = new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);

		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Setting");
		JMenu menu2 = new JMenu("Help");
		menu2.add(new JMenuItem("Manual") {
			{
				addActionListener(new MenuActionListener());
			}
		});

		menu.add(new JMenuItem("Music") {
			{
				addActionListener(new MenuActionListener());
			}
		});
		menu.add(new JMenuItem("Database") {
			{
				addActionListener(new MenuActionListener());
			}
		});
		menu.add(new JMenuItem("Exit") {
			{
				addActionListener(new MenuActionListener());
			}
		});
		mb.add(menu);
		mb.add(menu2);

		frame.setJMenuBar(mb);
		introPanel = new IntroPanel();
		introPanel.addMouseListener(this);
		selectionPanel = new SelectionPanel(this);
		gamePanel = new Game(frame, card);
		endPanel = new EndPanel(this);
		leaderboardPanel = new LeaderBoardPanel(this);

		introPanel.setLayout(null);
		selectionPanel.setLayout(null);
		gamePanel.setLayout(null);
		endPanel.setLayout(null);
		leaderboardPanel.setLayout(null);

		frame.getContentPane().add("introPanel", introPanel);
		frame.getContentPane().add("selectionPanel", selectionPanel);
		frame.getContentPane().add("gamePanel", gamePanel);
		frame.getContentPane().add("endPanel", endPanel);
		frame.getContentPane().add("leaderBoardPanel", leaderboardPanel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getComponent().toString().contains("IntroPanel")) { // IntroPanel 찾기
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			card.show(frame.getContentPane(), "selectionPanel");
		} else if (e.getComponent().getName().equals("startBtn")) {

			if (path == null) {
				JOptionPane.showMessageDialog(null, "맵을 제대로 선택하세요", "message", JOptionPane.WARNING_MESSAGE);
			} else {
				// 게임패널 보여주기
				card.show(frame.getContentPane(), "gamePanel");
				gamePanel.requestFocus();
				gamePanel.start();
				// 맵 선택 사진 초기화
				selectionPanel.getSelectionBtn()[1].setIcon(easyMap);
				selectionPanel.getSelectionBtn()[2].setIcon(hardMap);

			}
		} else if (e.getComponent().getName().equals("endButton")) {
			// end button을 클릭하면 원래 있던 게임패널을 지우고 세로운 게임패널을 생성한다.
			frame.getContentPane().remove(gamePanel);
			gamePanel = new Game(frame, card);
			gamePanel.setLayout(null);
			frame.getContentPane().add(gamePanel, "gamePanel");

			// 데이터베이스가 연결되있으면 참
			if (isDBOn) {

				// 데이터를 리스트에 저장
				Dao.loadData();

				result = JOptionPane.showConfirmDialog(null, "현재 기록을 저장 하시겠습니까?", "message", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// 커스텀 option pane의 객체를 만든다.
					SaveOptionPane save = new SaveOptionPane();
					result = JOptionPane.showConfirmDialog(null, save, "이름을 입력하세요", JOptionPane.OK_CANCEL_OPTION);

					if (result == JOptionPane.OK_OPTION) {

						// DB에 이름, 스코어, 시간을 저장한다.
						while (!Dao.insertData(save.getName())) {
							result = JOptionPane.showConfirmDialog(null, save, "중복된 이름은 안됩니다.",
									JOptionPane.OK_CANCEL_OPTION);
							if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
								break;
							}
						}
						Dao.loadData();
						result = JOptionPane.showConfirmDialog(null, "스코어 사진을 저장하시겠습니까?", "message",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.OK_OPTION) {
							// 스코어 패널의 스크린샷을 현재 다이렉토리에 저장
							new ScreenshotSystem(frame, save.getName());
						}
					}
				}
			}

			// 여기서 리더보드를 보여준다.
			card.show(frame.getContentPane(), "leaderBoardPanel");

		} else if (e.getComponent().getName().equals("leaderBoardButton")) { // 리더보드의 버튼을 누르면
			// 카드레이아웃에서 인트로패널을 다시 보여준다.
			card.show(frame.getContentPane(), "introPanel");
			// 정적변수들 초기화
			new ResetSystem();

		}
	}
}
