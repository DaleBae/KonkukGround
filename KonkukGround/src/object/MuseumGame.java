package object;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MuseumGame extends Game implements MouseListener {

	Image img_msg; // ��ȭâ
	Image img_museum; // �ڹ��� �̹���

	Image img_right; // ���� �̹���
	Image img_wrong; // ���� �̹���

	Image img_success;
	Image img_fail;

	JButton btn_o;
	JButton btn_x;

	int score = 0;
	int quizNum = 0;

	boolean isShowRight;
	boolean isShowWrong;

	boolean isShowClear;
	boolean isShowFail;
	
	boolean isLoading;

	String quiz[]; // ����
	String answer[]; // ����

	Timer timer;

	gameEndListener listener;

	MuseumGame(String subject, Character ch, gameEndListener listener) {
		super(subject, ch);

		this.listener = listener;

		this.setLayout(null);
		this.setBackground(Color.WHITE);
		init();

		btn_o = new JButton(new ImageIcon("images/o.png"));
		btn_x = new JButton(new ImageIcon("images/x.png"));

		btn_o.setBounds(100, 150, 100, 100);
		btn_x.setBounds(600, 150, 100, 100);

		btn_o.addMouseListener(this);

		btn_x.addMouseListener(this);

		this.add(btn_o);
		this.add(btn_x);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		// Ÿ��Ʋ
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("���� ��� �ڹ��� ���� ����", 0, 40);

		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.setColor(Color.RED);
		g.drawString("���� ���� : " + score, 500, 40);

		g.drawImage(img_msg, 25, 350, null);
		g.drawImage(img_museum, 250, 50, 300, 300, null);

		g.setColor(Color.black);
		g.drawString("���� " + (quizNum + 1) + ". " + quiz[quizNum], 70, 450);

		if (isShowRight) {
			g.drawImage(img_right, 260, 100, null);

		}

		if (isShowWrong) {
			g.drawImage(img_wrong, 260, 100, null);
		}

		if (isShowFail) {
			g.drawImage(img_fail, 250, 150, null);
		}

		if (isShowClear) {
			g.drawImage(img_success, 200, 150, null);
		}

	}

	private void gameOver() {
		if (score > 4) {
			isShowClear = true;
		} else {
			isShowFail = true;
		}

		MuseumGame.this.repaint();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				listener.gameEnd(isShowClear);// ���ӳ�

				timer.cancel();

			}

		};

		
			timer = new Timer();
			timer.schedule(tt, 1500, 1000);
		
		

	}

	interface gameEndListener {
		void gameEnd(boolean isClear);
	}

	private void init() {

		try {
			img_msg = ImageIO.read(new File("images/��ǳ��.png"));
			img_museum = ImageIO.read(new File("images/museum.png"));
			img_wrong = ImageIO.read(new File("images/����.png"));
			img_right = ImageIO.read(new File("images/����.png"));
			img_fail = ImageIO.read(new File("images/fail.png"));
			img_success = ImageIO.read(new File("images/clear.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		quiz = new String[10];
		answer = new String[10];

		int count = 0;

		File file = new File("images/quiz.txt");
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String str = scan.nextLine();

				String s[] = str.split(":"); // ���ڿ� �и�

				quiz[count] = s[0].trim();
				answer[count] = s[1].trim();
				count++;

			}

			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (btn_o == e.getSource() && !isLoading) {
			
			isLoading=true;
			
			if (answer[quizNum].equals("0")) {
				isShowRight = true;
				score += 1;

			} else {
				isShowWrong = true;

			}

			TimerTask tt = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					MuseumGame.this.repaint();

					isShowWrong = false;
					isShowRight = false;
					isLoading=false;
					timer.cancel();

				}

			};

			if (quizNum == 9) {
				MuseumGame.this.repaint();
				gameOver();

			} else {
				timer = new Timer();
				timer.schedule(tt, 1500, 1000);
			}

			MuseumGame.this.repaint();
			if (quizNum < 9) {
				quizNum += 1;
			}

		}

		if (btn_x == e.getSource()&& !isLoading) {

			isLoading=true;
			if (answer[quizNum].equals("1")) {
				isShowRight = true;
				score += 1;
			} else {
				isShowWrong = true;
			}

			TimerTask tt = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					MuseumGame.this.repaint();
					isShowWrong = false;
					isShowRight = false;
					isLoading=false;
					timer.cancel();
				}

			};

			if (quizNum == 9) {
				MuseumGame.this.repaint();
				gameOver();

			} else {
				timer = new Timer();
				timer.schedule(tt, 1500, 1000);
			}

			MuseumGame.this.repaint();
			if (quizNum < 9) {
				quizNum += 1;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
