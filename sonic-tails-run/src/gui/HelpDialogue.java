package gui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class HelpDialogue extends JDialog {
	public HelpDialogue() {
		setTitle("Help");
		setLayout(null);
		setResizable(false);
		setIconImage(new ImageIcon(HelpDialogue.class.getResource("/icon/questionicon.png")).getImage());
		JLabel label = new JLabel(new ImageIcon(new ImageIcon(HelpDialogue.class.getResource("/character/tails_fly.gif")).getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		JLabel label2 = new JLabel("<html>" + "상하좌우로  적들을 피하면서 테일즈가 최대한 많은 코인을 먹을수 있도록 도와주세요!!" + "</html>");
		JLabel label3 = new JLabel(new ImageIcon(
				new ImageIcon(HelpDialogue.class.getResource("/help/healthbar.png")).getImage().getScaledInstance(150, 20, Image.SCALE_DEFAULT)));
		JLabel label4 = new JLabel("<html>" + "체력이 0이되면 게임이 종료됩니다." + "</html>");
		JLabel label5 = new JLabel(
				"<html>" + "p를 누르면 일시정지 -나 +를 누르면 게임속도를 조절 할 수도 있습니다. 음악을 끄고 싶으면 메뉴에서 끌 수도 있어요!!" + "</html>");
		JLabel label6 = new JLabel(new ImageIcon(HelpDialogue.class.getResource("/help/musicplayer.png")));
		JLabel label7 = new JLabel("<html>" + "제작자: 박상익" + "</html>");
		JLabel label8 = new JLabel("<html><h1>" + "Sonic Tails Run" + "</h1></html>");

		label2.setFont(new Font("굴림", Font.ITALIC, 15));
		label4.setFont(new Font("굴림", Font.ITALIC, 15));
		label5.setFont(new Font("굴림", Font.ITALIC, 15));
		label7.setFont(new Font("굴림", Font.ITALIC, 15));

		label.setBounds(15, 35, 100, 100);
		label2.setBounds(150, 45, 200, 100);
		label3.setBounds(125, 145, 300, 50);
		label4.setBounds(15, 145, 150, 50);
		label5.setBounds(180, 175, 175, 155);
		label6.setBounds(15, 215, 150, 75);
		label7.setBounds(15, 300, 150, 75);
		label8.setBounds(100, 0, 200, 40);

		add(label);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);

		this.setLocation(550, 275);
		setSize(400, 400);
	}
}
