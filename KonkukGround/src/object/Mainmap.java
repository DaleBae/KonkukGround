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
	private Image img, img1;
	private int[][] EntireMap;
	private int[][] PartMap;
	private int xCount;
	private int yCount;

	Mainmap() {
		xCount = 0;
		yCount = 0;
		EntireMap = new int[40][40];
		EntireMap[5][6] = 1;
		EntireMap[5][15] = 1;
		PartMap = new int[10][10];
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				PartMap[i][j] = EntireMap[i][j];
			}
		}
		tool = Toolkit.getDefaultToolkit();
		img = tool.getImage("images//test.png");
		img1=tool.getImage("images/Tile1.png");
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
					if (yCount==0||EntireMap[xCount + (ch.getPosX() / 40)][(yCount - 1) + (ch.getPosY() / 40)] == 0) {
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
					break;
				case KeyEvent.VK_DOWN:
					if (yCount==30||EntireMap[xCount + (ch.getPosX() / 40)][(yCount + 1) + (ch.getPosY() / 40)] == 0) {
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
					break;
				case KeyEvent.VK_LEFT:
					if (xCount==0||EntireMap[(xCount - 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 0) {
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
					break;
				case KeyEvent.VK_RIGHT:
					if (xCount==30||EntireMap[(xCount + 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] == 0) {
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
				if (PartMap[i][j] == 1) {
					g.drawImage(img1,i*40,j*40,40,40,this);
				}
			}
		}
		g.drawImage(img, ch.getPosX(), ch.getPosY(), 40, 40, this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}