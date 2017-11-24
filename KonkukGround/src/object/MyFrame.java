package object;

import java.awt.*;
import javax.swing.*;

import object.Character;

public class MyFrame extends JFrame{
	Mainmap panel;
	
	public MyFrame() {
		this.setTitle("KonkukGround");
		this.setSize(419, 448);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = this.getContentPane();
		panel = new Mainmap();
		contentpane.add(panel);
		this.setVisible(true);
	}
}
