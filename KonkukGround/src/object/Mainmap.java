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
	private Image[] Tileimg;
	private Image[] chimg;
	private int[][] EntireMap;
	private int[][] PartMap;
	private int xCount;
	private int yCount;
	private int result; // 옵션창의 결과 값을 받아오기
	private boolean flag; //물에 처음 들어온 것인지 확인하는 변수
	
	Mainmap(Character ch) {
		this.setBackground(Color.black);
		Map_init();
		Image_init();
		xCount=11;
		flag=true;
		this.ch = ch;
		this.setLayout(null);
		this.setFocusable(true);
//		this.addKeyListener(new MyKeyAdapter());
	}

	// Tile 배열 값에 따른 배치
	public void doDrawing(Graphics g) {
		// 기본 맵 생성
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap[i].length; j++) {
				g.drawImage(Tileimg[PartMap[i][j]], j * 40, i * 40, 40, 40, this);
			}
		}
		drawCharacter(g);

	}

	// 캐릭터 포지션 및 방향에 따른 이미지 삽입
	public void drawCharacter(Graphics g) {
		switch (ch.getdir()) {
		case 0:
			if (ch.getlandornot()) {
				flag=false;
				g.drawImage(chimg[4], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag=true;
				g.drawImage(chimg[0], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 1:
			if (ch.getlandornot()) {
				flag=false;
				g.drawImage(chimg[5], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag=true;
				g.drawImage(chimg[1], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 2:
			if (ch.getlandornot()) {
				flag=false;
				g.drawImage(chimg[6], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag=true;
				g.drawImage(chimg[2], ch.getPosX(), ch.getPosY(), 40, 40, this);
			}
			break;
		case 3:
			if (ch.getlandornot()) {
				flag=false;
				g.drawImage(chimg[7], ch.getPosX(), ch.getPosY(), 40, 40, this);
			} else {
				flag=true;
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
				PartMap[i][j] = EntireMap[i][j+11];
			}
		}
	}

	// Tile,Ch 이미지 배열 생성 및 이미지 설정
	public void Image_init() {
		tool = Toolkit.getDefaultToolkit();
		Tileimg = new Image[14];
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


	public void txt_change(KeyEvent e_temp) {
		result=JOptionPane.YES_OPTION;
		if (checkTile(12)) {
			int[] a = new int[2];
			a = getTile();
			if (a[0] == 11 && a[1] == 6) {
				result=JOptionPane.showConfirmDialog(null, "<html>[상허연구관]<br/>반갑습니다<br/>들어가려면 \"예[Y]\"</html>");
			}
		}
		if (ch.getlandornot()&&flag) {
			result=JOptionPane.showConfirmDialog(null,"<html>[일감호]<br/>건국대학교의 상징물인 호수<br/>※ 연인들의 산책 코스로 적합 ※"
					+ "<br/>들어가시겠습니까 ?</html>"
					,null,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);	
		}
		if(result==JOptionPane.YES_OPTION) {
		}
		else {
			key_reject(e_temp);
		}
	}
	
//	txt_change에서 나오는 텍스트의 Yes를 클릭하지 않았을경우 되돌리기
	public void key_reject(KeyEvent e_temp) {
		Robot robot;
		try {
			robot = new Robot();
			switch(e_temp.getKeyCode()) {
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
			if (!downcheckTile(-1) && !downcheckTile(1) && !downcheckTile(2) && !downcheckTile(3)
					&& !downcheckTile(4) && !downcheckTile(5) && !downcheckTile(6) && !downcheckTile(8)
					&& !downcheckTile(9)) {
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
			if (!leftcheckTile(-1) && !leftcheckTile(1) && !leftcheckTile(2) && !leftcheckTile(3)
					&& !leftcheckTile(4) && !leftcheckTile(5) && !leftcheckTile(6) && !leftcheckTile(8)
					&& !leftcheckTile(9)) {
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