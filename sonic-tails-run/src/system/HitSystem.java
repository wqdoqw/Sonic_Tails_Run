package system;

import static resource.Resource.character;
import static resource.Resource.img2;
import static resource.Resource.img;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class HitSystem {
	/**
	 * <p>
	 * 캐릭터와 부딪치면 캐릭터의 체력이 부딪친동안 감소하고 캐릭터의 이미지를 부딪친동안 바꾼다.
	 * </p>
	 */
	public void hit() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				character.setHit(true);
				character.setHealth(character.getHealth() - 1);
				character.setImage(img2);
				character.setAlpha(80);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (character.getImage() == img2) {
					character.setImage(img);
				}
				for (int i = 0; i < 11; i++) {
					if (character.getAlpha() == 80) {
						character.setAlpha(160);
					} else {
						character.setAlpha(80);
					}
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				character.setAlpha(255);
				character.setHit(false);
			}
		}).start();

	}
}
