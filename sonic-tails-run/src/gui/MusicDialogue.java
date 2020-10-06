package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import static resource.Resource.audio;
import static resource.Resource.isAudioPlaying;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class MusicDialogue extends JDialog {
	private JButton[] btns = { new JButton("play"), new JButton("stop") };

	public MusicDialogue() {
		setTitle("Music");
		setResizable(false);
		
		for (int i = 0; i < btns.length; i++) {
			add(btns[i]);
			btns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					switch (e.getActionCommand()) {
					case "play":
						if (!isAudioPlaying) {
							audio.playAudio();
							isAudioPlaying = true;
						}else {
							JOptionPane.showMessageDialog(null, "Audio is already playing");
						}
						break;
					case "stop":
						if (isAudioPlaying) {
							audio.stopAudio();
							isAudioPlaying = false;
						}else {
							JOptionPane.showMessageDialog(null, "no audio is playing");
						}
						break;
					}
				}
			});
		}
		setIconImage(new ImageIcon(MusicDialogue.class.getResource("/icon/musicicon.png")).getImage());
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setSize(300, 100);
	}
}
