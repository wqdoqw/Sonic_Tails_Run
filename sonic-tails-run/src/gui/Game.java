package gui;

import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dto.Enemy;
import dto.Item;
import system.EnemySystem;
import system.ItemSystem;
import system.LoadMap;
import system.PauseSystem;
import system.PortionSystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gameutil.GameTimer;
import gameutil.KeyboardHandler;
import system.Background;
import system.EndGameSystem;

import static resource.Resource.*;
/**
 * 
 * @author Sang Ik Park
 *
 *
 */
@SuppressWarnings("serial")
public class Game extends JPanel {
	private GameTimer timer = new GameTimer();
	private JFrame frame;
	private CardLayout card;
	private Image bufferedImage;
	private Graphics buffg;
	private int[][] colorArr;
	private int[] sizeArr;
	private JButton pButton;
	private AlphaComposite alphaComposite;
	private String path = "/map/firstmap.png";

	public Game(JFrame frame, CardLayout card) {
		this.frame = frame;
		this.card = card;
		setLayout(null);

		// pause component
		pButton = new JButton("Undo");
		pButton.setBounds(350, 220, 100, 30);
		pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remove(pButton);
				pause = false;
			}
		});
		KeyboardHandler keyboard = new KeyboardHandler(this, pButton);
		addKeyListener(keyboard);

		initMap();

		setFocusable(true);
		requestFocus();
	}

	public void initMap() {
		try {
			sizeArr = LoadMap.getSize(getClass().getResource(path));
			colorArr = LoadMap.getPic(getClass().getResource(path));
		} catch (Exception e) {
			System.out.println("Cannot load map");
			e.printStackTrace();
		}
		int maxX = sizeArr[0];
		int maxY = sizeArr[1];
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (colorArr[i][j] == 16776960) { // decimal value of yellow color
					imgList.add(new Item(ring, 0, i * 40, j * 40, 255));
				} else if (colorArr[i][j] == 15539236) { // decimal value of red color
					enemyList.add(new Enemy(bird, 0, i * 40, j * 40));
				} else if (colorArr[i][j] == 11920925) { // decimal value of green color
					enemyList.add(new Enemy(fireball, 0, i * 40, j * 40));
				} else if (colorArr[i][j] == 0) { // decimal value of black color
					portionList.add(new Item(portion, 0, i * 40, j * 40, 255));
				}
			}
		}
	}

	public void start() {
		// main control thread
		new Thread(new Runnable() {

			@Override
			public void run() {
				timer.start();
				if (!isAudioPlaying) {
					audio.playAudio();
					isAudioPlaying = true;
				}
				while (true) {
					Background.moveBackGround();
					new ItemSystem().displayItem(character.getX(), character.getY());
					new PauseSystem().pause();
					new EnemySystem().displayEnemy(character.getX(), character.getY());
					new PortionSystem().portion(character.getX(), character.getY());
					if (new EndGameSystem().end(frame, card)) {
						audio.stopAudio();
						isAudioPlaying = false;
						return;
					}
					repaint();
					try {
						Thread.sleep(delay.getDelay());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (buffg == null) {
			bufferedImage = createImage(this.getWidth(), this.getHeight());
			if (bufferedImage == null) {
				System.out.println("Buffered Image Failed");
			} else {
				buffg = bufferedImage.getGraphics();
			}
		}

		// background
		buffg.drawImage(background, back1X, 0, this);
		buffg.drawImage(background, back2X, 0, this);

		// util
		buffg.setColor(Color.BLACK);
//		buffg.drawString(timer.getTime(), 15, 15); // Debugging purpose
		buffg.setColor(Color.RED);
		buffg.setFont(new Font("굴림", Font.BOLD, 20));
		buffg.drawString("Score: " + score.getScore(), 625, 30);
		buffg.setFont(new Font("굴림", Font.BOLD, 15));
		buffg.drawString("Current Delay: " + delay.getDelay(), 0, 15);

		// item
		for (int i = 0; i < imgList.size(); i++) {
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					(float) imgList.get(i).getAlpha() / 255);
			g2.setComposite(alphaComposite);
			buffg.drawImage(imgList.get(i).getImage(), imgList.get(i).getX(), imgList.get(i).getY(), this);
		}

		// enemy
		for (int i = 0; i < enemyList.size(); i++) {
			buffg.drawImage(enemyList.get(i).getImage(), enemyList.get(i).getX(), enemyList.get(i).getY(), this);
		}

		// portion
		for (int i = 0; i < portionList.size(); i++) {
			buffg.drawImage(portionList.get(i).getImage(), portionList.get(i).getX(), portionList.get(i).getY(), this);
		}

		// health Bar
		double num = (double) character.getHealth() / (double) 1000;
		int percentage = (int) (num * 500);

		buffg.setColor(Color.BLACK);
		buffg.fillRoundRect(50, 25, 500, 30, 25, 25);
		buffg.setColor(Color.RED);
		buffg.fillRoundRect(50, 25, percentage, 30, 25, 25);
		buffg.setColor(Color.BLACK);
		buffg.drawRoundRect(50, 25, percentage, 30, 25, 25);

		// character hit
		if (character.isHit()) {

			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) character.getAlpha() / 255);
			g2.setComposite(alphaComposite);
			// character
			buffg.drawImage(character.getImage(), character.getX(), character.getY(), 100, 100, this);
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 255 / 255);
			g2.setComposite(alphaComposite);
		} else {
			// character
			buffg.drawImage(img, character.getX(), character.getY(), 100, 100, this);
		}
		// pause
		if (pause) {

			// alpha 값 조정
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 100 / 255);
			g2.setComposite(alphaComposite);

			buffg.setColor(Color.BLACK);

			buffg.fillRect(0, 0, 850, 550);

			// alpha 값 되돌리기
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 255 / 255);
			g2.setComposite(alphaComposite);
		}

		// fade 맨마지막에 있어야함
		buffg.setColor(backFade);
		buffg.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.drawImage(bufferedImage, 0, 0, this);
	}

}
