package gameutil;

public class GameTimer extends Thread {
	double acc = 0.0; // 누적된 시간

	@Override
	public void run() {

		long currentTime = System.currentTimeMillis();
		while (true) {
			long newTime = System.currentTimeMillis();
			long frameTime = newTime - currentTime;

			// 밀리세컨드를  초로 바꾼다
			acc += ((double) frameTime) / 1000;
		}
	}

	public String getTime() {
		return "" + acc;
	}
}
