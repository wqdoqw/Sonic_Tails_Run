package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	private Image end = new ImageIcon(EndPanel.class.getResource("/end/endpanel.jpg")).getImage();
	private ImageIcon endButton = new ImageIcon(EndPanel.class.getResource("/end/button.png"));
	private JLabel label1;
	private static JLabel label2;

	public EndPanel(Object obj) {
		JButton btn = new JButton(endButton);
		btn.setBounds(550, 400, 170, 50);
		btn.setName("endButton");
		btn.addMouseListener((MouseListener) obj);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		add(btn);

		label1 = new JLabel("SCORE");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 37));
		label1.setBounds(530, 290, 205, 55);
		add(label1);

		label2 = new JLabel("0");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 49));
		label2.setBounds(400, 325, 459, 87);
		add(label2);

	}

	public static void setResultScore(int resultScore) {
		label2.setText("" + resultScore);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(end, 0, 0, this.getWidth(), this.getHeight(), null);
		
	}
}
