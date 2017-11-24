package object;

public class Character {
	private int posX, posY;

	public Character() {
		// TODO Auto-generated constructor stub
		this.posX = 0;
		this.posY = 0;
	}

	public void moveUp() {
		if (posY > 0 && posY <= 360) {
			posY -= 40;
		}
	}

	public void moveDown() {
		if (posY >= 0 && posY < 360) {
			posY += 40;
		}
	}

	public void moveLeft() {
		if (posX > 0 && posX <= 360) {
			posX -= 40;
		}
	}

	public void moveRight() {
		if (posX >= 0 && posX < 360) {
			posX += 40;
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
