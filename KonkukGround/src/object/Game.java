package object;

import javax.swing.JPanel;

public class Game extends JPanel  {
	
	private String subject;
	private Character ch;
	
	
	Game(String subject, Character ch){
		this.subject = subject;
		this.ch=ch;
	}
	
	

}
