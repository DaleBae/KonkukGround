package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		this.setFocusable(true);
		this.setLayout(null);
		this.add(txt);
		this.addKeyListener(new MyKeyAdapter());
	}
	
	public void txt_init() {
		txt=new JLabel();
		Font font=new Font("Fixedsys",Font.BOLD,20);
		txt.setForeground(Color.white);
		txt.setFont(font);
		txt.setSize(419,90);
		txt.setLocation(new Point(0,398));
	}
	
	public void txt_change() {
		
		if(this.getlandornot()) {
			String str="<html>[일감호]<br/>건국대학교의 상징물인 호수<br/>※ 연인들의 산책 코스로 적합 ※</html>";
			txt.setText(str);
		}
		else {
			txt.setText("Normal");
		}
	}
	
//	Map 초기화
	public void Map_init() {
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
	}

//	Tile,Ch 이미지 배열 생성 및 이미지 설정
	public void Image_init() {
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
	}

//	방향키 입력에 따른 KeyAdapter
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				if (yCount == 0 || EntireMap[xCount + (ch.getPosX() / 40)][(yCount - 1) + (ch.getPosY() / 40)] != -1) {
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
				if (yCount == 30 || EntireMap[xCount + (ch.getPosX() / 40)][(yCount + 1) + (ch.getPosY() / 40)] != -1) {
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
				if (xCount == 0 || EntireMap[(xCount - 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] != -1) {
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
				if (xCount == 30 || EntireMap[(xCount + 1) + (ch.getPosX() / 40)][yCount + (ch.getPosY() / 40)] != -1) {
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
			txt_change();
			repaint();
		}
	}

//	Tile 배열 값에 따른 배치
	public void doDrawing(Graphics g) {
		// 기본 맵 생성
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < PartMap.length; i++) {
			for (int j = 0; j < PartMap.length; j++) {
				g.drawImage(Tileimg[PartMap[i][j]], i * 40, j * 40, 40, 40, this);
			}
		}
		drawCharacter(g);

	}

//	캐릭터 포지션 및 방향에 따른 이미지 삽입
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
	
	public boolean getlandornot() {
		return ch.getlandornot();
	}
}