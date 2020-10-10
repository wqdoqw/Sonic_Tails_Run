package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dto.LeaderBoard;

import static resource.Resource.leaderBoardList;
import static resource.Resource.isDBOn;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class LeaderBoardPanel extends JPanel {
	private Image end = new ImageIcon(LeaderBoardPanel.class.getResource("/leaderboard/sonicbackground2.jpg"))
			.getImage();
	private ImageIcon leaderBoardButton = new ImageIcon(LeaderBoardPanel.class.getResource("/end/button.png"));

	public LeaderBoardPanel(Object obj) {
		JButton btn = new JButton(leaderBoardButton);
		btn.setBounds(550, 400, 170, 50);
		btn.setName("leaderBoardButton");
		btn.addMouseListener((MouseListener) obj);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		add(btn);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cnt = 1;
		g.drawImage(end, 0, 0, this.getWidth(), this.getHeight(), null);
		g.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 44));
		g.drawString("LeaderBoard", 350, 50);
		g.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 25));
		g.drawString("Top Three Players", 390, 80);

		g.setFont(new Font("나눔바른고딕", Font.BOLD, 22));

		for (LeaderBoard leaderBoard : leaderBoardList) {
			g.drawString(cnt + ".", 350, 80 + cnt * 40);
			g.drawString(leaderBoard.getName(), 390, 80 + cnt * 40);
			g.drawString("Score: " + leaderBoard.getScore() + "", 480, 80 + cnt * 40);
			g.drawString(leaderBoard.getTime(), 650, 80 + cnt * 40);
			if (cnt++ == 3) {
				break;
			}
		}
		if (!isDBOn) {
			g.drawString("No database connection", 410, 80 + 40);
		}
	}
}
