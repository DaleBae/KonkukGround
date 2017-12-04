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

	// 게임 객체
	MuseumGame museum;

	public MyFrame() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width / 2) - 409, (dim.height / 2) - 369);
		this.setTitle("KonkukGround");
		this.setSize(819, 648);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		Container contentpane = this.getContentPane();

		// 인트로 부분
		message = new GameMessage(819, 648, introMessage(), new GameMessage.GameMessageListener() {

			@Override
			public void endMessage() {
				// TODO Auto-generated method stub

				// 본 게임
				MyFrame.this.removeKeyListener(message);
				contentpane.remove(message);

				ch = new Character(); // 캐릭터 생성

				// 메인 맵 생성
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

							if (ch.getClear(5) == 0) {

								message_ingame = new GameMessage(819, 648, museumMessage(),
										new GameMessage.GameMessageListener() {

											@Override
											public void endMessage() {
												
												
												// 본 게임
												message_ingame.setVisible(false);
												MyFrame.this.removeKeyListener(message_ingame);
												contentpane.remove(message_ingame);
												
												
												museum = new MuseumGame("박물관 게임", ch, new MuseumGame.gameEndListener() {

													@Override
													public void gameEnd(boolean isClear) {

														if (isClear) {
															ch.setClear(5);
														}

														museum.setVisible(false);

														MyFrame.this.removeMouseListener(museum);
														contentpane.remove(museum);
														MyFrame.this.addKeyListener(panel);
														panel.setVisible(true);
														panel.requestFocus();
														MyFrame.this.requestFocusInWindow(true);

													}
												});

												panel.setVisible(false);
												contentpane.add(museum);
												MyFrame.this.addMouseListener(museum);
												museum.setVisible(true);
												
												
											}
										});
										
								panel.setVisible(false);
								MyFrame.this.removeKeyListener(panel);
								MyFrame.this.addKeyListener(message_ingame);
								contentpane.add(message_ingame);
								message_ingame.setVisible(true);
								
								
							} else {

								JOptionPane.showMessageDialog(null, "<html>이미 클리어한 건물입니다.</html>");
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
		muse.add("... ▼");
		muse.add(" ... ▼");

		muse.add("그럼 상허 기념 박물관 퀴즈 게임을 시작하자 ▼");

		return muse;
	}

}