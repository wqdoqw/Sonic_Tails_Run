package system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class ScreenshotSystem {
	/**
	 * <p>
	 * 현재 다이렉토리에 스크린샷을 저장한다.
	 * </p>
	 * 
	 * @param frame 사진을 찍히는 프레임.
	 * @param name  파일의 이름은 유저의 이름으로 한다.
	 */
	public ScreenshotSystem(JFrame frame, String name) {
		BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
		frame.paint(img.getGraphics());
		// 현재 다이렉토리에 저장한다.
		File outputfile = new File(name + ".png");
		try {
			// 스크린샷을 저장한다.
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
