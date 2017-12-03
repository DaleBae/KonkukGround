package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import object.Character;

public class MyFrame extends JFrame{
	Mainmap panel;
	Character ch;
	
	
	public MyFrame() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-409, (dim.height/2)-369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();
		
	
		ch=new Character();
		panel = new Mainmap(ch);
		
		contentpane.add(panel);

		
		this.setVisible(true);
	}


	
}