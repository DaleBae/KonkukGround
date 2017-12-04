package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import object.Character;

public class MyFrame extends JFrame {
	Mainmap panel;
	Character ch;

	GameMessage message;
	GameMessage message_ingame;

	// ���� ��ü
	MuseumGame museum;

	public MyFrame() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width / 2) - 409, (dim.height / 2) - 369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();

		// ��Ʈ�� �κ�
		message = new GameMessage(819, 648, introMessage(), new GameMessage.GameMessageListener() {

			@Override
			public void endMessage() {
				// TODO Auto-generated method stub

				// �� ����
				MyFrame.this.removeKeyListener(message);
				contentpane.remove(message);

				ch = new Character(); // ĳ���� ����

				// ���� �� ����
				panel = new Mainmap(ch, new Mainmap.mainMapListener() {

					@Override
					public void startGame(int doorNum) {

						switch (doorNum) {

						case 1:

							break;

						case 2:

							break;

						case 4:

							break;

						case 5:

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

							break;

						case 6:

							break;

						case 7:

							break;

						case 8:

							break;

						case 9:

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
		muse.add("... ��");
		muse.add(" ... ��");

		muse.add("�׷� ���� ��� �ڹ��� ���� ������ �������� ��");

		return muse;
	}

}