package system;

import static resource.Resource.imgList;
import static resource.Resource.score;
import static resource.Resource.effect;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class ItemSystem {
	/**
	 * <p>
	 * 아이템을 표시한다. 캐릭터가 아이템을 먹으면 스코어가 올라가고 아이템의 이미지를 바꾼다.
	 * </p>
	 * 
	 * @param x
	 * @param y
	 */
	public void displayItem(int x, int y) {
		for (int i = 0; i < imgList.size(); i++) {
			imgList.get(i).setX(imgList.get(i).getX() - 2);
		}
		for (int j = 0; j < imgList.size(); j++) {
			// 캐릭터가 아이템의 x와 y좌표 안에들어오면 아이템을 없애고 effect의 사진으로 바꾼다
			if (imgList.get(j).getX() < x + 60 && imgList.get(j).getX() > x - 60 && imgList.get(j).getY() < y + 60
					&& imgList.get(j).getY() > y - 60) {

				imgList.get(j).setImage(effect);
				score.setScore(score.getScore() + 10);
				if (imgList.get(j).getAlpha() > 1) {
					imgList.get(j).setAlpha(imgList.get(j).getAlpha() - 2);
				}
			}
		}
	}
}
