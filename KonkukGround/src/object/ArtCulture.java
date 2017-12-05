package object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ArtCulture extends Game implements KeyListener {

	Character ch;

	Timer timer;
	TimerTask tt;

	Integer[][] img_perfect;
	Integer[][] img_shuffle;

	ArrayList<Integer[][]> problem_perfect;
	ArrayList<Integer[][]> problem_shuffle;

	Random rand;

	boolean isClear;
	boolean isSelected;
	boolean isShowFail;

	Image img;

	int level;
	Point currentCursor;

	String str;
	JLabel label;

	gameEndListener listener;

	Image img_fail;
	Image img_success;

	JButton btn_finish;

	ArtCulture(String subject, Character ch, gameEndListener listener) {
		super(subject, ch, listener);
		// TODO Auto-generated constructor stub
		level = 1;
		isClear = false;
		isShowFail = false;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		label = new JLabel();
		label.setBounds(150, 0, 600, 50);
		label.setText("<html>인접한 퍼즐과 자리를 바꿔 퍼즐을 맞춰주세요 !<br/>[space]:선택 " + " [방향키]:이동 (선택 후 이동시 바뀝니다.)</html>");
		label.setFont(new Font("Serif", Font.BOLD, 15));
		label.setBackground(null);
		label.setForeground(Color.BLACK);

		btn_finish = new JButton("게임포기");
		btn_finish.setBounds(550, 10, 100, 40);
		btn_finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isShowFail = true;
				repaint();
				timer.schedule(tt, 1500);

			}

		});
		this.add(btn_finish);

		this.ch = ch;

		rand = new Random();

		currentCursor = new Point(300, 70);

		timer = new Timer();
		tt = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				exit();
				timer.cancel();
			}
		};
		this.listener = listener;

		init();
		isSelected = false;
		this.add(label);
		repaint();
	}

	public void init() {
		try {
			img_fail = ImageIO.read(new File("images/fail.png"));
			img_success = ImageIO.read(new File("images/clear.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		problem_perfect = new ArrayList<Integer[][]>();
		problem_shuffle = new ArrayList<Integer[][]>();

		img_init();
	}

	public void img_init() {
		img_perfect = new Integer[5][3];
		img_shuffle =new Integer[5][3];
		int k = 1;
		for (int i = 0; i < img_perfect.length; i++) {
			for (int j = 0; j < img_perfect[i].length; j++) {
				img_perfect[i][j] = k;
				k++;
			}
		}
		problem_perfect.add(img_perfect);
		shuffle();
		problem_shuffle.add(img_shuffle);

		img_perfect = new Integer[3][5];
		img_shuffle = new Integer[3][5];
		k = 1;
		for (int i = 0; i < img_perfect.length; i++) {
			for (int j = 0; j < img_perfect[i].length; j++) {
				img_perfect[i][j] = k;
				k++;
			}
		}
		problem_perfect.add(img_perfect);
		shuffle();
		problem_shuffle.add(img_shuffle);
		
		img_perfect = problem_perfect.get(0);
		img_shuffle = problem_shuffle.get(0);
	}

	public void shuffle() {
		ArrayList<Integer> b = new ArrayList<Integer>();
		int size = img_shuffle.length * img_shuffle[0].length;
		for (int i = 1; i <= size; i++) {
			b.add(i);
		}
		for (int i = 0; i < img_shuffle.length; i++) {
			for (int j = 0; j < img_shuffle[i].length; j++) {
				img_shuffle[i][j] = b.remove(rand.nextInt(b.size()));
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (isSelected) {
				if (level == 1) {
					if (currentCursor.y != 70) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300)
								/ 100] = img_shuffle[(currentCursor.y - 170) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y + -170) / 100][(currentCursor.x - 300) / 100] = temp;
						currentCursor.y -= 100;
						isSelected = !isSelected;
					}
				} else if (level == 2) {
					if (currentCursor.y != 200) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150)
								/ 100] = img_shuffle[(currentCursor.y - 300) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 300) / 100][(currentCursor.x - 150) / 100] = temp;
						currentCursor.y -= 100;
						isSelected = !isSelected;
					}
				}
			} else {
				if (level == 1) {
					if (currentCursor.y != 70) {
						currentCursor.y -= 100;
					}
				} else if (level == 2) {
					if (currentCursor.y != 200) {
						currentCursor.y -= 100;
					}
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			if (isSelected) {
				if (level == 1) {
					if (currentCursor.y != 470) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300)
								/ 100] = img_shuffle[(currentCursor.y + 30) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y + 30) / 100][(currentCursor.x - 300) / 100] = temp;
						currentCursor.y += 100;
						isSelected = !isSelected;
					}
				} else if (level == 2) {
					if (currentCursor.y != 400) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150)
								/ 100] = img_shuffle[(currentCursor.y - 100) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 100) / 100][(currentCursor.x - 150) / 100] = temp;
						currentCursor.y += 100;
						isSelected = !isSelected;
					}
				}
			} else {
				if (level == 1) {
					if (currentCursor.y != 470) {
						currentCursor.y += 100;
					}
				} else if (level == 2) {
					if (currentCursor.y != 400) {
						currentCursor.y += 100;
					}
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (isSelected) {
				if (level == 1) {
					if (currentCursor.x != 500) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300)
								/ 100] = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 200) / 100];
						img_shuffle[(currentCursor.y + -70) / 100][(currentCursor.x - 200) / 100] = temp;
						currentCursor.x += 100;
						isSelected = !isSelected;
					}
				} else if (level == 2) {
					if (currentCursor.x != 550) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150)
								/ 100] = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 50) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 50) / 100] = temp;
						currentCursor.x += 100;
						isSelected = !isSelected;
					}
				}
			} else {
				if (level == 1) {
					if (currentCursor.x != 500) {
						currentCursor.x += 100;
					}
				} else if (level == 2) {
					if (currentCursor.x != 550) {
						currentCursor.x += 100;
					}
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			if (isSelected) {
				if (level == 1) {
					if (currentCursor.x != 300) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300) / 100];
						img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 300)
								/ 100] = img_shuffle[(currentCursor.y - 70) / 100][(currentCursor.x - 400) / 100];
						img_shuffle[(currentCursor.y + -70) / 100][(currentCursor.x - 400) / 100] = temp;
						currentCursor.x -= 100;
						isSelected = !isSelected;
					}
				} else if (level == 2) {
					if (currentCursor.x != 150) {
						int temp;
						temp = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 150)
								/ 100] = img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 250) / 100];
						img_shuffle[(currentCursor.y - 200) / 100][(currentCursor.x - 250) / 100] = temp;
						currentCursor.x -= 100;
						isSelected = !isSelected;
					}
				}
			} else {
				if (level == 1) {
					if (currentCursor.x != 300) {
						currentCursor.x -= 100;
					}
				} else if (level == 2) {
					if (currentCursor.x != 150) {
						currentCursor.x -= 100;
					}
				}
			}
			break;
		case KeyEvent.VK_SPACE:
			if (!isSelected) {
				isSelected = true;
			}
			break;
		}
		if (returnClear()) {			
			level++;
			if (level == 2) {
				img_perfect = problem_perfect.get(1);
				img_shuffle = problem_shuffle.get(1);
				
				currentCursor.x = 150;
				currentCursor.y = 200;
			}
		}
		repaint();
	}
	public boolean returnClear() {
		boolean test=false;
		int count=0;
		
		for(int i=0;i<img_perfect.length;i++) {
			for(int j=0;j<img_perfect[i].length;j++) {
				if(img_perfect[i][j]==img_shuffle[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
		if(count==15) {
			test=true;
		}
		return test;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void exit() {
		listener.gameEnd(isClear);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void doDrawing(Graphics g) {
		try {
			for (int i = 0; i < img_shuffle.length; i++) {
				for (int j = 0; j < img_shuffle[i].length; j++) {
					if (level == 1) {
						str = "images/Art/모나리자/모나리자" + img_shuffle[i][j] + ".png";
						Path path = Paths.get(str);
						img = ImageIO.read(new File(path.toString()));
						g.drawImage(img, 300 + (j * 100), 70 + (i * 100), 100, 100, this);
					} else if (level == 2) {
						str = "images/Art/반고흐/반고흐" + img_shuffle[i][j] + ".png";
						Path path = Paths.get(str);
						img = ImageIO.read(new File(path.toString()));
						g.drawImage(img, 150 + (j * 100), 200 + (i * 100), 100, 100, this);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		str = "images/Art/이미지 테두리.png";
		Path path = Paths.get(str);
		try {
			img = ImageIO.read(new File(path.toString()));
			g.drawImage(img, currentCursor.x, currentCursor.y, 100, 100, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (level == 3) {
			g.drawImage(img_success, 200, 150, null);
			isClear = true;
			timer.schedule(tt, 1500);
		}
		if (isShowFail) {
			g.drawImage(img_fail, 250, 150, null);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}
