package gui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class IntroPanel extends JPanel {
	private ImageIcon intro = new ImageIcon(IntroPanel.class.getResource("/intro/sonictail.jpg"));

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(intro.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
