package object;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ArtCulture extends Game implements KeyListener {
	

	Character ch;

	Integer[][] img_perfect;
	Integer[][] img_shuffle;

	ArrayList<Integer[][]> problem_perfect;
	ArrayList<Integer[][]> problem_shuffle;

	Random rand;

	boolean isShowClear;
	boolean isSelected;

	Image img;

	int level;
	Point currentCursor;

	String str;
	JLabel label;

	ArtCulture(String subject, Character ch, gameEndListener listener) {
		super(subject, ch, listener);
		// TODO Auto-generated constructor stub
		level = 1;
		isShowClear = false;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		label = new JLabel();
		label.setBounds(200, 0, 600, 100);
		label.setText("<html>인접한 퍼즐과 자리를 바꿔 퍼즐을 맞춰주세요 !<br/>[space] : 선택 " + " [방향키] : 이동</html>");
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setBackground(null);
		label.setForeground(Color.BLACK);

		this.ch = ch;
		
		rand = new Random();
		
		currentCursor = new Point(0, 0);
		
		init();
		isSelected = false;
		isShowClear=false;
		this.add(label);
		repaint();
	}

	public void init() {
		problem_perfect = new ArrayList<Integer[][]>();
		problem_shuffle = new ArrayList<Integer[][]>();

		img_init();
	}

	public void img_init() {
		img_perfect = new Integer[5][3];
		img_shuffle = img_perfect;
		int k = 1;
		for (int i = 0; i < img_shuffle.length; i++) {
			for (int j = 0; j < img_shuffle[i].length; j++) {
				img_shuffle[i][j] = k;
				k++;
			}
		}
		problem_perfect.add(img_perfect);
		img_shuffle = shuffle(img_perfect);
		problem_shuffle.add(img_shuffle);

		img_perfect = new Integer[3][5];
		img_shuffle = img_perfect;
		k = 1;
		for (int i = 0; i < img_shuffle.length; i++) {
			for (int j = 0; j < img_shuffle[i].length; j++) {
				img_shuffle[i][j] = k;
				k++;
			}
		}
		problem_perfect.add(img_perfect);
		img_shuffle = shuffle(img_perfect);
		problem_shuffle.add(img_shuffle);
	}

	public Integer[][] shuffle(Integer[][] a) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		int size = a.length * a[0].length;
		for (int i = 1; i <= size; i++) {
			b.add(i);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = b.remove(rand.nextInt(b.size()));
			}
		}
		return a;
	}

	interface GameEndListener {
		void GameEnd();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (isSelected) {

			}
			break;
		case KeyEvent.VK_DOWN:
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_SPACE:
			isSelected=!isSelected;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void doDrawing(Graphics g) {
		if (level == 1) {
			img_perfect = problem_perfect.get(0);
			img_shuffle = problem_shuffle.get(0);

		} else if (level == 2) {
			img_perfect = problem_perfect.get(1);
			img_shuffle = problem_perfect.get(1);
		} else {

		}
		try {
			for (int i = 0; i < img_shuffle.length; i++) {
				for (int j = 0; j < img_shuffle[i].length; j++) {
					if (level == 1) {
						str = "images/Art/모나리자/모나리자" + img_shuffle[i][j] + ".png";
						Path path = Paths.get(str);
						img = ImageIO.read(new File(path.toString()));
						g.drawImage(img, 300 + (j * 80), 100 + (i * 80), 100, 100, this);
					} else if (level == 2) {
						str = "images/Art/반고흐/반고흐" + img_shuffle[i][j] + ".png";
						Path path = Paths.get(str);
						img = ImageIO.read(new File(path.toString()));
						g.drawImage(img, 200 + (j * 80), 200 + (i * 80), 100, 100, this);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isSelected=true;
		if(isSelected) {
			str = "images/Art/이미지 테두리.png";
			Path path = Paths.get(str);
			try {
				img = ImageIO.read(new File(path.toString()));
//				g.drawImage(img, currentCursor.x, currentCursor.y, 100,100, this);
				g.drawImage(img, 200, 200, 100,100, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}
