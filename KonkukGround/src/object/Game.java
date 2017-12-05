package object;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel  {
	
	private String subject;
	private Character ch;
	protected gameEndListener listener;
	
	
	Game(String subject, Character ch,gameEndListener listener){
		this.subject = subject;
		this.ch=ch;
		this.listener = listener;
	}
	
	
	interface gameEndListener{
		void gameEnd(boolean isClear);
	}
	
	
	

}
