package gui;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import static resource.Resource.isDBOn;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class DatabaseDialogue extends JDialog {
	private JButton[] btns = { new JButton("Turn On Database"), new JButton("Turn Off Database") };
	private ImageIcon redLight = new ImageIcon(
			new ImageIcon(DatabaseDialogue.class.getResource("/database/red_light.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	private ImageIcon greenLight = new ImageIcon(
			new ImageIcon(DatabaseDialogue.class.getResource("/database/green_light.png")).getImage()
					.getScaledInstance(40, 30, Image.SCALE_DEFAULT));
	private JLabel colorLabel = new JLabel(greenLight);
	private JLabel textLabel = new JLabel("DB is on");

	public DatabaseDialogue() {
		setTitle("Database Setting");
		setResizable(false);

		for (int i = 0; i < btns.length; i++) {
			add(btns[i]);
			btns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					switch (e.getActionCommand()) {
					case "Turn On Database":
						if (isDBOn) {
							JOptionPane.showMessageDialog(null, "Database is already running");
						} else {
							isDBOn = true;
							colorLabel.setIcon(greenLight);
							textLabel.setText("DB is on");
						}
						break;
					case "Turn Off Database":
						if (isDBOn) {
							isDBOn = false;
							colorLabel.setIcon(redLight);
							textLabel.setText("DB is off");
						} else {
							JOptionPane.showMessageDialog(null, "Database is already off");
						}
						break;
					}
				}
			});
		}
		add(colorLabel);
		add(textLabel);
		setIconImage(new ImageIcon(DatabaseDialogue.class.getResource("/icon/cogwheel.png")).getImage());
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setSize(300, 120);
	}
}
