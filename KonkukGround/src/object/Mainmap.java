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
	private Image img;
	

	Mainmap() {
		tool=Toolkit.getDefaultToolkit();
		img=tool.getImage("images//test.png");
		ch = new Character();
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					ch.moveUp();
					repaint();
					break;
				case KeyEvent.VK_DOWN:
					ch.moveDown();
					repaint();
					break;
				case KeyEvent.VK_LEFT:
					ch.moveLeft();
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					ch.moveRight();
					repaint();
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

		});
	}

	public void doDrawing(Graphics g) {
		// ±âº» ¸Ê »ý¼º
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				g2d.drawRect(x * 40, y * 40, 40, 40);
			}
		}
		g.drawImage(img, ch.getPosX(), ch.getPosY(), 40,40,this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}