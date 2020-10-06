package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameScore {
	private int score;
	private int countRing;
	private final int INITIAL_SCORE = 0;

	public GameScore() {
		this.score = INITIAL_SCORE;
	}
}
