package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

//import object.ArtCulture.GameEndListener;
import object.Character;

public class MyFrame extends JFrame {
	Mainmap panel;
	Character ch;
	Container contentpane;
	
	GameMessage message;

	GameMessage message_ingame;
	Kulhouse kul;
	// 게임 객체
	MuseumGame museum;
	SoftGame soft;
	ArtCulture art;
	StaticGame staticGame;

	public MyFrame() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width / 2) - 409, (dim.height / 2) - 369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		contentpane = this.getContentPane();
		
		ch = new Character();
		
	
	
		// 인트로 부분
		message = new GameMessage(819, 648, introMessage(), new GameMessage.GameMessageListener() {

			@Override
			public void endMessage() {
				// TODO Auto-generated method stub

				// 본 게임
				MyFrame.this.removeKeyListener(message);
				contentpane.remove(message);

				// 메인 맵 생성
				panel = new Mainmap(ch, new Mainmap.mainMapListener() {

					@Override
					public void startGame(int doorNum) {

						switch (doorNum) {

						case 1:
							//상허 연구관
							startStaticGame();
							break;

						case 2:
							//경영관
							startManageGame();
							break;

						case 3:
							//부동산
							
							break;
							
						case 4:
							startSoftGame();
							break;

						case 5:

							startMuseumGame();


							break;

						case 6:

							startArtGame();


							break;

						case 7:
							startAnimal();
							break;

						case 8:
							startFactory();
							break;

						case 9:

							break;

						case 10:

							break;

						case 11:

							break;

						case 12:

							startKulHouse();
							break;

							
						case 99:
							//키리스너가져오기
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
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

	// 인트로 메세지 추가
	private ArrayList<String> introMessage() {
		ArrayList<String> intro = new ArrayList();
		intro.add("건국대학교 탐방에 잘왔단다! ▼");
		intro.add("나의 이름은 건우! 건국대학교의 마스코트지 ▼");
		intro.add(" ... ▼");

		intro.add("그럼 건국대학교 탐방 렛츠고! ▼");

		return intro;
	}

	private ArrayList<String> museumMessage() {
		ArrayList<String> muse = new ArrayList();
		muse.add("어서와! 여기는 상허 기념 박물관이란다. ▼");
		muse.add("상허 기념 박물관은 고고, 역사, 미술, 민속,▼");
		muse.add("학교역사자료 등 6천여 점을 소장하고 있는 ▼");
		muse.add("종합박물관이야 ▼");
		muse.add("또한 대학인과 지역주민을 대상으로 ▼");
		muse.add("박물관대학을 운영하고 있어 ▼");
		muse.add("그럼 상허 기념 박물관 퀴즈 게임을 시작하자 ▼");
		muse.add("10문제 중 5문제 이상 맞추면 성공이야! ▼");

		return muse;
	}
	
	
	private ArrayList<String> softMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("어서와! 여기는 새천년관이란다. ▼");
		msgs.add("이곳은 21세기 지식정보사회가 요구하는 ▼");
		msgs.add("전문 인력을 양성하고 ▼");
		msgs.add("전문교육을 다양하게 제공하지 ▼");
		msgs.add("그럼 소프트웨어학과에 오면 공부하게될 ▼");
		msgs.add("자료구조 중 하나인 스택 대해 알려줄게▼");
		msgs.add("스택은 나중에 들어간 것은 제일 먼저나오는▼");
		msgs.add("자료 구조를 말해▼");
		msgs.add("그럼 스택 구조를 보여주는 게임을 해보자 ▼");

		return msgs;
	}


	private ArrayList<String> manageMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("어서와! 여기는 경영관이란다. ▼");
		msgs.add("국제경쟁력과 융합적 사고를 지닌 ▼");
		msgs.add("미래의 지도자를 길러 내는게 교육 목적이야  ▼");
		msgs.add("넌 좋은 CEO가 될 수 있을거야!▼");
		

		return msgs;
	}
	
	//상허연구관
	private ArrayList<String> staticMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("어서와! 여기는 상허연구관이란다. ▼");
		msgs.add("일반대학원과 행정, 교육, 언론홍보대학원, ▼");
		msgs.add("정치대학, 상경대학이 함께 사용하는 건물이야 ▼");
		msgs.add("상경대학에는 대표적으로 경제학과, ▼");
		msgs.add("국제무역학과, 있어응용통계학과가 있어 ▼");
		msgs.add("네게 상경대학에 올 자질이 있는지 확인해 볼게 ▼");

		return msgs;
	}
	
	//동물 생명대학
	private ArrayList<String> animalMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("어서와! 여기는 동물생명대학이란다. ▼");
		msgs.add("정통과 역사를 자랑하는 건대의 상징대학이지 ▼");
		msgs.add("동물생명과학대학, 생명환경과학대학 그리고 ▼");
		msgs.add("생명과학특성학과가 융합된 대학이야▼");
		msgs.add("건국 우유 마시러 가자▼");
		
		return msgs;
	}
	
	
	//산학대
		private ArrayList<String> factoryMessage() {
			ArrayList<String> msgs = new ArrayList();
			msgs.add("어서와! 여기는 산학협동관이란다. ▼");
			msgs.add("시대의 흐름에 맞는 다양한 교양프로그램을 ▼");
			msgs.add("지속적으로 연구, 개발하여  ▼");
			msgs.add("교양교육 선진화에 기여하지▼");
			msgs.add("너도 창업에 도전해봐!▼");
			
			return msgs;
		}
	
		
	//산학대
	private void startFactory(){
		if(ch.getClear(8)==0){
			message_ingame = new GameMessage(819, 648, factoryMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							ch.setClear(8);
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	//동생대
	private void startAnimal(){
		if(ch.getClear(7)==0){
			message_ingame = new GameMessage(819, 648, animalMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							ch.setClear(7);
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	//경영관
	private void startManageGame(){
		if(ch.getClear(2)==0){
			message_ingame = new GameMessage(819, 648, manageMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							ch.setClear(2);
							panel.setClear(3); //3 엠블럼 획득 
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	
	private void startStaticGame(){
		if(ch.getClear(1)==0){
			
			//게임 대화 상자 생성 (1)
			message_ingame = new GameMessage(819, 648, staticMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//게임 클래스 생성(2)

							staticGame= new StaticGame("상허연구관 게임",ch,new StaticGame.gameEndListener() {
								
								@Override
								public void gameEnd(boolean isClear) {
									// TODO Auto-generated method stub
									
									if(isClear){
										ch.setClear(1);
										panel.setClear(2); //2 엠블럼 획득 
									}
									
									//게임 화면 false 주고 리스너 제거
									staticGame.setVisible(false);
									MyFrame.this.removeMouseListener(staticGame);
									contentpane.remove(staticGame);
									
									//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);
								}
							});

							
							//메인 맵 화면 false 해주고 게임화면 띄워주는 부분(대화상자에 리스너 추가) (2)
							panel.setVisible(false);
							contentpane.add(staticGame);
							MyFrame.this.addMouseListener(staticGame);
							staticGame.setVisible(true);
							
							
						}
					});
				
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		
	
		}
	}
	
	//새천년관 게임(4)
	private void startSoftGame(){
		if(ch.getClear(4)==0){ //1 이면 클리어
			
			//게임 대화 상자 생성 (1)
			message_ingame = new GameMessage(819, 648, softMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//게임 클래스 생성(2)

							soft= new SoftGame("소프트웨어학과 자료구조 게임",ch,new SoftGame.gameEndListener() {
								
								@Override
								public void gameEnd(boolean isClear) {
									// TODO Auto-generated method stub
									
									if(isClear){
										ch.setClear(4);
										panel.setClear(1); //1 엠블럼 획득 
									}
									
									//게임 화면 false 주고 리스너 제거
									soft.setVisible(false);
									MyFrame.this.removeMouseListener(soft);
									contentpane.remove(soft);
									
									//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);
								}
							});

							
							//메인 맵 화면 false 해주고 게임화면 띄워주는 부분(대화상자에 리스너 추가) (2)
							panel.setVisible(false);
							contentpane.add(soft);
							MyFrame.this.addMouseListener(soft);
							soft.setVisible(true);
							
							
						}
					});
				
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		
	
		}
	}
	
	
	//박물관 게임(5)
	private void startMuseumGame(){
		if (ch.getClear(5) == 0) { //클리어 여부 확인

			
			//게임 대화 상자 생성 (1)
			message_ingame = new GameMessage(819, 648, museumMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//게임 대화상자 끝나고 게임실행하는 부분
							
							
							// 메세지 화면 false로 해주고 리스너 제거(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//게임 클래스 생성(2)
							museum = new MuseumGame("박물관 게임", ch, new MuseumGame.gameEndListener() {

								@Override
								public void gameEnd(boolean isClear) {

									//게임 끝나고 실행 이벤트(3)
									
								
									if (isClear) {
										//클리어 했을때 캐릭터에 클리어 정보 저장
										ch.setClear(5);
										panel.setClear(0); //0 엠블럼 획득 
									}
											
									
									
									//게임 화면 false 주고 리스너 제거
									museum.setVisible(false);
									MyFrame.this.removeMouseListener(museum);
									contentpane.remove(museum);
									
									//다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);

								}
							});

							
							//메인 맵 화면 false 해주고 게임화면 띄워주는 부분(대화상자에 리스너 추가) (2)
							panel.setVisible(false);
							contentpane.add(museum);
							MyFrame.this.addMouseListener(museum);
							museum.setVisible(true);
							
							
						}
					});
				
			
			//메인맵 화면 false해주고 대화 상자 띄워주는 부분 (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//클리어 시 보여줄 화면
			JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	// 예문대 게임(6)
	   private void startArtGame() {
	      if (ch.getClear(6) == 0) { // 1 이면 클리어

	         panel.setVisible(false);
	         MyFrame.this.removeKeyListener(panel);
	         art = new ArtCulture("예술문화대학", ch, new ArtCulture.gameEndListener() {

	            @Override
	            public void gameEnd(boolean isClear) {

	               if (isClear) {
	                  // 클리어 했을때 캐릭터에 클리어 정보 저장
	                  ch.setClear(6);
	                  
	                  panel.setClear(4); //4 엠블럼 획득 
	               }
	               // TODO Auto-generated method stub
	               art.setVisible(false);
	               MyFrame.this.removeKeyListener(art);
	               contentpane.remove(art);

	               // 다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
	               MyFrame.this.addKeyListener(panel);
	               panel.setVisible(true);
	               panel.requestFocus();
	               MyFrame.this.requestFocusInWindow(true);
	            }

	         });
	         contentpane.add(art);
	         art.setVisible(true);
	         MyFrame.this.addKeyListener(art);
	         MyFrame.this.requestFocusInWindow(true);
	      } else {
	         // 클리어 시 보여줄 화면
	         JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
	         panel.requestFocus();
	         MyFrame.this.requestFocusInWindow(true);
	      }
	   }

	
	
	
	
	
//	쿨하우스(12)
	private void startKulHouse() {
		panel.setVisible(false);
		MyFrame.this.removeKeyListener(panel);
		kul=new Kulhouse("쿨하우스",ch,new Kulhouse.gameEndListener() {
			@Override
			public void gameEnd(boolean isClear) {
				// TODO Auto-generated method stub
				// 게임 화면 false 주고 리스너 제거
				kul.setVisible(false);
				MyFrame.this.removeKeyListener(kul);
				contentpane.remove(kul);

				// 다시 메인맵 화면 보여주고 리스너 새로 갱신 (3)
				MyFrame.this.addKeyListener(panel);
				panel.setVisible(true);
				panel.requestFocus();
				MyFrame.this.requestFocusInWindow(true);
			}
		});
		contentpane.add(kul);
		kul.setVisible(true);
		MyFrame.this.addKeyListener(kul);
		MyFrame.this.requestFocusInWindow(true);
		
	}
}