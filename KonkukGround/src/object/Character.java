package object;

import java.awt.*;

public class Character {
	private Point pt;
	private int dir; // 0 아래 1 위 2 왼쪽 3 오른쪽
	private boolean LandorNot;
	public Character() {
		// TODO Auto-generated constructor stub
		pt = new Point(160, 160);
		dir = 0;
		LandorNot=false;
	}

	public void moveUp() {
		if (pt.getY() > 0 && pt.getY() <= 360) {
			pt.y -= 40;
		}
	}

	public void moveDown() {
		if (pt.getY() >= 0 && pt.getY() < 360) {
			pt.y += 40;
		}
	}

	public void moveLeft() {
		if (pt.getX() > 0 && pt.getX() <= 360) {
			pt.x -= 40;
		}
	}

	public void moveRight() {
		if (pt.getX() >= 0 && pt.getX() < 360) {
			pt.x += 40;
		}
	}

	public int getPosX() {
		return pt.x;
	}

	public int getPosY() {
		return pt.y;
	}
	
	public void setdir(int a) {
		dir=a;
	}
	public int getdir() {
		return dir;
	}
	public boolean getlandornot() {
		return LandorNot;
	}
	public void setlandornot(boolean b) {
		LandorNot=b;
	}
}
