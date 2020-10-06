package system;

import static resource.Resource.pause;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class PauseSystem {
	/**
	 * <p>
	 * pause가 되면 while문에 갇힌다.
	 * </p>
	 */
	public void pause() {
		if (pause) {
			while (pause) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
