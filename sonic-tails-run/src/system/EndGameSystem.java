package system;

import static resource.Resource.character;
import static resource.Resource.score;
import java.awt.CardLayout;

import gui.EndPanel;

import javax.swing.JFrame;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class EndGameSystem {
 
	/**<p>
	 * 캐릭터의 체력이 0이되면 게임을 끝낸다
	 * </p>
	 * @param frame
	 * @param card
	 * @return boolean 게임이 끝나면 참 아니면 참이 아닌값을 반환한다
	 */
	public boolean end(JFrame frame, CardLayout card) {
		if (character.getHealth() <= 0) {
			EndPanel.setResultScore(score.getScore());
			card.show(frame.getContentPane(), "endPanel");
			return true;
		}
		return false;
	}
}
