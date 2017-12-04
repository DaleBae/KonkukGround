package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMessage extends JPanel implements KeyListener {

	Image img_cow;
	Image img_msg;
	
	int screenWidth;
	int screenHeight;
	
	ArrayList<String> msg;			//�޼���â�� ������ ��Ʈ�� ����Ʈ
	
	int msgCount=0;
	
	GameMessageListener endCheckListener ;  //�޼���â ������ �ݹ� �޴� �������̽�
	
	GameMessage(int xsize, int ysize,ArrayList<String> msg, GameMessageListener listener){
		
		
		msgCount=0;
		screenWidth = xsize;
		screenHeight = ysize;
		this.msg = msg;
		
		this.setBackground(Color.WHITE);
		
		try {
			img_cow = ImageIO.read(new File("images/�ǿ�.png"));
			img_msg = ImageIO.read(new File("images/��ǳ��.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.endCheckListener=listener;
		
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		
		
		//�Ŵ� �̹��� �� ��ȭâ �̹��� �׸���
		if(img_cow!=null && img_msg!=null){
			g.drawImage(img_cow,300,50,null);
			g.drawImage(img_msg,25,350,null);
		}
		
		//�޼��� �Է�
		g.setFont(new Font("Serif",Font.BOLD,30));
		g.drawString(msg.get(msgCount), 70, 450);
		
	}

	
	//Ű ������ 
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_ENTER:
			
			//���ʹ����� �޼��� ����
			msgCount +=1;
			if(msgCount<msg.size()){
				GameMessage.this.repaint();
			}else{
				if(endCheckListener !=null){
					endCheckListener.endMessage(); //�޼��� �г� ���� 
				}
			}
			
			
			break;
			
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

		

	}
	
	public interface GameMessageListener{
		void endMessage();
	}
	
}
