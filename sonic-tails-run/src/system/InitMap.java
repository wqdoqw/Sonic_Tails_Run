package system;

import static resource.Resource.bird;
import static resource.Resource.enemyList;
import static resource.Resource.fireball;
import static resource.Resource.imgList;
import static resource.Resource.portion;
import static resource.Resource.portionList;
import static resource.Resource.ring;

import dto.Enemy;
import dto.Item;

public class InitMap {
	private int[][] colorArr;
	private int[] sizeArr;

	public InitMap(String selectPath) {
		try {
			sizeArr = LoadMap.getSize(getClass().getResource(selectPath));
			colorArr = LoadMap.getPic(getClass().getResource(selectPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int maxX = sizeArr[0];
		int maxY = sizeArr[1];
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (colorArr[i][j] == 16776960) { // decimal value of yellow color
					imgList.add(new Item(ring, 0, i * 40, j * 40, 255));
				} else if (colorArr[i][j] == 15539236) { // decimal value of red color
					enemyList.add(new Enemy(bird, 0, i * 40, j * 40));
				} else if (colorArr[i][j] == 11920925) { // decimal value of green color
					enemyList.add(new Enemy(fireball, 0, i * 40, j * 40));
				} else if (colorArr[i][j] == 0) { // decimal value of black color
					portionList.add(new Item(portion, 0, i * 40, j * 40, 255));
				}
			}
		}
	}
}
