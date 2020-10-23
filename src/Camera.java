import org.lwjgl.input.Keyboard;

public class Camera {
	
	int xPos;
	int yPos;

	public Camera(int xPosArg, int yPosArg) {
		yPos = yPosArg;
		xPos = xPosArg;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yPos = yPos - 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPos = xPos - 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yPos = yPos + 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPos = xPos + 5;
		}
	}
	
}
