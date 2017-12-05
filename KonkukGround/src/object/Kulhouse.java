package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.*;

import object.Game.gameEndListener;

public class Kulhouse extends Game implements KeyListener {
	Character ch;
	JButton btn_sleep, btn_exit;
	private boolean pos;

	Image img;
	Timer timer;
	JLabel label;
	boolean sleep_enter;

	public Kulhouse(String subject, Character ch, gameEndListener listener) {
		super(subject, ch,listener);
		// TODO Auto-generated constructor stub

		pos = true;
		this.ch = ch;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		init();


		label = new JLabel();
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setBackground(null);
		label.setBounds(300, 50, 400, 100);
		label.setForeground(Color.BLACK);
		label.setText("스르르 잠이 듭니다..");
		this.add(label);
		label.setVisible(false);

		btn_sleep = new JButton();
		btn_exit = new JButton();

		btn_sleep.setBackground(null);
		btn_exit.setBackground(null);

		btn_sleep.setText("▼  숙면");
		btn_exit.setText("  나가기");

		btn_sleep.setFont(new Font("Serif", Font.BOLD, 20));
		btn_exit.setFont(new Font("Serif", Font.BOLD, 20));

		btn_sleep.setBounds(200, 150, 400, 100);
		btn_exit.setBounds(200, 350, 400, 100);

		this.addKeyListener(this);
		this.add(btn_sleep);
		this.add(btn_exit);
		// btn_x.addMouseListener(this);
	}

	
	interface ExitListener {
		void ExitHere();
	}

	public void exit() {
		listener.gameEnd(false);
	}

	public void init() {
		sleep_enter = false;
		try {
			img = ImageIO.read(new File("images/수면.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void doDrawing(Graphics g) {
		timer = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sleep_enter = false;
				exit();
				timer.cancel();
			}
		};
		if (sleep_enter&&pos) {
			label.setVisible(true);
			this.remove(btn_sleep);
			this.remove(btn_exit);
			g.drawImage(img, 230, 250, 300, 300, null);
			timer.schedule(tt, 1500);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_UP:
			pos = !pos;
			if (pos) {
				btn_sleep.setText("▼  숙면");
				btn_exit.setText("  나가기");
			} else {
				btn_sleep.setText("  숙면");
				btn_exit.setText("▼  나가기");
			}
			break;
		case KeyEvent.VK_DOWN:
			pos = !pos;
			if (pos) {
				btn_sleep.setText("▼  숙면");
				btn_exit.setText("  나가기");
			} else {
				btn_sleep.setText("  숙면");
				btn_exit.setText("▼  나가기");
			}
			break;
		case KeyEvent.VK_ENTER:
			if (pos) {
				sleep_enter = true;
				repaint();
				ch.setHP(200);
			} else {
				exit();
			}
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

}
