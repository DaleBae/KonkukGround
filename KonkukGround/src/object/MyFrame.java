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
	
	//게임 객체
	MuseumGame museum;
	
	
	public MyFrame() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-409, (dim.height/2)-369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();
		
		
		
		//인트로 부분 
		message = new GameMessage(819,648,introMessage(),new GameMessage.GameMessageListener() {
			
			@Override
			public void endMessage() {
				// TODO Auto-generated method stub
				
				//본 게임 
				MyFrame.this.removeKeyListener(message);
				contentpane.remove(message);
				
				
				ch=new Character(); //캐릭터 생성
				
				//메인 맵 생성 
				panel = new Mainmap(ch,new Mainmap.mainMapListener() {
					
					@Override
					public void startGame(int doorNum) {
						
						
						switch(doorNum){
						
						case 1:
							
							break;
							
						case 2:
							
							break;
							
							
						case 4:
							
							break;	
							
						case 5:
							
							panel.setVisible(false);
							MyFrame.this.removeKeyListener(panel);
							museum = new MuseumGame("박물관 게임",ch,new MuseumGame.gameEndListener() {
								
								@Override
								public void gameEnd() {
									
									museum.setVisible(false);
									contentpane.remove(museum);
						
									panel.setVisible(true);
									MyFrame.this.addKeyListener(panel);
									
									
									
									
									
								}
							});
							contentpane.add(museum);
							
							break;		
							
							
						case 6:
							
							break;		
							
						case 7:
							
							break;	
							
						case 8:
							
							break;	
							
							
						case 9 :
							
							break;	
							
						case 10:
							
							break;	
							
						case 11:
							
							break;	
							
						case 12:
							
							break;			
							
						}
						
						
					}
				});
				MyFrame.this.addKeyListener(panel);
				contentpane.add(panel);
				MyFrame.this.setVisible(true);
				
			}
		});
		
		this.addKeyListener(message);	
		contentpane.add(message);
		this.setVisible(true);
		
	}
	
	
	//인트로 메세지 추가
	private ArrayList<String> introMessage(){
		ArrayList<String> intro = new ArrayList();
		intro.add("건국대학교 탐방에 잘왔단다! ▼");
		intro.add("나의 이름은 건우! 건국대학교의 마스코트지 ▼");
		intro.add(" ... ▼");
	
		intro.add("그럼 건국대학교 탐방 렛츠고! ▼");
		
		return intro;
	}


	
}