package object;

import java.awt.*;

public class Character {
	private Point pt;
	private int dir; // 0 아래 1 위 2 왼쪽 3 오른쪽
	private boolean LandorNot;

	private int hp;
	
	private int clear[];

	
	public Character() {
		// TODO Auto-generated constructor stub
		pt = new Point(320, 40);
		dir = 0;
		LandorNot = false;
		hp=200;
		clear = new int[10];
		
		for(int i=0; i<clear.length ;i++){
			clear[i]=0;
		}
	}
	
	
	public void setClear(int index){
		clear[index] = 1;
	}
	
	public int getClear(int index){
		return clear[index];
	}

	public int getHP() {
		return hp;
	}
	public void setHP(int _hp) {
		this.hp=_hp;
	}
	////////////////////// Move 함수 //////////////////////
	public void moveUp() {
		if (pt.getY() > 0 && pt.getY() <= 560) {
			pt.y -= 40;
		}
	}

	public void moveDown() {
		if (pt.getY() >= 0 && pt.getY() < 560) {
			pt.y += 40;
		}
	}

	public void moveLeft() {
		if (pt.getX() > 0 && pt.getX() <= 760) {
			pt.x -= 40;
		}
	}

	public void moveRight() {
		if (pt.getX() >= 0 && pt.getX() < 760) {
			pt.x += 40;
		}
	}

	////////////////////// get 함수 //////////////////////

	public int getPosX() {
		return pt.x;
	}

	public int getPosY() {
		return pt.y;
	}

	public boolean getlandornot() {
		return LandorNot;
	}

	public int getdir() {
		return dir;
	}

	////////////////////// set 함수 //////////////////////

	public void setlandornot(boolean b) {
		LandorNot = b;
	}

	public void setdir(int a) {
		dir = a;
	}
	public void setPosX(int a) {
		pt.x=a;
	}
	public void setPosY(int a) {
		pt.y=a;
	}
}
