package system;

import java.awt.event.KeyEvent;
import static resource.Resource.character;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Movement {
	protected int posX, posY;
	private final int MAX_Y_POS = 410;
	private final int MIN_Y_POS = -30;
	private final int MAX_X_POS = 700;
	private final int MIN_X_POS = -30;

	/**
	 * <p>
	 * 키보드로 입력을 받아 캐릭터의 좌표를 바꾼다.
	 * </p>
	 * 
	 * @param code
	 */
	public void move(int code) {
		posX = character.getX();
		posY = character.getY();

		switch (code) {
		case KeyEvent.VK_RIGHT:
			character.setX(character.getX() + 10);
			checkPos();
			break;
		case KeyEvent.VK_LEFT:
			character.setX(character.getX() - 10);
			checkPos();
			break;
		case KeyEvent.VK_UP:
			character.setY(character.getY() - 10);
			checkPos();
			break;
		case KeyEvent.VK_DOWN:
			character.setY(character.getY() + 10);
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
		if (character.getX() <= MIN_X_POS || character.getY() <= MIN_Y_POS || character.getX() >= MAX_X_POS
				|| character.getY() >= MAX_Y_POS) {
			character.setX(posX);
			character.setY(posY);
		}
	}

}
