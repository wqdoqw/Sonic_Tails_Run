package dto;

import lombok.Data;

@Data
public class Delay {
	public final static int INITIAL_DELAY = 15;
	private int delay;
	private int newDelay;
	public Delay() {
		this.delay = INITIAL_DELAY;
	}
}
