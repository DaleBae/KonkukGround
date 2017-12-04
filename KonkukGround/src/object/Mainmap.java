package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

import object.Character;

public class Mainmap extends JPanel implements KeyListener {
	private Character ch;
	private Toolkit tool;
	private Image[] img;
	private Image[] Tileimg;
	private Image[] chimg;
	private int[][] EntireMap;
	private int[][] PartMap;
	private int xCount;
	private int yCount;
	private int result; // �ɼ�â�� ��� ���� �޾ƿ���
	private boolean flag; // ���� ó�� ���� ������ Ȯ���ϴ� ����
	
	private mainMapListener listener;
	
	Mainmap(Character ch, mainMapListener listener) {
		this.setBackground(Color.black);
		Map_init();
		Image_init();
		xCount = 11;
		flag = true;
		this.ch = ch;
		this.setLayout(null);
		this.setFocusable(true);
		this.listener = listener;
		// this.addKeyListener(new MyKeyAdapter());
	}

	// Tile �迭 ���� ���� ��ġ
	public void doDrawing(Graphics g) {
		// �⺻ �� ����
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				g.drawImage(Tileimg[PartMap[i][j]], j * 40, i * 40, 40, 40, this);
			}
		}
		int a=ch.getHP();
		int acount=a/40;
		g.drawImage(img[1], 0, 0, 40, 40, this);

		for(int i=0;i<acount;i++) {
			g.drawImage(img[0], 40+(i * 40), 0, 40, 40, this);
		}
		g.drawImage(img[0], 40+(acount*40), 0, (a%40),40,this);

		drawCharacter(g);

	}

	// ĳ���� ������ �� ���⿡ ���� �̹��� ����
	public void drawCharacter(Graphics g) {
		switch (ch.getdir()) {
		case 0:
			if (ch.getlandornot()) {
				flag = false;
				g.drawImage(chimg[4], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag = true;
				g.drawImage(chimg[0], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 1:
			if (ch.getlandornot()) {
				flag = false;
				g.drawImage(chimg[5], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag = true;
				g.drawImage(chimg[1], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 2:
			if (ch.getlandornot()) {
				flag = false;
				g.drawImage(chimg[6], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag = true;
				g.drawImage(chimg[2], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 3:
			if (ch.getlandornot()) {
				flag = false;
				g.drawImage(chimg[7], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag = true;
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
		PartMap = new int[15][20];
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				PartMap[i][j] = EntireMap[i][j + 11];
			}
		}
	}

	// Tile,Ch �̹��� �迭 ���� �� �̹��� ����
	public void Image_init() {
		tool = Toolkit.getDefaultToolkit();
		Tileimg = new Image[45];
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
		Tileimg[14] = tool.getImage("images/�౸��14.png");
		Tileimg[15] = tool.getImage("images/�౸��15.png");
		Tileimg[16] = tool.getImage("images/�౸��16.png");
		Tileimg[17] = tool.getImage("images/�౸��17.png");
		Tileimg[18] = tool.getImage("images/�౸��18.png");
		Tileimg[19] = tool.getImage("images/�౸��19.png");
		Tileimg[20] = tool.getImage("images/�౸��20.png");
		Tileimg[21] = tool.getImage("images/�౸��21.png");
		Tileimg[22] = tool.getImage("images/�౸��22.png");
		Tileimg[23] = tool.getImage("images/�౸��23.png");
		Tileimg[24] = tool.getImage("images/�౸��24.png");
		Tileimg[25] = tool.getImage("images/�౸��25.png");
		Tileimg[26] = tool.getImage("images/�౸��26.png");
		Tileimg[27] = tool.getImage("images/�౸��27.png");
		Tileimg[28] = tool.getImage("images/�౸��28.png");
		Tileimg[29] = tool.getImage("images/�౸��29.png");
		Tileimg[30] = tool.getImage("images/�౸��30.png");
		Tileimg[31] = tool.getImage("images/�౸��31.png");
		Tileimg[32] = tool.getImage("images/�౸��32.png");
		Tileimg[33] = tool.getImage("images/�౸��33.png");
		Tileimg[34] = tool.getImage("images/�౸��34.png");
		Tileimg[35] = tool.getImage("images/�౸��35.png");
		Tileimg[36] = tool.getImage("images/�౸��36.png");
		Tileimg[37] = tool.getImage("images/�౸��37.png");
		Tileimg[38] = tool.getImage("images/�౸��38.png");
		Tileimg[39] = tool.getImage("images/�౸��39.png");
		Tileimg[40] = tool.getImage("images/�౸��40.png");
		Tileimg[41] = tool.getImage("images/�౸��41.png");
		Tileimg[42] = tool.getImage("images/�౸��42.png");
		Tileimg[43] = tool.getImage("images/�౸��43.png");
		Tileimg[44] = tool.getImage("images/�౸��44.png");
		chimg = new Image[8];
		chimg[0] = tool.getImage("images//chfront.png");
		chimg[1] = tool.getImage("images//chback.png");
		chimg[2] = tool.getImage("images//chleft.png");
		chimg[3] = tool.getImage("images//chright.png");
		chimg[4] = tool.getImage("images//duck_front.png");
		chimg[5] = tool.getImage("images//duck_back.png");
		chimg[6] = tool.getImage("images//duck_left.png");
		chimg[7] = tool.getImage("images//duck_right.png");
		img = new Image[2];
		img[0] = tool.getImage("images//������.png");
		img[1] = tool.getImage("images//��Ʈ.png");
	}

	public void txt_change(KeyEvent e_temp) {
		result = JOptionPane.YES_OPTION;
		int[] a = new int[2];
		int doornum = -1;
		if (checkTile(12)) {
			a = getTile();
			if (a[0] == 11 && a[1] == 6) {
				result = JOptionPane.showConfirmDialog(null, "<html>[���㿬����]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 1;
			} else if (a[0] == 11 && a[1] == 16) {
				result = JOptionPane.showConfirmDialog(null, "<html>[�濵��]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 2;
			} else if (a[0] == 13 && a[1] == 36) {
				result = JOptionPane.showConfirmDialog(null, "<html>[�ε�����]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 3;
			} else if (a[0] == 17 && a[1] == 25) {
				result = JOptionPane.showConfirmDialog(null, "<html>[��õ���]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 4;
			} else if (a[0] == 19 && a[1] == 14) {
				result = JOptionPane.showConfirmDialog(null, "<html>[������ڹ���]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>",
						null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 5;
			} else if (a[0] == 23 && a[1] == 5) {
				result = JOptionPane.showConfirmDialog(null, "<html>[������ȭ����]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 6;
			} else if (a[0] == 28 && a[1] == 14) {
				result = JOptionPane.showConfirmDialog(null, "<html>[���������]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 7;
			} else if (a[0] == 36 && a[1] == 13) {
				result = JOptionPane.showConfirmDialog(null, "<html>[���д���]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 8;
			} else if (a[0] == 25 && a[1] == 31) {
				result = JOptionPane.showConfirmDialog(null, "<html>[�л�ȸ��]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 9;
			} else if (a[0] == 30 && a[1] == 43) {
				result = JOptionPane.showConfirmDialog(null, "<html>[��������]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 10;
			} else if (a[0] == 30 && a[1] == 52) {
				result = JOptionPane.showConfirmDialog(null, "<html>[�Ű��а�]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 11;
			} else if (a[0] == 36 && a[1] == 47) {
				result = JOptionPane.showConfirmDialog(null, "<html>[���Ͽ콺]<br/>�ݰ����ϴ�<br/>������ \"��[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 12;
			}

		}
		if (ch.getlandornot() && flag) {
			result = JOptionPane.showConfirmDialog(null,
					"<html>[�ϰ�ȣ]<br/>�Ǳ����б��� ��¡���� ȣ��<br/>�� ���ε��� ��å �ڽ��� ���� ��" + "<br/>���ðڽ��ϱ� ?</html>", null,
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
		if (result == JOptionPane.YES_OPTION) {
			if (doornum > 0) {
				System.out.println(doornum);
				listener.startGame(doornum);
			}
		} else {
			key_reject(e_temp);
		}

	}

	
	
	interface mainMapListener{
		void startGame(int doorNum);
	}
	
	// txt_change���� ������ �ؽ�Ʈ�� Yes�� Ŭ������ �ʾ������ �ǵ�����
	public void key_reject(KeyEvent e_temp) {
		Robot robot;
		try {
			robot = new Robot();
			switch (e_temp.getKeyCode()) {
			case KeyEvent.VK_UP:
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				break;
			case KeyEvent.VK_DOWN:
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
				break;
			case KeyEvent.VK_LEFT:
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
				break;
			case KeyEvent.VK_RIGHT:
				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);
				break;
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (!upcheckTile(-1) && !upcheckTile(1) && !upcheckTile(2) && !upcheckTile(3) && !upcheckTile(4)
					&& !upcheckTile(5) && !upcheckTile(6) && !upcheckTile(8) && !upcheckTile(9)) {
				if (yCount > 0 && ch.getPosY() == 240) {
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
			if (!downcheckTile(-1) && !downcheckTile(1) && !downcheckTile(2) && !downcheckTile(3) && !downcheckTile(4)
					&& !downcheckTile(5) && !downcheckTile(6) && !downcheckTile(8) && !downcheckTile(9)) {
				if (yCount < 25 && ch.getPosY() == 240) {
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
			if (!leftcheckTile(-1) && !leftcheckTile(1) && !leftcheckTile(2) && !leftcheckTile(3) && !leftcheckTile(4)
					&& !leftcheckTile(5) && !leftcheckTile(6) && !leftcheckTile(8) && !leftcheckTile(9)) {
				if (xCount > 0 && ch.getPosX() == 320) {
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
				if (xCount < 40 && ch.getPosX() == 320) {
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

		}
		if (checkTile(11)) {
			ch.setlandornot(true);
		} else {
			ch.setlandornot(false);
		}
		txt_change(e);
		int temp=ch.getHP();
		ch.setHP(temp-1);
		if(temp/40==2&&temp%40==20) {
			JOptionPane.showMessageDialog(null, "<html>ü���� 50%�Դϴ�.<br/>�л�ȸ������ �Ļ縦 �ϰų�<br/>����翡�� �޽��� ���ϼ��� !</html>");
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
}