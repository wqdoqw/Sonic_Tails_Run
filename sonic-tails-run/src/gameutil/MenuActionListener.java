package gameutil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.HelpDialogue;
import gui.MusicDialogue;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class MenuActionListener implements ActionListener {
	private MusicDialogue dialogue = new MusicDialogue();
	private HelpDialogue dialogue2 = new HelpDialogue();

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Manual":
			dialogue2.setVisible(true);
			break;
		case "Music":
			dialogue.setVisible(true);
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}
}
