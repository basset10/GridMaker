import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;

public class Square {

	public final static int SIZE = 20;
	private int xPos = 0;
	private int yPos = 0;
	private int blockType;
	private int wallType;

	private int clock = 0;


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



	//Walls are placed in the pending state, they will automatically update to match surrounding walls.
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

	//Check nearby blocks for every block. 
	public void checkNearbyWalls() {
		clock++;
		if(clock == 5) {
			//for(Square s : program.squares) {
				if(blockType == 1) {
				System.out.println("Checking");
				boolean north = false;
				boolean south = false;
				boolean east = false;
				boolean west = false;

				

					//North Block
					if((getSquareByPosition(this.getxPos(), this.getyPos()-SIZE) != null)){
						if((getSquareByPosition(this.getxPos(), this.getyPos()-SIZE)).getBlockType() == 1) {
							north = true;
						}
					}
					//East Block
					if((getSquareByPosition(this.getxPos()+SIZE, this.getyPos()) != null)){
						if((getSquareByPosition(this.getxPos()+SIZE, this.getyPos())).getBlockType() == 1) {
							east = true;
						}
					}
					//South Block
					if((getSquareByPosition(this.getxPos(), this.getyPos()+SIZE) != null)){
						if((getSquareByPosition(this.getxPos(), this.getyPos()+SIZE)).getBlockType() == 1) {
							south = true;
						}
					}
					//West Block
					if((getSquareByPosition(this.getxPos()-SIZE, this.getyPos())!= null)){
						if((getSquareByPosition(this.getxPos()-SIZE, this.getyPos())).getBlockType() == 1) {
							west = true;
						}
					}

					if(north && !east && !south && !west) {
						this.setWallType(11);
					}else if(!north && east && !south && !west) {
						this.setWallType(12);
					}else if(!north && !east && south && !west) {
						this.setWallType(9);
					}else if(!north && !east && !south && west) {
						this.setWallType(10);
					}else if(!north && !east && !south && !west) {
						this.setWallType(15);
					}else if(north && east && south && west) {
						this.setWallType(0);
					}else if(north && east && !south && !west) {
						this.setWallType(7);
					}else if(north && !east && south && !west) {
						this.setWallType(14);
					}else if(north && !east && !south && west) {
						this.setWallType(6);
					}else if(!north && east && south && !west) {
						this.setWallType(8);
					}else if(!north && east && !south && west) {
						this.setWallType(13);
					}else if(north && east && south && !west) {
						this.setWallType(4);
					}else if(!north && east && south && west) {
						this.setWallType(1);
					}else if(north && !east && south && west) {
						this.setWallType(2);
					}else if(north && east && !south && west) {
						this.setWallType(3);
					}else if(!north && !east && south && west) {
						this.setWallType(5);
					} 

				}
				clock = 0;
			//}
		}
	}

	public Square getSquareByPosition(int xArg, int yArg) {
		for(Square s : program.squares) {
			if(s.getxPos() == xArg && s.getyPos() == yArg) {
				return s;
			}	
		}
		return null;
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

	public void drawUpperWall() {
		hvlDraw(hvlLine(new HvlCoord(xPos-SIZE/2, yPos-SIZE/2), new HvlCoord(xPos+SIZE/2, yPos-SIZE/2), 4), Color.black);
	}

	public void drawRightWall() {
		hvlDraw(hvlLine(new HvlCoord(xPos+SIZE/2, yPos-SIZE/2), new HvlCoord(xPos+SIZE/2, yPos+SIZE/2), 4), Color.black);
	}

	public void drawLeftWall() {
		hvlDraw(hvlLine(new HvlCoord(xPos-SIZE/2, yPos-SIZE/2), new HvlCoord(xPos-SIZE/2, yPos+SIZE/2), 4), Color.black);
	}

	public void drawLowerWall() {
		hvlDraw(hvlLine(new HvlCoord(xPos-SIZE/2, yPos+SIZE/2), new HvlCoord(xPos+SIZE/2, yPos+SIZE/2), 4), Color.black);
	}


}
