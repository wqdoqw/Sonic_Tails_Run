package dto;
import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {
	protected Image image;
	protected int x;
	protected int y;
	private int alpha;
	private boolean hit = false;
	private int health;
}
