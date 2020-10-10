package system;

import static resource.Resource.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import dto.Character;
import dto.Delay;
import dto.GameScore;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class ResetSystem {

	/**
	 * <p>
	 * 게임이 다시 시작되면 정적변수를 초기화한다.
	 * </p>
	 */
	public ResetSystem() {
		character = new Character(img, 150, 150, 255, false, 1000);
		back1X = 0;
		back2X = background.getWidth(null);
		speed = 5;
		runPage = 0;
		mapLength = 0;
		score = new GameScore();
		imgList.clear();
		enemyList.clear();
		path = null;
		end = false;
		leaderBoardList.clear();
		delay.setDelay(Delay.INITIAL_DELAY);
		background = new ImageIcon(new ImageIcon(ResetSystem.class.getResource("/background/forest.jpg")).getImage()
				.getScaledInstance(800, 500, Image.SCALE_DEFAULT)).getImage();
	}
}
