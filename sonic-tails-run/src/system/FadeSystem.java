package system;

import java.awt.Color;
import static resource.Resource.backFade;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class FadeSystem {
	/**
	 * <p>
	 * RGB 값을 조정하여 화면을 희미하게 만든다.
	 * </p>
	 */
	public void Fade(){
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 256; i += 2) {
					backFade = new Color(0, 0, 0, i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 255; i >= 0; i -= 2) {
					backFade = new Color(0, 0, 0, i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
}
