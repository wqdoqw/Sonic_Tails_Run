package system;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class LoadMap {

	/**
	 * <p>
	 * 이미지의 높이와 너비를 반환한다
	 * </p>
	 * @param src
	 * @return Integer: 정수 형태의 이미지의 높이와 너비
	 */
	public static int[] getSize(URL src) throws Exception {
		BufferedImage img = ImageIO.read(src);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] tempPos = { width, height };
		return tempPos;
	}

	/**
	 * <p>
	 * 이미지를 읽어서 픽셀의 십진법의 RGB값을 2차원 정수형 배열에 저장한다.
	 * </p>
	 * @param src
	 * @return 2차원 정수형 배열 형태의 픽셀의 십진법의 RGB 값
	 * @throws Exception 
	 */
	public static int[][] getPic(URL src) throws Exception {
		BufferedImage img = ImageIO.read(src);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixels = new int[width * height];
		PixelGrabber grab = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);
		grab.grabPixels();
		int[][] picture = new int[width][height];
		for (int i = 0; i < pixels.length; i++)
			picture[i % width][i / width] = pixels[i] + 16777216;
		return picture;
	}
}
