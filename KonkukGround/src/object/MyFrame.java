package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import object.Character;

public class MyFrame extends JFrame{
	Mainmap panel;
	
	
	public MyFrame() {
		this.setTitle("KonkukGround");
		this.setSize(419, 538);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();
		panel = new Mainmap();
		
		contentpane.add(panel);

		
		this.setVisible(true);
	}


	
}