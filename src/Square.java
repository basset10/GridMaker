import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.newdawn.slick.Color;

public class Square {

	public final static int SIZE = 20;
	private int xPos = 0;
	private int yPos = 0;
	private boolean open;
	private boolean special;
	
	
	/*
	 * SQUARE STATES
	 * 0 : Open Air
	 * 1 : Basic Wall
	 * 2 : Safe Air (No enemies)
	 * 3 : Danger Air (Enemy spawn zone)
	 * 
	 * 
	 * 
	 */
	
	public Square(int xPosArg, int yPosArg, boolean openArg) {
		
		xPos = xPosArg;
		yPos = yPosArg;
		open = openArg;
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
	
	
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void draw() {
		if(open) {			
			if(special) {
				hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.magenta);
			}else {
				hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.gray);
			}
		}else {
			if(special) {
				hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.magenta);
			}else {
				hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.darkGray);
			}
		}
	}
	
	
	
}
