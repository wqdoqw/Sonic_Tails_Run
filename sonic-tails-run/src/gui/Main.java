package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import system.ResetSystem;

import java.awt.CardLayout;
import javax.swing.JMenuItem;

import gameutil.MenuActionListener;

/***
 * 
 * @author Sang Ik Park
 *
 */
public class Main extends MouseAdapter {

	private JFrame frame;
	private CardLayout card;
	private IntroPanel introPanel;
	private Game gamePanel;
	private EndPanel endPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("Sonic Tails Run");
		frame.setBounds(100, 100, 800, 530);
		frame.setIconImage(new ImageIcon(Main.class.getResource("/icon/icon.png")).getImage());
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
		gamePanel = new Game(frame, card);
		endPanel = new EndPanel(this);

		introPanel.setLayout(null);
		gamePanel.setLayout(null);
		endPanel.setLayout(null);

		frame.getContentPane().add("introPanel", introPanel);
		frame.getContentPane().add("gamePanel", gamePanel);
		frame.getContentPane().add("endPanel", endPanel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().toString().contains("IntroPanel")) { // IntroPanel 찾기
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			// 게임패널 보여주기
			card.show(frame.getContentPane(), "gamePanel");
			gamePanel.requestFocus();
			gamePanel.start();
			// end button을 클릭하면 원래 있던 게임패널을 지우고 세로운 게임패널을 생성한다.
		} else if (e.getComponent().getName().equals("endButton")) {
			frame.getContentPane().remove(gamePanel);
			gamePanel = new Game(frame, card);
			gamePanel.setLayout(null);
			frame.getContentPane().add(gamePanel, "gamePanel");

			// 카드레이아웃에서 인트로패널을 다시 보여준다.
			card.show(frame.getContentPane(), "introPanel");
			// static변수들 초기화
			new ResetSystem();
			// 맵초기화
			gamePanel.initMap();
		}
	}
}
