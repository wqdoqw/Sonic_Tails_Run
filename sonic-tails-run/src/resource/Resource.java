package resource;

import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import dto.Delay;
import dto.Enemy;
import dto.GameScore;
import dto.Item;
import gameutil.Audio;
import system.Movement;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Resource {
	
	// Images
	public static Image background = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/background/forest.jpg")).getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT))
					.getImage();
	public static Image background2 = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/background/mountain.jpg")).getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT))
					.getImage();
	public static Image background3 = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/background/space.jpg")).getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT))
					.getImage();
	public static Image ring = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/ring.gif")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	public static Image img = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/character/tails_fly.gif")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))
					.getImage();
	public static Image bird = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/enemy/bird.gif")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)).getImage();
	public static Image effect = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/effect.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	public static Image img2 = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/character/tails.gif")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))
					.getImage();
	public static Image fireball = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/enemy/fireball.gif")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))
					.getImage();
	public static Image portion = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/item/portion.gif")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	// item
	public static List<Item> imgList = new Vector<>();

	// portion
	public static List<Item> portionList = new Vector<>();

	// background
	public static int back1X = 0;
	public static int back2X = background.getWidth(null);
	public static int speed = 5;
	public static int runPage = 0;
	public static int mapLength = 0;

	// character
	public static Movement character = new Movement(img, 150, 150, 255, false, 1000);

	// delay
	public static Delay delay = new Delay();

	// score
	public static GameScore score = new GameScore();

	// pause
	public static boolean pause = false;

	// fade
	public static Color backFade = new Color(0, 0, 0, 0);

	// enemy
	public static List<Enemy> enemyList = new Vector<>();

	// audio
	public static Audio audio = new Audio();
	public static boolean isAudioPlaying = false;

}
