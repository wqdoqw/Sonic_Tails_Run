package system;

import static resource.Resource.portionList;

import javax.swing.ImageIcon;

import static resource.Resource.character;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class PortionSystem {
	/**
	 * <p>
	 * 포션의 위치를 재조정하고 캐릭터가 포션을 먹으면 HP가 찬다.
	 * </p>
	 * @param x
	 * @param y
	 */
	public void portion(int x, int y) {
		for (int i = 0; i < portionList.size(); i++) {
			portionList.get(i).setX(portionList.get(i).getX() - 2);
		}

		for (int i = 0; i < portionList.size(); i++) {
			if (portionList.get(i).getX() < x + 60 && portionList.get(i).getX() > x - 60
					&& portionList.get(i).getY() < y + 60 && portionList.get(i).getY() > y - 60) {
				
				// 포션을 먹으면 이미지를 바꾼다.
				portionList.get(i).setImage(new ImageIcon("img/effect.png").getImage());

				if (character.getHealth()<=900) {
					character.setHealth(character.getHealth() + 1);
				}else {
					//캐릭터의 HP가 1000이상으로 가는것을 방지
					character.setHealth(1000);
				}
			}
		}
	}
}
