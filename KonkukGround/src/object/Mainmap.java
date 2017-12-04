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
	private int result; // 옵션창의 결과 값을 받아오기
	private boolean flag; // 물에 처음 들어온 것인지 확인하는 변수
	
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

	// Tile 배열 값에 따른 배치
	public void doDrawing(Graphics g) {
		// 기본 맵 생성
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

	// 캐릭터 포지션 및 방향에 따른 이미지 삽입
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

	// Map 초기화
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

	// Tile,Ch 이미지 배열 생성 및 이미지 설정
	public void Image_init() {
		tool = Toolkit.getDefaultToolkit();
		Tileimg = new Image[45];
		Tileimg[0] = tool.getImage("images/풀0.png");
		Tileimg[1] = tool.getImage("images/울타리1.png");
		Tileimg[2] = tool.getImage("images/울타리2.png");
		Tileimg[3] = tool.getImage("images/울타리3.png");
		Tileimg[4] = tool.getImage("images/울타리4.png");
		Tileimg[5] = tool.getImage("images/울타리5.png");
		Tileimg[6] = tool.getImage("images/울타리6.png");
		Tileimg[7] = tool.getImage("images/길7.png");
		Tileimg[8] = tool.getImage("images/건물몸8.png");
		Tileimg[9] = tool.getImage("images/지붕9.png");
		Tileimg[10] = tool.getImage("images/운동장10.png");
		Tileimg[11] = tool.getImage("images/일감호11.png");
		Tileimg[12] = tool.getImage("images/문12.png");
		Tileimg[13] = tool.getImage("images/공백13.png");
		Tileimg[14] = tool.getImage("images/축구장14.png");
		Tileimg[15] = tool.getImage("images/축구장15.png");
		Tileimg[16] = tool.getImage("images/축구장16.png");
		Tileimg[17] = tool.getImage("images/축구장17.png");
		Tileimg[18] = tool.getImage("images/축구장18.png");
		Tileimg[19] = tool.getImage("images/축구장19.png");
		Tileimg[20] = tool.getImage("images/축구장20.png");
		Tileimg[21] = tool.getImage("images/축구장21.png");
		Tileimg[22] = tool.getImage("images/축구장22.png");
		Tileimg[23] = tool.getImage("images/축구장23.png");
		Tileimg[24] = tool.getImage("images/축구장24.png");
		Tileimg[25] = tool.getImage("images/축구장25.png");
		Tileimg[26] = tool.getImage("images/축구장26.png");
		Tileimg[27] = tool.getImage("images/축구장27.png");
		Tileimg[28] = tool.getImage("images/축구장28.png");
		Tileimg[29] = tool.getImage("images/축구장29.png");
		Tileimg[30] = tool.getImage("images/축구장30.png");
		Tileimg[31] = tool.getImage("images/축구장31.png");
		Tileimg[32] = tool.getImage("images/축구장32.png");
		Tileimg[33] = tool.getImage("images/축구장33.png");
		Tileimg[34] = tool.getImage("images/축구장34.png");
		Tileimg[35] = tool.getImage("images/축구장35.png");
		Tileimg[36] = tool.getImage("images/축구장36.png");
		Tileimg[37] = tool.getImage("images/축구장37.png");
		Tileimg[38] = tool.getImage("images/축구장38.png");
		Tileimg[39] = tool.getImage("images/축구장39.png");
		Tileimg[40] = tool.getImage("images/축구장40.png");
		Tileimg[41] = tool.getImage("images/축구장41.png");
		Tileimg[42] = tool.getImage("images/축구장42.png");
		Tileimg[43] = tool.getImage("images/축구장43.png");
		Tileimg[44] = tool.getImage("images/축구장44.png");
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
		img[0] = tool.getImage("images//게이지.png");
		img[1] = tool.getImage("images//하트.png");
	}

	public void txt_change(KeyEvent e_temp) {
		result = JOptionPane.YES_OPTION;
		int[] a = new int[2];
		int doornum = -1;
		if (checkTile(12)) {
			a = getTile();
			if (a[0] == 11 && a[1] == 6) {
				result = JOptionPane.showConfirmDialog(null, "<html>[상허연구관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 1;
			} else if (a[0] == 11 && a[1] == 16) {
				result = JOptionPane.showConfirmDialog(null, "<html>[경영관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 2;
			} else if (a[0] == 13 && a[1] == 36) {
				result = JOptionPane.showConfirmDialog(null, "<html>[부동산학]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 3;
			} else if (a[0] == 17 && a[1] == 25) {
				result = JOptionPane.showConfirmDialog(null, "<html>[새천년관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 4;
			} else if (a[0] == 19 && a[1] == 14) {
				result = JOptionPane.showConfirmDialog(null, "<html>[상허기념박물관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>",
						null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 5;
			} else if (a[0] == 23 && a[1] == 5) {
				result = JOptionPane.showConfirmDialog(null, "<html>[예술문화대학]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 6;
			} else if (a[0] == 28 && a[1] == 14) {
				result = JOptionPane.showConfirmDialog(null, "<html>[동물생명대]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 7;
			} else if (a[0] == 36 && a[1] == 13) {
				result = JOptionPane.showConfirmDialog(null, "<html>[산학대학]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 8;
			} else if (a[0] == 25 && a[1] == 31) {
				result = JOptionPane.showConfirmDialog(null, "<html>[학생회관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 9;
			} else if (a[0] == 30 && a[1] == 43) {
				result = JOptionPane.showConfirmDialog(null, "<html>[공과대학]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 10;
			} else if (a[0] == 30 && a[1] == 52) {
				result = JOptionPane.showConfirmDialog(null, "<html>[신공학관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 11;
			} else if (a[0] == 36 && a[1] == 47) {
				result = JOptionPane.showConfirmDialog(null, "<html>[쿨하우스]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>", null,
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				doornum = 12;
			}

		}
		if (ch.getlandornot() && flag) {
			result = JOptionPane.showConfirmDialog(null,
					"<html>[일감호]<br/>건국대학교의 상징물인 호수<br/>※ 연인들의 산책 코스로 적합 ※" + "<br/>들어가시겠습니까 ?</html>", null,
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
	
	// txt_change에서 나오는 텍스트의 Yes를 클릭하지 않았을경우 되돌리기
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
			JOptionPane.showMessageDialog(null, "<html>체력이 50%입니다.<br/>학생회관에서 식사를 하거나<br/>기숙사에서 휴식을 취하세요 !</html>");
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