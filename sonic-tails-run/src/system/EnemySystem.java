package system;

import static resource.Resource.enemyList;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class EnemySystem {
	/**
	 * <p>
	 * 캐릭터의 x와 y좌표를 받아서 적이랑 부딫쳤는지 검사한다.
	 * </p>
	 * @param x
	 * @param y
	 */
	public void displayEnemy(int x, int y) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).setX(enemyList.get(i).getX() - 2);
		}

		for (int i = 0; i < enemyList.size(); i++) {
			if (enemyList.get(i).getX() < x + 60 && enemyList.get(i).getX() > x - 60 && enemyList.get(i).getY() < y + 60
					&& enemyList.get(i).getY() > y - 60) {
				new HitSystem().hit();
			}
		}

	}
}
