package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class StaticGame extends Game implements MouseListener {

	Image img_msg; // ��ȭâ
	Image img_door1; 
	Image img_door2; 

	Image img_success;
	Image img_fail;
	
	boolean isShowClear;
	boolean isShowFail;
	
	boolean isEnding;
	
	
	Timer timer;
	
	int choice=0;
	
	JButton btn_1 , btn_2, btn_3, btn_4 , btn_5;;
	
	
	String q1="���� : 2���� ������ ���� 1���� ������ ������ī�� �ִ�. ";
	String q2="������ �� �� �ϳ��� ���� �����Ͻÿ�. ";
	String q3="";
	
	StaticGame(String subject, Character ch, gameEndListener listener) {
		super(subject, ch, listener);
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		btn_1 = new JButton("����");
		btn_1.setBounds(145, 300, 100, 50);
		
		btn_2 = new JButton("����");
		btn_2.setBounds(345, 300, 100, 50);
		
		btn_3 = new JButton("����");
		btn_3.setBounds(545, 300, 100, 50);
		
		btn_4 = new JButton("�ٲ۴�");
		btn_4.setBounds(245, 540, 100, 50);
		
		btn_5 = new JButton("�ȹٲ۴�");
		btn_5.setBounds(445, 540, 100, 50);
		
		
		this.add(btn_1);
		this.add(btn_2);
		this.add(btn_3);

		
		
		btn_1.addMouseListener(this);
		btn_2.addMouseListener(this);
		btn_3.addMouseListener(this);
		
		btn_4.addMouseListener(this);
		btn_5.addMouseListener(this);
		
		init();
		
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		// Ÿ��Ʋ
				g.setFont(new Font("Serif", Font.BOLD, 30));
				g.drawString("���㿬���� Ȯ����� ����", 0, 40);
				
		g.drawImage(img_msg, 25, 350, null);
		
		if(choice!=3){
			g.drawImage(img_door1, 150, 120, null);
		}
		
		if(choice!=1){
			g.drawImage(img_door1, 350, 120, null);
		}
		
		if(choice!=2){
			g.drawImage(img_door1, 550, 120, null);
		}
		
		
		if(choice==3){
			g.drawImage(img_door2, 140, 110, null);
		}else if(choice==1){
			g.drawImage(img_door2, 340, 110, null);
		}else if(choice==2){
			g.drawImage(img_door2, 540, 110, null);
		}
		
		
		
		
		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD, 25));
		g.drawString(q1 , 70, 430);
		g.drawString(q2 , 70, 470);
		g.drawString(q3 , 70, 510);
		
		if (isShowFail) {
			g.drawImage(img_fail, 250, 150, null);
		}

		if (isShowClear) {
			g.drawImage(img_success, 200, 120, null);
		}
		
	}
	
	
	private void init(){
		try {
			img_msg = ImageIO.read(new File("images/��ǳ��.png"));
			img_door1 = ImageIO.read(new File("images/door.png"));
			img_door2 = ImageIO.read(new File("images/door2.png"));
			img_success = ImageIO.read(new File("images/clear.png"));
			img_fail = ImageIO.read(new File("images/fail.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(choice==0){
			if(btn_1==e.getSource()){
				choice=1;
				btn_1.setBackground(Color.RED);
				
				q1="����� ù���� ���� �����Ͽ���, ��ȸ�ڰ� ���� �����ִ�";
				q2="�ٸ� ���� �����־���. ������ ���� �ٲ� ��ȸ�� �شٸ�";
				q3="����� ���� �ٲܰ��ΰ�?(Ȯ�������� ������ ������ �ؾ���)  ";
				
				
				this.add(btn_4);
				this.add(btn_5);
			
				StaticGame.this.repaint();
				
			}else if(btn_2==e.getSource()){
				choice=2;
				btn_2.setBackground(Color.RED);
				
				q1="����� �ι��� ���� �����Ͽ���, ��ȸ�ڰ� ���� �����ִ�";
				q2="�ٸ� ���� �����־���. ������ ���� �ٲ� ��ȸ�� �شٸ�";
				q3="����� ���� �ٲܰ��ΰ�?(Ȯ�������� ������ ������ �ؾ���)  ";
				
				
				this.add(btn_4);
				this.add(btn_5);
			
				StaticGame.this.repaint();
			}else if(btn_3==e.getSource()){
				choice=3;
				btn_3.setBackground(Color.RED);
				
				q1="����� ������ ���� �����Ͽ���, ��ȸ�ڰ� ���� �����ִ�";
				q2="�ٸ� ���� �����־���. ������ ���� �ٲ� ��ȸ�� �شٸ�";
				q3="����� ���� �ٲܰ��ΰ�?(Ȯ�������� ������ ������ �ؾ���)  ";
				
				this.add(btn_4);
				this.add(btn_5);
				
				StaticGame.this.repaint();
			}
			
		
		}
		
		
		if(e.getSource()==btn_4){
			if(!isEnding){
				isEnding=true;
				isShowClear=true;
				StaticGame.this.repaint();
				
				TimerTask tt = new TimerTask(){

					@Override
					public void run() {
						
						// TODO Auto-generated method stub
						listener.gameEnd(true);
						timer.cancel();
					}
					
				};
				timer = new Timer();
				timer.schedule(tt, 1500,1000);
			}
			
		}else if(e.getSource()==btn_5){
			if(!isEnding){
				isEnding=true;
				isShowFail=true;
				StaticGame.this.repaint();
				
				TimerTask tt = new TimerTask(){

					@Override
					public void run() {
						
						// TODO Auto-generated method stub
						listener.gameEnd(false);
						timer.cancel();
					}
					
				};
				timer = new Timer();
				timer.schedule(tt, 1500,1000);
			}
		}
		
	}
	
	

}
