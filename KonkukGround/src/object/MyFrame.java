package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import object.Character;

public class MyFrame extends JFrame{
	Mainmap panel;
	Character ch;
	
	GameMessage message;
	
	
	public MyFrame() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-409, (dim.height/2)-369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();
		
		
		
		//��Ʈ�� �κ� 
		message = new GameMessage(819,648,introMessage(),new GameMessage.GameMessageListener() {
			
			@Override
			public void endMessage() {
				// TODO Auto-generated method stub
				
				//�� ���� 
				contentpane.remove(message);
				
				ch=new Character(); //ĳ���� ����
				
				//���� �� ���� 
				panel = new Mainmap(ch);
				MyFrame.this.addKeyListener(panel);
				contentpane.add(panel);
				MyFrame.this.setVisible(true);
				
			}
		});
		
		this.addKeyListener(message);	
		contentpane.add(message);
		this.setVisible(true);
		

		


		
		
	}
	
	
	//��Ʈ�� �޼��� �߰�
	private ArrayList<String> introMessage(){
		ArrayList<String> intro = new ArrayList();
		intro.add("�Ǳ����б� Ž�濡 �߿Դܴ�! ��");
		intro.add("���� �̸��� �ǿ�! �Ǳ����б��� ������Ʈ�� ��");
		intro.add(" ... ��");
	
		intro.add("�׷� �Ǳ����б� Ž�� ������! ��");
		
		return intro;
	}


	
}