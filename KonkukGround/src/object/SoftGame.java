package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class SoftGame extends Game implements MouseListener {

	Image img_stick;
	Image img_1;
	Image img_2;
	Image img_3;
	Image img_4;
	Image img_5;

	JButton pop1;
	JButton push1;

	JButton pop2;
	JButton push2;
	
	JButton btn_finish;

	JButton pop3;
	JButton push3;

	Image img_success;
	Image img_fail;
	
	Timer timer;
	
	boolean isShowClear;
	boolean isShowFail;
	
	int btn_x = 80;
	int btn_y = 480;

	int btn_intervalX = 270;
	int btn_intervalY = 60;

	int stackPosition[][] = new int[5][3]; // 막대기 위치담는 배열
	ArrayList<Position> stackInfo;
	int selected = 0; // 0:없음, 1->5 로 갈수록 긴 막대기

	SoftGame(String subject, Character ch, gameEndListener listener) {
		super(subject, ch, listener);
		// TODO Auto-generated constructor stub

		this.setLayout(null);
		this.setBackground(Color.white);

		// 막대기 위치
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					stackPosition[i][j] = i + 1;
				} else {
					stackPosition[i][j] = 0;
				}

			}
		}

		// 막대기 절대 위치 좌표값 및 크기 정보
		stackInfo = new ArrayList<Position>();
		stackInfo.add(new Position(60, btn_y - 260, 60, btn_y - 260, 270, 50, 140, 50));
		stackInfo.add(new Position(45, btn_y - 210, 45, btn_y - 260, 270, 50, 170, 50));
		stackInfo.add(new Position(30, btn_y - 160, 30, btn_y - 260, 270, 50, 200, 50));
		stackInfo.add(new Position(15, btn_y - 110, 15, btn_y - 260, 270, 50, 230, 50));
		stackInfo.add(new Position(0, btn_y - 60, 0, btn_y - 260, 270, 50, 270, 50));

		btn_finish = new JButton("게임포기");
		btn_finish.setBounds(550,10,100,40);
		this.add(btn_finish);
		btn_finish.addMouseListener(this);
		
		pop1 = new JButton("pop");
		push1 = new JButton("push");

		pop1.setBounds(btn_x, btn_y, 100, 50);
		push1.setBounds(btn_x, btn_y + btn_intervalY, 100, 50);

		this.add(pop1);
		this.add(push1);
		pop1.addMouseListener(this);
		push1.addMouseListener(this);

		pop2 = new JButton("pop");
		push2 = new JButton("push");

		pop2.setBounds(btn_x + btn_intervalX, btn_y, 100, 50);
		push2.setBounds(btn_x + btn_intervalX, btn_y + btn_intervalY, 100, 50);

		this.add(pop2);
		this.add(push2);
		pop2.addMouseListener(this);
		push2.addMouseListener(this);

		pop3 = new JButton("pop");
		push3 = new JButton("push");

		pop3.setBounds(btn_x + (btn_intervalX * 2), btn_y, 100, 50);
		push3.setBounds(btn_x + (btn_intervalX * 2), btn_y + btn_intervalY, 100, 50);
		pop3.addMouseListener(this);
		push3.addMouseListener(this);
		
		this.add(pop3);
		this.add(push3);

		init();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		// 타이틀
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("소프트웨어학과 자료구조 스택 게임", 0, 40);

		g.drawImage(img_stick, btn_x + 25, btn_y - 310, 50, 300, null);
		g.drawImage(img_stick, btn_x + btn_intervalX + 25, btn_y - 310, 50, 300, null);
		g.drawImage(img_stick, btn_x + (btn_intervalX * 2) + 25, btn_y - 310, 50, 300, null);

		
		if(selected!=5){
			g.drawImage(img_5, stackInfo.get(4).now_x, stackInfo.get(4).now_y, stackInfo.get(4).w, stackInfo.get(4).h,
					null);
		}
		
		if(selected!=4){
			g.drawImage(img_4, stackInfo.get(3).now_x, stackInfo.get(3).now_y, stackInfo.get(3).w, stackInfo.get(3).h,
					null);
		}
		
		if(selected!=3){
			g.drawImage(img_3, stackInfo.get(2).now_x, stackInfo.get(2).now_y, stackInfo.get(2).w, stackInfo.get(2).h,
					null);
		}
		
		if(selected!=2){
			g.drawImage(img_2, stackInfo.get(1).now_x, stackInfo.get(1).now_y, stackInfo.get(1).w, stackInfo.get(1).h,
					null);
		}
		
		
		if(selected!=1){
			g.drawImage(img_1, stackInfo.get(0).now_x, stackInfo.get(0).now_y, stackInfo.get(0).w, stackInfo.get(0).h,
					null);
		}
		

		switch (selected) {
			case 0:
				break;
				
			case 1:
				 g.drawImage(img_1, 330, 80, 140, 50, null);
				break;
				
			case 2:
				 g.drawImage(img_2, 315, 80, 170, 50, null);
				break;
				
			case 3:
				g.drawImage(img_3, 300,80, 200, 50, null);
				break;
				
			case 4:
				 g.drawImage(img_4, 285,80,230, 50, null);
				break;
				
			case 5:
				g.drawImage(img_5,270,80 , 260, 50, null);
				break;
		}
		
		
		
		if(isShowFail){
			g.drawImage(img_fail, 250, 150, null);
		}
			
		if(isShowClear){
			g.drawImage(img_success, 200, 150,null);
		}

		// g.drawImage(img_5,0, btn_y-60 , 260, 50, null);
		// g.drawImage(img_4, 15, btn_y-110,230, 50, null);
		// g.drawImage(img_3, 30, btn_y-160, 200, 50, null);
		// g.drawImage(img_2, 45, btn_y-210, 170, 50, null);
		// g.drawImage(img_1, 60, btn_y-260, 140, 50, null);

		// g.drawImage(img_5,270, btn_y-60 , 260, 50, null);
		// g.drawImage(img_4, 285, btn_y-110,230, 50, null);
		// g.drawImage(img_3, 300, btn_y-160, 200, 50, null);
		// g.drawImage(img_2, 315, btn_y-210, 170, 50, null);
		// g.drawImage(img_1, 330, btn_y-260, 140, 50, null);
		//
		//
		// g.drawImage(img_5,540, btn_y-60 , 260, 50, null);
		// g.drawImage(img_4, 555, btn_y-110,230, 50, null);
		// g.drawImage(img_3, 570, btn_y-160, 200, 50, null);
		// g.drawImage(img_2, 585, btn_y-210, 170, 50, null);
		// g.drawImage(img_1, 600, btn_y-260, 140, 50, null);

	}


	private void init() {

		
		try {
			img_fail = ImageIO.read(new File("images/fail.png"));
			img_success=ImageIO.read(new File("images/clear.png"));
			img_stick = ImageIO.read(new File("images/하노이0.png"));
			img_1 = ImageIO.read(new File("images/하노이1.png"));
			img_2 = ImageIO.read(new File("images/하노이2.png"));
			img_3 = ImageIO.read(new File("images/하노이3.png"));
			img_4 = ImageIO.read(new File("images/하노이4.png"));
			img_5 = ImageIO.read(new File("images/하노이5.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Position {
		int now_x;
		int x;
		int y;
		int now_y;
		int intervalY;
		int intervalX;

		int w;
		int h;

		Position(int now_x, int now_y, int x, int y, int intervalX, int intervalY, int w, int h) {
			this.x = x;
			this.y = y;
			this.now_x = now_x;
			this.w = w;
			this.h = h;
			this.intervalX = intervalX;
			this.now_y = now_y;
			this.intervalY = intervalY;
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

		
		if(btn_finish==e.getSource()){
			isShowFail=true;
			SoftGame.this.repaint();
			
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
		
		if(selected==0){
			if(pop1==e.getSource()){
				doPop(0);
				
			}else if(pop2==e.getSource()){
				doPop(1);
			}else if(pop3==e.getSource()){
				doPop(2);
			}
		}else{
			
			//push 이벤트
			if(push1==e.getSource()){
				doPush(0);
			}else if(push2==e.getSource()){
				doPush(1);
				
			}else if(push3==e.getSource()){
				doPush(2);
			}
			
		}
		
		
		
		
	}
	
	private int getWhichStick(int line){
		int temp=0;
		
		for(int i=0; i< 5 ; i++){
			if(stackPosition[i][line]!=0){
				temp = stackPosition[i][line];
				stackPosition[i][line]=0;
				return temp;
			}
		}
		
		return temp;
	}
	
	private void doPop(int line){
	int temp= getWhichStick(line);
	if(temp!=0){
		selected=temp;
	}
	

	
	SoftGame.this.repaint();
	}
	
	private void doPush(int line){
		if(selected!=0){
			
			int count=0;
			for(int i=1; i<5 ; i++){
				if(stackPosition[i][line]!=0){
					count+=1;
		
					
					if(stackPosition[i][line]>selected){
					
						stackPosition[i-1][line]=selected;
					
						stackInfo.get(selected-1).now_x=(stackInfo.get(selected-1).x)+(stackInfo.get(selected-1).intervalX*(line));
						stackInfo.get(selected-1).now_y= (stackInfo.get(selected-1).y)+(stackInfo.get(selected-1).intervalY*(i-1));
						selected=0;
						
						SoftGame.this.repaint();
						
						
						for(int a=0; a<5; a++){
							for(int b=0 ; b<3 ;b++){
								System.out.print(stackPosition[a][b]);
							}
							System.out.println();
						}
						
						
						if(gameClearCheck()){
							isShowClear=true;
							SoftGame.this.repaint();
							
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
						return;
					}else{
						return;
					}
				}
			}
			
			if(count==0){
				//빈줄
				stackPosition[4][line]=selected;
				stackInfo.get(selected-1).now_x=stackInfo.get(selected-1).x+(stackInfo.get(selected-1).intervalX*line);
				stackInfo.get(selected-1).now_y= stackInfo.get(selected-1).y+(stackInfo.get(selected-1).intervalY*4);
				selected=0;
				SoftGame.this.repaint();
			}
			
			

			

			
		
			
			
			
		}
	}
	
	
	private boolean gameClearCheck(){
		
		boolean isClear=true;
		
		for(int i=0 ; i<5 ; i++){
			if(stackPosition[i][2]==0){
				isClear=false;
				
			}
		}
		
		return isClear;
	}

}
