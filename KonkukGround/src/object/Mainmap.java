package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

import object.Character;

public class Mainmap extends JPanel {
	private Character ch;
	private Toolkit tool;
	private Image[] Tileimg;
	private Image[] chimg;
	private int[][] EntireMap;
	private int[][] PartMap;
	private int xCount;
	private int yCount;
	private JLabel txt;

	Mainmap() {
		this.setBackground(Color.black);
		Map_init();
		txt_init();
		Image_init();
		ch = new Character();
		this.setLayout(null);
		this.add(txt);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
	}

	// Tile �迭 ���� ���� ��ġ
	public void doDrawing(Graphics g) {
		// �⺻ �� ����
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				g.drawImage(Tileimg[PartMap[i][j]], j * 40, i * 40, 40, 40, this);
			}
		}
		drawCharacter(g);

	}

	// ĳ���� ������ �� ���⿡ ���� �̹��� ����
	public void drawCharacter(Graphics g) {
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

	// Map �ʱ�ȭ
	public void Map_init() {
		xCount = 0;
		yCount = 0;
		EntireMap = new int[40][60];
		getMap();
		PartMap = new int[10][10];
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				PartMap[i][j] = EntireMap[i][j];
			}
		}
	}

	// Tile,Ch �̹��� �迭 ���� �� �̹��� ����
	public void Image_init() {
		tool = Toolkit.getDefaultToolkit();
		Tileimg = new Image[14];
		Tileimg[0] = tool.getImage("images/Ǯ0.png");
		Tileimg[1] = tool.getImage("images/��Ÿ��1.png");
		Tileimg[2] = tool.getImage("images/��Ÿ��2.png");
		Tileimg[3] = tool.getImage("images/��Ÿ��3.png");
		Tileimg[4] = tool.getImage("images/��Ÿ��4.png");
		Tileimg[5] = tool.getImage("images/��Ÿ��5.png");
		Tileimg[6] = tool.getImage("images/��Ÿ��6.png");
		Tileimg[7] = tool.getImage("images/��7.png");
		Tileimg[8] = tool.getImage("images/�ǹ���8.png");
		Tileimg[9] = tool.getImage("images/����9.png");
		Tileimg[10] = tool.getImage("images/���10.png");
		Tileimg[11] = tool.getImage("images/�ϰ�ȣ11.png");
		Tileimg[12] = tool.getImage("images/��12.png");
		Tileimg[13] = tool.getImage("images/����13.png");
		chimg = new Image[8];
		chimg[0] = tool.getImage("images//chfront.png");
		chimg[1] = tool.getImage("images//chback.png");
		chimg[2] = tool.getImage("images//chleft.png");
		chimg[3] = tool.getImage("images//chright.png");
		chimg[4] = tool.getImage("images//duck_front.png");
		chimg[5] = tool.getImage("images//duck_back.png");
		chimg[6] = tool.getImage("images//duck_left.png");
		chimg[7] = tool.getImage("images//duck_right.png");
	}

	// Text �ʱ�ȭ
	public void txt_init() {
		txt = new JLabel();
		Font font = new Font("Fixedsys", Font.BOLD, 20);
		txt.setForeground(Color.white);
		txt.setFont(font);
		txt.setSize(419, 90);
		txt.setLocation(new Point(0, 398));
	}

	public void txt_change() {
		String str;
		str = "Normal";
		if (checkTile(12)) {
			int[] a = new int[2];
			a = getTile();
			if (a[0] == 11 && a[1] == 6) {
				str = "<html>[���㿬����]<br/>�ݰ����ϴ�<br/>������ [Enter]</html>";
			}
		}

		if (ch.getlandornot()) {
			str = "<html>[�ϰ�ȣ]<br/>�Ǳ����б��� ��¡���� ȣ��<br/>�� ���ε��� ��å �ڽ��� ���� ��</html>";
		}
		txt.setText(str);

	}

	// ����Ű �Է¿� ���� KeyAdapter
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				if (!upcheckTile(-1) && !upcheckTile(1) && !upcheckTile(2) && !upcheckTile(3) && !upcheckTile(4)
						&& !upcheckTile(5) && !upcheckTile(6) && !upcheckTile(8) && !upcheckTile(9)) {
					if (yCount > 0 && ch.getPosY() == 160) {
						yCount--;
						for (int i = 0; i < PartMap.length; i++) {
							for (int j = 0; j < PartMap[i].length; j++) {
								PartMap[i][j] = EntireMap[i + yCount][j + xCount];
							}
						}
					} else {
						ch.moveUp();
					}
				} else {
				}

				ch.setdir(1);
				break;
			case KeyEvent.VK_DOWN:
				if (!downcheckTile(-1) && !downcheckTile(1) && !downcheckTile(2) && !downcheckTile(3)
						&& !downcheckTile(4) && !downcheckTile(5) && !downcheckTile(6) && !downcheckTile(8)
						&& !downcheckTile(9)) {
					if (yCount < 30 && ch.getPosY() == 160) {
						yCount++;
						for (int i = 0; i < PartMap.length; i++) {
							for (int j = 0; j < PartMap[i].length; j++) {
								PartMap[i][j] = EntireMap[i + yCount][j + xCount];
							}
						}
					} else {
						ch.moveDown();
					}
				} else {
				}
				ch.setdir(0);
				break;
			case KeyEvent.VK_LEFT:
				if (!leftcheckTile(-1) && !leftcheckTile(1) && !leftcheckTile(2) && !leftcheckTile(3)
						&& !leftcheckTile(4) && !leftcheckTile(5) && !leftcheckTile(6) && !leftcheckTile(8)
						&& !leftcheckTile(9)) {
					if (xCount > 0 && ch.getPosX() == 160) {
						xCount--;
						for (int i = 0; i < PartMap.length; i++) {
							for (int j = 0; j < PartMap[i].length; j++) {
								PartMap[i][j] = EntireMap[i + yCount][j + xCount];
							}
						}
					} else {
						ch.moveLeft();
					}
				} else {
				}
				ch.setdir(2);
				break;
			case KeyEvent.VK_RIGHT:
				if (!rightcheckTile(-1) && !rightcheckTile(1) && !rightcheckTile(2) && !rightcheckTile(3)
						&& !rightcheckTile(4) && !rightcheckTile(5) && !rightcheckTile(6) && !rightcheckTile(8)
						&& !rightcheckTile(9)) {
					if (xCount < 50 && ch.getPosX() == 160) {
						xCount++;
						for (int i = 0; i < PartMap.length; i++) {
							for (int j = 0; j < PartMap[i].length; j++) {
								PartMap[i][j] = EntireMap[i + yCount][j + xCount];
							}
						}
					} else {
						ch.moveRight();
					}
				} else {
				}
				ch.setdir(3);
				break;

			case KeyEvent.VK_ENTER:
				if (checkTile(12)) {
					JOptionPane.showMessageDialog(null, "�⺻ �˸�â�Դϴ�.");
				}
				break;

			}
			if (checkTile(11)) {
				ch.setlandornot(true);
			} else {
				ch.setlandornot(false);
			}
			txt_change();
			repaint();
		}
	}

	public void getMap() {
		int[][] Maptmp = new int[40][60];
		int i = 0;
		Scanner scan;
		try {
			scan = new Scanner(new File("images//Map.txt"));
			while (scan.hasNextInt()) {
				int j = 0;
				while (j < 60) {
					int temp = scan.nextInt();
					Maptmp[i][j] = temp;
					j++;
				}
				i++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntireMap = Maptmp;
	}

	public boolean checkTile(int n) {
		if (EntireMap[yCount + (ch.getPosY() / 40)][xCount + (ch.getPosX() / 40)] == n) {
			return true;
		} else {
			return false;
		}
	}

	public boolean upcheckTile(int n) {
		if (EntireMap[(yCount - 1) + (ch.getPosY() / 40)][xCount + (ch.getPosX() / 40)] == n) {
			return true;
		} else {
			return false;
		}

	}

	public boolean downcheckTile(int n) {
		if (EntireMap[(yCount + 1) + (ch.getPosY() / 40)][xCount + (ch.getPosX() / 40)] == n) {
			return true;
		} else {
			return false;
		}
	}

	public boolean leftcheckTile(int n) {
		if (EntireMap[yCount + (ch.getPosY() / 40)][(xCount - 1) + (ch.getPosX() / 40)] == n) {
			return true;
		} else {
			return false;
		}
	}

	public boolean rightcheckTile(int n) {
		if (EntireMap[yCount + (ch.getPosY() / 40)][(xCount + 1) + (ch.getPosX() / 40)] == n) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getTile() {
		int[] a = new int[2];
		a[0] = yCount + (ch.getPosY() / 40);
		a[1] = xCount + (ch.getPosX() / 40);
		return a;
	}
}