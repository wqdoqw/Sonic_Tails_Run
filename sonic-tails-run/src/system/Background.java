package system;

import static resource.Resource.back1X;
import static resource.Resource.back2X;
import static resource.Resource.background;
import static resource.Resource.runPage;
import static resource.Resource.speed;
import static resource.Resource.character;
import static resource.Resource.mapLength;
import static resource.Resource.background2;
import static resource.Resource.background3;
import static resource.Resource.end;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Background {

	/**
	 * <p>
	 * 배경화면이 흐르도록 한다.
	 * </p>
	 */
	public static void moveBackGround() {
		back1X--;
		back2X--;

		if (back1X < -(background.getWidth(null) - 2)) {
			back1X = background.getWidth(null);
		}

		if (back2X < -(background.getWidth(null) - 2)) {
			back2X = background.getWidth(null);
		}

		if (runPage > 800) { // 800픽셀 이동 마다 체력이 10씩 감소한다
			character.setHealth(character.getHealth() - 10);
			runPage = 0;

			switch (mapLength) {
			case 20:
				new FadeSystem().Fade();
				break;
			case 23:
				background = background2;
				break;
			case 52:
				new FadeSystem().Fade();
				break;
			case 55:
				background = background3;
				break;
			case 78:
				end = true;
				break;
			}
			mapLength++;
		}

		runPage += speed;
	}
}
