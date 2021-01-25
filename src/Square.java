import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.newdawn.slick.Color;

public class Square {

	public final static int SIZE = 20;
	private int xPos = 0;
	private int yPos = 0;
	private int blockType;
	private int wallType;


	/*
	 * BLOCK TYPES
	 * 
	 * 0 : Open Air (Enemies can spawn here)
	 * 1 : Basic Wall (Need to specify wall type)
	 * 2 : Safe Air (No enemies)
	 * 3 : Danger Air (Heavy spawn zone)
	 * 
	 * 
	 * 
	 */


	
	//Walls are placed in the pending state, when a button is pressed they will
	//automatically determine which wall type they need to be.
	/*
	 * WALL TYPES
	 * 
	 * -1: Not a wall
	 * 0: Central wall : a
	 * 1: Upper wall : b
	 * 2: Right wall : c
	 * 3: Lower wall : d
	 * 4: Left wall : e
	 * 5: Upper-right corner wall : f
	 * 6: Lower-right corner wall : g
	 * 7: Lower-left corner wall : h
	 * 8: Upper-left corner wall : i
	 * 9: Left-top-right tri wall : j
	 * 10: Top-right-bottom tri wall : k
	 * 11: Right-bottom-left tri wall : l
	 * 12: Bottom-left-top tri wall : m
	 * 13: Top-bottom double wall : n
	 * 14: Left-right double wall : o
	 * 15: Four sided wall : p
	 * 99: Pending wall (Wall has been placed, but not yet assigned a wall type)
	 */


	
	public Square(int xPosArg, int yPosArg, int blockTypeArg, int wallTypeArg) {

		xPos = xPosArg;
		yPos = yPosArg;
		blockType = blockTypeArg;
		wallType = wallTypeArg;
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

	public int getBlockType() {
		return blockType;
	}
	
	public int getWallType() {
		return wallType;
	}
	
	public void setBlockType(int blockTypeArg) {
		blockType = blockTypeArg;
	}
	
	public void setWallType(int wallTypeArg) {
		wallType = wallTypeArg;
	}


	public void draw() {
		//Brush types
		if(blockType == 0) {		
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.gray);
		}else if(blockType == 1){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.darkGray);
		}
		else if(blockType == 2){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.green);
		}
		else if(blockType == 3){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.red);
		}
		else if(blockType == 4){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.yellow);
		}
		else if(blockType == 5){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.magenta);
		}
		else if(blockType == 6){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.cyan);
		}
		else if(blockType == 7){
			hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), Color.blue);
		}
	}



}
