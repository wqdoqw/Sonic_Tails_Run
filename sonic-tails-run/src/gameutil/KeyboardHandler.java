package gameutil;

import static resource.Resource.character;
import static resource.Resource.delay;
import static resource.Resource.pause;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dto.Delay;
/***
 * 
 * @author Sang Ik Park
 *
 */
public class KeyboardHandler implements KeyListener {
	private JPanel panel;
	private JButton button;
	private int num = Delay.INITIAL_DELAY;
	private final int MAX_DELAY = 21;
	private final int MIN_DELAY = 1;

	public KeyboardHandler(JPanel panel, JButton button) {
		this.panel = panel;
		this.button = button;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
//		System.out.println("X pos : " + character.getX() + " Y pos: " + character.getY());
		character.move(code);
		if (code == 80) {
			if (!pause) {
				panel.add(button);
				pause = true;
			} else {
				// if press p again
				pause = false;
				panel.remove(button);
			}
		}

		if (e.getKeyChar() == '+') {
			if (delay.getDelay() > MIN_DELAY) {
				delay.setDelay(--num);
			}
		}
		if (e.getKeyChar() == '-') {
			if (delay.getDelay() < MAX_DELAY) {
				delay.setDelay(num += 1);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
