package gameutil;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/***
 * 
 * @author Sang Ik Park
 *
 */
public class Audio {
	private Clip clip;
	private AudioInputStream stream;

	public void playAudio() {
		try {
			clip = AudioSystem.getClip();
			stream = AudioSystem.getAudioInputStream((Audio.class.getResource("/music.wav")));
			clip.open(stream);
			clip.start();
			clip.addLineListener(new LineListener() {

				@Override
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						clip.setFramePosition(0);
						clip.start();
					}
				}
			});
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}

	public void stopAudio() {
		clip.stop();
		clip.close();
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
