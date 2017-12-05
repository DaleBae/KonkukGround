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
	// ���� ��ü
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
		
	
	
		// ��Ʈ�� �κ�
		message = new GameMessage(819, 648, introMessage(), new GameMessage.GameMessageListener() {

			@Override
			public void endMessage() {
				// TODO Auto-generated method stub

				// �� ����
				MyFrame.this.removeKeyListener(message);
				contentpane.remove(message);

				// ���� �� ����
				panel = new Mainmap(ch, new Mainmap.mainMapListener() {

					@Override
					public void startGame(int doorNum) {

						switch (doorNum) {

						case 1:
							//���� ������
							startStaticGame();
							break;

						case 2:
							//�濵��
							startManageGame();
							break;

						case 3:
							//�ε���
							
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
							//Ű�����ʰ�������
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

	// ��Ʈ�� �޼��� �߰�
	private ArrayList<String> introMessage() {
		ArrayList<String> intro = new ArrayList();
		intro.add("�Ǳ����б� Ž�濡 �߿Դܴ�! ��");
		intro.add("���� �̸��� �ǿ�! �Ǳ����б��� ������Ʈ�� ��");
		intro.add(" ... ��");

		intro.add("�׷� �Ǳ����б� Ž�� ������! ��");

		return intro;
	}

	private ArrayList<String> museumMessage() {
		ArrayList<String> muse = new ArrayList();
		muse.add("���! ����� ���� ��� �ڹ����̶���. ��");
		muse.add("���� ��� �ڹ����� ���, ����, �̼�, �μ�,��");
		muse.add("�б������ڷ� �� 6õ�� ���� �����ϰ� �ִ� ��");
		muse.add("���չڹ����̾� ��");
		muse.add("���� �����ΰ� �����ֹ��� ������� ��");
		muse.add("�ڹ��������� ��ϰ� �־� ��");
		muse.add("�׷� ���� ��� �ڹ��� ���� ������ �������� ��");
		muse.add("10���� �� 5���� �̻� ���߸� �����̾�! ��");

		return muse;
	}
	
	
	private ArrayList<String> softMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("���! ����� ��õ����̶���. ��");
		msgs.add("�̰��� 21���� ����������ȸ�� �䱸�ϴ� ��");
		msgs.add("���� �η��� �缺�ϰ� ��");
		msgs.add("���������� �پ��ϰ� �������� ��");
		msgs.add("�׷� ����Ʈ�����а��� ���� �����ϰԵ� ��");
		msgs.add("�ڷᱸ�� �� �ϳ��� ���� ���� �˷��ٰԡ�");
		msgs.add("������ ���߿� �� ���� ���� ���������¡�");
		msgs.add("�ڷ� ������ ���ء�");
		msgs.add("�׷� ���� ������ �����ִ� ������ �غ��� ��");

		return msgs;
	}


	private ArrayList<String> manageMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("���! ����� �濵���̶���. ��");
		msgs.add("��������°� ������ ��� ���� ��");
		msgs.add("�̷��� �����ڸ� �淯 ���°� ���� �����̾�  ��");
		msgs.add("�� ���� CEO�� �� �� �����ž�!��");
		

		return msgs;
	}
	
	//���㿬����
	private ArrayList<String> staticMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("���! ����� ���㿬�����̶���. ��");
		msgs.add("�Ϲݴ��п��� ����, ����, ���ȫ�����п�, ��");
		msgs.add("��ġ����, �������� �Բ� ����ϴ� �ǹ��̾� ��");
		msgs.add("�����п��� ��ǥ������ �����а�, ��");
		msgs.add("���������а�, �־���������а��� �־� ��");
		msgs.add("�װ� �����п� �� ������ �ִ��� Ȯ���� ���� ��");

		return msgs;
	}
	
	//���� �������
	private ArrayList<String> animalMessage() {
		ArrayList<String> msgs = new ArrayList();
		msgs.add("���! ����� ������������̶���. ��");
		msgs.add("����� ���縦 �ڶ��ϴ� �Ǵ��� ��¡�������� ��");
		msgs.add("����������д���, ����ȯ����д��� �׸��� ��");
		msgs.add("�������Ư���а��� ���յ� �����̾ߡ�");
		msgs.add("�Ǳ� ���� ���÷� ���ڡ�");
		
		return msgs;
	}
	
	
	//���д�
		private ArrayList<String> factoryMessage() {
			ArrayList<String> msgs = new ArrayList();
			msgs.add("���! ����� �����������̶���. ��");
			msgs.add("�ô��� �帧�� �´� �پ��� �������α׷��� ��");
			msgs.add("���������� ����, �����Ͽ�  ��");
			msgs.add("���米�� ����ȭ�� �⿩������");
			msgs.add("�ʵ� â���� �����غ�!��");
			
			return msgs;
		}
	
		
	//���д�
	private void startFactory(){
		if(ch.getClear(8)==0){
			message_ingame = new GameMessage(819, 648, factoryMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							ch.setClear(8);
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	//������
	private void startAnimal(){
		if(ch.getClear(7)==0){
			message_ingame = new GameMessage(819, 648, animalMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							ch.setClear(7);
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	//�濵��
	private void startManageGame(){
		if(ch.getClear(2)==0){
			message_ingame = new GameMessage(819, 648, manageMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							ch.setClear(2);
							panel.setClear(3); //3 ���� ȹ�� 
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
							MyFrame.this.addKeyListener(panel);
							panel.setVisible(true);
							panel.requestFocus();
							MyFrame.this.requestFocusInWindow(true);
							
							
						}
					});
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
		}else{
			
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	
	
	private void startStaticGame(){
		if(ch.getClear(1)==0){
			
			//���� ��ȭ ���� ���� (1)
			message_ingame = new GameMessage(819, 648, staticMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//���� Ŭ���� ����(2)

							staticGame= new StaticGame("���㿬���� ����",ch,new StaticGame.gameEndListener() {
								
								@Override
								public void gameEnd(boolean isClear) {
									// TODO Auto-generated method stub
									
									if(isClear){
										ch.setClear(1);
										panel.setClear(2); //2 ���� ȹ�� 
									}
									
									//���� ȭ�� false �ְ� ������ ����
									staticGame.setVisible(false);
									MyFrame.this.removeMouseListener(staticGame);
									contentpane.remove(staticGame);
									
									//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);
								}
							});

							
							//���� �� ȭ�� false ���ְ� ����ȭ�� ����ִ� �κ�(��ȭ���ڿ� ������ �߰�) (2)
							panel.setVisible(false);
							contentpane.add(staticGame);
							MyFrame.this.addMouseListener(staticGame);
							staticGame.setVisible(true);
							
							
						}
					});
				
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		
	
		}
	}
	
	//��õ��� ����(4)
	private void startSoftGame(){
		if(ch.getClear(4)==0){ //1 �̸� Ŭ����
			
			//���� ��ȭ ���� ���� (1)
			message_ingame = new GameMessage(819, 648, softMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//���� Ŭ���� ����(2)

							soft= new SoftGame("����Ʈ�����а� �ڷᱸ�� ����",ch,new SoftGame.gameEndListener() {
								
								@Override
								public void gameEnd(boolean isClear) {
									// TODO Auto-generated method stub
									
									if(isClear){
										ch.setClear(4);
										panel.setClear(1); //1 ���� ȹ�� 
									}
									
									//���� ȭ�� false �ְ� ������ ����
									soft.setVisible(false);
									MyFrame.this.removeMouseListener(soft);
									contentpane.remove(soft);
									
									//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);
								}
							});

							
							//���� �� ȭ�� false ���ְ� ����ȭ�� ����ִ� �κ�(��ȭ���ڿ� ������ �߰�) (2)
							panel.setVisible(false);
							contentpane.add(soft);
							MyFrame.this.addMouseListener(soft);
							soft.setVisible(true);
							
							
						}
					});
				
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		
	
		}
	}
	
	
	//�ڹ��� ����(5)
	private void startMuseumGame(){
		if (ch.getClear(5) == 0) { //Ŭ���� ���� Ȯ��

			
			//���� ��ȭ ���� ���� (1)
			message_ingame = new GameMessage(819, 648, museumMessage(),
					new GameMessage.GameMessageListener() {

						@Override
						public void endMessage() {
							//���� ��ȭ���� ������ ���ӽ����ϴ� �κ�
							
							
							// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
							message_ingame.setVisible(false);
							MyFrame.this.removeKeyListener(message_ingame);
							contentpane.remove(message_ingame);
							
							
							//���� Ŭ���� ����(2)
							museum = new MuseumGame("�ڹ��� ����", ch, new MuseumGame.gameEndListener() {

								@Override
								public void gameEnd(boolean isClear) {

									//���� ������ ���� �̺�Ʈ(3)
									
								
									if (isClear) {
										//Ŭ���� ������ ĳ���Ϳ� Ŭ���� ���� ����
										ch.setClear(5);
										panel.setClear(0); //0 ���� ȹ�� 
									}
											
									
									
									//���� ȭ�� false �ְ� ������ ����
									museum.setVisible(false);
									MyFrame.this.removeMouseListener(museum);
									contentpane.remove(museum);
									
									//�ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
									MyFrame.this.addKeyListener(panel);
									panel.setVisible(true);
									panel.requestFocus();
									MyFrame.this.requestFocusInWindow(true);

								}
							});

							
							//���� �� ȭ�� false ���ְ� ����ȭ�� ����ִ� �κ�(��ȭ���ڿ� ������ �߰�) (2)
							panel.setVisible(false);
							contentpane.add(museum);
							MyFrame.this.addMouseListener(museum);
							museum.setVisible(true);
							
							
						}
					});
				
			
			//���θ� ȭ�� false���ְ� ��ȭ ���� ����ִ� �κ� (1)
			panel.setVisible(false);
			MyFrame.this.removeKeyListener(panel);
			MyFrame.this.addKeyListener(message_ingame);
			contentpane.add(message_ingame);
			message_ingame.setVisible(true);
			
			
		} else {
					
			//Ŭ���� �� ������ ȭ��
			JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
			panel.requestFocus();
			MyFrame.this.requestFocusInWindow(true);

		}
	}
	// ������ ����(6)
	   private void startArtGame() {
	      if (ch.getClear(6) == 0) { // 1 �̸� Ŭ����

	         panel.setVisible(false);
	         MyFrame.this.removeKeyListener(panel);
	         art = new ArtCulture("������ȭ����", ch, new ArtCulture.gameEndListener() {

	            @Override
	            public void gameEnd(boolean isClear) {

	               if (isClear) {
	                  // Ŭ���� ������ ĳ���Ϳ� Ŭ���� ���� ����
	                  ch.setClear(6);
	                  
	                  panel.setClear(4); //4 ���� ȹ�� 
	               }
	               // TODO Auto-generated method stub
	               art.setVisible(false);
	               MyFrame.this.removeKeyListener(art);
	               contentpane.remove(art);

	               // �ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
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
	         // Ŭ���� �� ������ ȭ��
	         JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
	         panel.requestFocus();
	         MyFrame.this.requestFocusInWindow(true);
	      }
	   }

	
	
	
	
	
//	���Ͽ콺(12)
	private void startKulHouse() {
		panel.setVisible(false);
		MyFrame.this.removeKeyListener(panel);
		kul=new Kulhouse("���Ͽ콺",ch,new Kulhouse.gameEndListener() {
			@Override
			public void gameEnd(boolean isClear) {
				// TODO Auto-generated method stub
				// ���� ȭ�� false �ְ� ������ ����
				kul.setVisible(false);
				MyFrame.this.removeKeyListener(kul);
				contentpane.remove(kul);

				// �ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
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