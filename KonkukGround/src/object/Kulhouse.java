package object;

import java.awt.*;

import javax.swing.*;

public class Kulhouse extends Game{
	Character ch;
	JButton btn_explain,btn_sleep,btn_exit;
	
	public Kulhouse(String subject, Character ch) {
		super(subject, ch);
		// TODO Auto-generated constructor stub
		
		this.ch=ch;
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		init();

		btn_explain=new JButton();
		btn_sleep=new JButton();
		btn_exit=new JButton();
//		btn_o = new JButton(new ImageIcon("images/o.png"));
//		btn_x = new JButton(new ImageIcon("images/x.png"));

		btn_explain.setBounds(350, 150, 400, 100);
		btn_sleep.setBounds(350, 350, 400, 100);
		btn_exit.setBounds(350, 550, 400, 100);

//		btn_x.addMouseListener(this);

//		this.add(btn_o);
//		this.add(btn_x);
	}
	public void init() {
//		img_msg = ImageIO.read(new File("images/¸»Ç³¼±.png"));
	}
	interface ExitListener{
		void Exit();
	}

}
