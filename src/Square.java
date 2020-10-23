import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.newdawn.slick.Color;

public class Square {

	public final static int SIZE = 20;
	private int xPos = 0;
	private int yPos = 0;
	private boolean open;
	private boolean special;
	
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

	
	
	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
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
