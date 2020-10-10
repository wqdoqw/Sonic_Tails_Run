package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import static resource.Resource.easyMap;
import static resource.Resource.hardMap;
import static resource.Resource.easyMapSelected;
import static resource.Resource.hardMapSelected;
import static resource.Resource.easyMapPath;
import static resource.Resource.hardMapPath;
import static resource.Resource.path;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class SelectionPanel extends JPanel {
	private Image intro = new ImageIcon(SelectionPanel.class.getResource("/selection/transparentintro.png")).getImage();
	private ImageIcon startBtn = new ImageIcon(
			new ImageIcon(SelectionPanel.class.getResource("/selection/gamestartbtn.png")).getImage()
					.getScaledInstance(190, 50, Image.SCALE_DEFAULT));
	private JButton[] btns = { new JButton(startBtn), new JButton(easyMap), new JButton(hardMap) };

	public SelectionPanel(Object obj) {
		btns[0].setName("startBtn");
		btns[0].setBorderPainted(false);
		btns[0].setFocusPainted(false);
		btns[0].setContentAreaFilled(false);
		btns[0].setBounds(255, 330, 291, 100);
		btns[0].addMouseListener((MouseListener) obj);

		btns[1].setBorderPainted(false);
		btns[1].setFocusPainted(false);
		btns[1].setContentAreaFilled(false);
		btns[1].setBounds(150, 110, 200, 200);
		btns[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btns[1].setIcon(easyMapSelected);
				btns[2].setIcon(hardMap);
				path = easyMapPath;
			}
		});

		btns[2].setBorderPainted(false);
		btns[2].setFocusPainted(false);
		btns[2].setContentAreaFilled(false);
		btns[2].setBounds(450, 110, 200, 200);
		btns[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btns[1].setIcon(easyMap);
				btns[2].setIcon(hardMapSelected);
				path = hardMapPath;
			}
		});

		add(btns[0]);
		add(btns[1]);
		add(btns[2]);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(intro, 0, 0, this.getWidth(), this.getHeight(), null);

		g.setFont(new Font("맑은 고딕", Font.BOLD, 38));
		g.drawString("난이도", 327, 50);
		g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		g.drawString("쉬움", 230, 100);
		g.drawString("어려움", 520, 100);
	}

	public JButton[] getSelectionBtn() {
		return btns;
	}
}
