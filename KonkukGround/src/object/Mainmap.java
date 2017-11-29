package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import object.Character;

public class Mainmap extends JPanel {
	Character ch;
	private Toolkit tool;
	private Image[] Tileimg;
	private Image[] chimg;
	private int[][] EntireMap;
	private int[][] PartMap;
	private int xCount;
	private int yCount;

	Mainmap() {
		xCount = 0;
		yCount = 0;
		EntireMap = new int[40][40];
		for (int i = 0; i < EntireMap[4].length; i++) {
			EntireMap[4][i] = 2;
			EntireMap[i][4] = 2;
		}
		for (int i = 5; i < 10; i++) {
			for (int j = 5; j < 10; j++) {
				EntireMap[i][j] = 1;
			}
		}
		PartMap = new int[10][10];
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				PartMap[i][j] = EntireMap[i][j];
			}
		}
		tool = Toolkit.getDefaultToolkit();
		Tileimg = new Image[10];
		Tileimg[0] = tool.getImage("images/Tile0.png");
		Tileimg[1] = tool.getImage("images/Tile1.png");
		Tileimg[2] = tool.getImage("images/Tile2.png");
		chimg = new Image[8];
		chimg[0] = tool.getImage("images//chfront.png");
		chimg[1] = tool.getImage("images//chback.png");
		chimg[2] = tool.getImage("images//chleft.png");
		chimg[3] = tool.getImage("images//chright.png");
		chimg[4] = tool.getImage("images//duck_front.png");
		chimg[5] = tool.getImage("images//duck_back.png");
		chimg[6] = tool.getImage("images//duck_left.png");
		chimg[7] = tool.getImage("images//duck_right.png");
		ch = new Character();
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.setLayout(null);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (yCount == 0
							|| EntireMap[xCount + (ch.getPosX() / 40)][(yCount - 1) + (ch.getPosY() / 40)] != -1) {
						if (yCount > 0 && ch.getPosY() == 160) {
							yCount--;
							for (int i = 0; i < PartMap.length; i++) {
								for (int j = 0; j < PartMap[i].length; j++) {
									PartMap[i][j] = EntireMap[i + xCount][j + yCount];
								}
							}
						} else {
							ch.moveUp();
						}
					} else {
					}
					ch.setdir(1);
					if (EntireMap[xCount + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 1) {
						ch.setlandornot(true);
					} else {
						ch.setlandornot(false);
					}
					break;
				case KeyEvent.VK_DOWN:
					if (yCount == 30
							|| EntireMap[xCount + (ch.getPosX() / 40)][(yCount + 1) + (ch.getPosY() / 40)] != -1) {
						if (yCount < 30 && ch.getPosY() == 160) {
							yCount++;
							for (int i = 0; i < PartMap.length; i++) {
								for (int j = 0; j < PartMap[i].length; j++) {
									PartMap[i][j] = EntireMap[i + xCount][j + yCount];
								}
							}
						} else {
							ch.moveDown();
						}
					} else {
					}
					ch.setdir(0);
					if (EntireMap[xCount + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 1) {
						ch.setlandornot(true);
					} else {
						ch.setlandornot(false);
					}
					break;
				case KeyEvent.VK_LEFT:
					if (xCount == 0
							|| EntireMap[(xCount - 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] != -1) {
						if (xCount > 0 && ch.getPosX() == 160) {
							xCount--;
							for (int i = 0; i < PartMap.length; i++) {
								for (int j = 0; j < PartMap[i].length; j++) {
									PartMap[i][j] = EntireMap[i + xCount][j + yCount];
								}
							}
						} else {
							ch.moveLeft();
						}
					} else {
					}
					ch.setdir(2);
					if (EntireMap[xCount + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 1) {
						ch.setlandornot(true);
					} else {
						ch.setlandornot(false);
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (xCount == 30
							|| EntireMap[(xCount + 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] != -1) {
						if (xCount < 30 && ch.getPosX() == 160) {
							xCount++;
							for (int i = 0; i < PartMap.length; i++) {
								for (int j = 0; j < PartMap[i].length; j++) {
									PartMap[i][j] = EntireMap[i + xCount][j + yCount];
								}
							}
						} else {
							ch.moveRight();
						}
					} else {
					}
					ch.setdir(3);
					if (EntireMap[xCount + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 1) {
						ch.setlandornot(true);
					} else {
						ch.setlandornot(false);
					}
					break;
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void doDrawing(Graphics g) {
		// ±âº» ¸Ê »ý¼º
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap.length; j++) {
				g.drawImage(Tileimg[PartMap[i][j]], i * 40, j * 40, 40, 40, this);
			}
		}
		switch (ch.getdir()) {
		case 0:
			if (ch.getlandornot()) {
				g.drawImage(chimg[4], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				g.drawImage(chimg[0], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 1:
			if (ch.getlandornot()) {
				g.drawImage(chimg[5], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				g.drawImage(chimg[1], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 2:
			if (ch.getlandornot()) {
				g.drawImage(chimg[6], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				g.drawImage(chimg[2], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 3:
			if (ch.getlandornot()) {
				g.drawImage(chimg[7], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				g.drawImage(chimg[3], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}