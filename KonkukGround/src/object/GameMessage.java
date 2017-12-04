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
	
	ArrayList<String> msg;			//메세지창에 보여줄 스트링 리스트
	
	int msgCount=0;
	
	GameMessageListener endCheckListener ;  //메세지창 끝났는 콜백 받는 인터페이스
	
	GameMessage(int xsize, int ysize,ArrayList<String> msg, GameMessageListener listener){
		
		
		msgCount=0;
		screenWidth = xsize;
		screenHeight = ysize;
		this.msg = msg;
		
		this.setBackground(Color.WHITE);
		
		try {
			img_cow = ImageIO.read(new File("images/건우.png"));
			img_msg = ImageIO.read(new File("images/말풍선.png"));
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
		
		
		
		//거누 이미지 및 대화창 이미지 그리기
		if(img_cow!=null && img_msg!=null){
			g.drawImage(img_cow,300,50,null);
			g.drawImage(img_msg,25,350,null);
		}
		
		//메세지 입력
		g.setFont(new Font("Serif",Font.BOLD,30));
		g.drawString(msg.get(msgCount), 70, 450);
		
	}

	
	//키 리스너 
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_ENTER:
			
			//엔터누르면 메세지 갱신
			msgCount +=1;
			if(msgCount<msg.size()){
				GameMessage.this.repaint();
			}else{
				if(endCheckListener !=null){
					endCheckListener.endMessage(); //메세지 패널 종료 
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
