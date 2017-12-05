package object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import object.ArtCulture.GameEndListener;
import object.Character;

public class MyFrame extends JFrame {
	Mainmap panel;
	Character ch;

	GameMessage message;

	GameMessage message_ingame;
	Kulhouse kul;
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

							if (ch.getClear(5) == 0) { // Ŭ���� ���� Ȯ��

								// ���θ� ȭ�� false���ְ� ���������� (1)
								panel.setVisible(false);
								MyFrame.this.removeKeyListener(panel);

								// ���� ��ȭ ���� ���� (1)
								message_ingame = new GameMessage(819, 648, museumMessage(),
										new GameMessage.GameMessageListener() {

											@Override
											public void endMessage() {
												// ���� ��ȭ���� ������ ���ӽ����ϴ� �κ�

												// �޼��� ȭ�� false�� ���ְ� ������ ����(2)
												message_ingame.setVisible(false);
												MyFrame.this.removeKeyListener(message_ingame);
												contentpane.remove(message_ingame);

												// ���� Ŭ���� ����(2)
												museum = new MuseumGame("�ڹ��� ����", ch, new MuseumGame.gameEndListener() {

													@Override
													public void gameEnd(boolean isClear) {

														// ���� ������ ���� �̺�Ʈ(3)

														if (isClear) {
															// Ŭ���� ������ ĳ���Ϳ� Ŭ���� ���� ����
															ch.setClear(5);
														}

														// ���� ȭ�� false �ְ� ������ ����
														museum.setVisible(false);
														MyFrame.this.removeMouseListener(museum);
														contentpane.remove(museum);

														// �ٽ� ���θ� ȭ�� �����ְ� ������ ���� ���� (3)
														MyFrame.this.addKeyListener(panel);
														panel.setVisible(true);
														panel.requestFocus();
														MyFrame.this.requestFocusInWindow(true);

													}
												});

												// ���� �� ȭ�� false ���ְ� ����ȭ�� ����ִ� �κ�(��ȭ���ڿ� ������ �߰�) (2)

												contentpane.add(museum);
												MyFrame.this.addMouseListener(museum);
												museum.setVisible(true);

											}
										});

								// ��ȭ���� �߰� �� ������ �߰�(1)
								MyFrame.this.addKeyListener(message_ingame);
								contentpane.add(message_ingame);
								message_ingame.setVisible(true);

							} else {
								// Ŭ���� �� ������ ȭ��
								JOptionPane.showMessageDialog(null, "<html>�̹� Ŭ������ �ǹ��Դϴ�.</html>");
								panel.requestFocus();
								MyFrame.this.requestFocusInWindow(true);

							}

							break;

						case 6:
							panel.setVisible(false);
							MyFrame.this.removeKeyListener(panel);
							
							ArtCulture art=new ArtCulture("������ȭ����",ch,new GameEndListener() {

								@Override
								public void GameEnd() {
									// TODO Auto-generated method stub
									
								}
								
							});
							contentpane.add(art);
							art.setVisible(true);
							
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
							panel.setVisible(false);
							MyFrame.this.removeKeyListener(panel);
							kul=new Kulhouse("���Ͽ콺",ch,new Kulhouse.ExitListener() {
								
								@Override
								public void ExitHere() {
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
							MyFrame.this.addKeyListener(kul);
							kul.setVisible(true);
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