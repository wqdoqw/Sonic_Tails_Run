package system;

import java.awt.Image;

import java.awt.event.KeyEvent;
import dto.Character;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Movement extends Character {
	protected int posX, posY;
	private final int MAX_Y_POS = 410;
	private final int MIN_Y_POS = -30;
	private final int MAX_X_POS = 700;
	private final int MIN_X_POS = -30;

	public Movement(Image image, int x, int y, int alpha, boolean hit, int health) {
		super(image, x, y, alpha, hit, health);
	}
	/**
	 * <p>
	 * 키보드로 입력을 받아 캐릭터의 좌표를 바꾼다.
	 * </p>
	 * @param code
	 */
	public void move(int code) {
		posX = x;
		posY = y;

		switch (code) {
		case KeyEvent.VK_RIGHT:
			x += 10;
			checkPos();
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			checkPos();
			break;
		case KeyEvent.VK_UP:
			y -= 10;
			checkPos();
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			checkPos();
			break;
		}
	}
	
	/**
	 * <p>
	 * 캐릭터가 화면 밖으로 못 나가게 한다.
	 * </p>
	 */
	private void checkPos() {
		if (x <= MIN_X_POS || y <= MIN_Y_POS || x >= MAX_X_POS || y >= MAX_Y_POS) {
			x = posX;
			y = posY;
		}
	}

}
