package resource;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import dto.Character;
import dto.Delay;
import dto.Enemy;
import dto.GameScore;
import dto.Item;
import dto.LeaderBoard;
import gameutil.Audio;
import gui.SelectionPanel;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Resource {

	// Images
	public static Image background = new ImageIcon(new ImageIcon(Resource.class.getResource("/background/forest.jpg"))
			.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT)).getImage();
	public static Image background2 = new ImageIcon(
			new ImageIcon(Resource.class.getResource("/background/mountain.jpg")).getImage().getScaledInstance(800, 500,
					Image.SCALE_DEFAULT)).getImage();
	public static Image background3 = new ImageIcon(new ImageIcon(Resource.class.getResource("/background/space.jpg"))
			.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT)).getImage();
	public static Image ring = new ImageIcon(new ImageIcon(Resource.class.getResource("/ring.gif")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	public static Image img = new ImageIcon(new ImageIcon(Resource.class.getResource("/character/tails_fly.gif"))
			.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)).getImage();
	public static Image bird = new ImageIcon(new ImageIcon(Resource.class.getResource("/enemy/bird.gif")).getImage()
			.getScaledInstance(100, 100, Image.SCALE_DEFAULT)).getImage();
	public static Image effect = new ImageIcon(new ImageIcon(Resource.class.getResource("/effect.png")).getImage()
			.getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	public static Image img2 = new ImageIcon(new ImageIcon(Resource.class.getResource("/character/tails.gif"))
			.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();
	public static Image fireball = new ImageIcon(new ImageIcon(Resource.class.getResource("/enemy/fireball.gif"))
			.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)).getImage();
	public static Image portion = new ImageIcon(new ImageIcon(Resource.class.getResource("/item/portion.gif"))
			.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)).getImage();

	// selection panel
	public static ImageIcon easyMap = new ImageIcon(
			new ImageIcon(SelectionPanel.class.getResource("/selection/easy.png")).getImage().getScaledInstance(200,
					200, Image.SCALE_DEFAULT));
	public static ImageIcon easyMapSelected = new ImageIcon(
			new ImageIcon(SelectionPanel.class.getResource("/selection/selectedeasy.png")).getImage()
					.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	public static ImageIcon hardMap = new ImageIcon(
			new ImageIcon(SelectionPanel.class.getResource("/selection/hard.png")).getImage().getScaledInstance(200,
					200, Image.SCALE_DEFAULT));
	public static ImageIcon hardMapSelected = new ImageIcon(
			new ImageIcon(SelectionPanel.class.getResource("/selection/selectedhard.png")).getImage()
					.getScaledInstance(200, 200, Image.SCALE_DEFAULT));

	// map
	public static String path = null;
	public static String easyMapPath = "/map/easymap.png";
	public static String hardMapPath = "/map/hardmap.png";

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
	public static Character character = new Character(img, 150, 150, 255, false, 1000);

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

	// end
	public static boolean end = false;

	// screenshot
	public static File currentFile = new File("");

	// leader board
	public static List<LeaderBoard> leaderBoardList = new Vector<>();

	// database
	public static boolean isDBOn = true;
}
