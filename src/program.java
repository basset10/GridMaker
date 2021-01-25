import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;

public class program {

	/*
	 * TODO
	 * 
	 * Color key
	 * Save/load
	 * 
	 * 
	 * Lightgrey = air
	 * Darkgrey = wall
	 * Red = potential trap spawn
	 * Magenta = spawn
	 * Cyan = exit
	 * Green = Danger room
	 * 
	 * 
	 * 
	 */

	public static ArrayList<Square> squares = new ArrayList<Square>();
	static float fontY = 0;
	static float fontTimer = 0;
	static boolean pauseStatus = false;
	static String saveText = "";
	static int counter = 0;
	static boolean gridEnabled = true;
	static boolean gridStatus = false;

	public static int brushType = 1;
	

	public static void squaresToText() {
		for(Square s : squares) {

			if(counter%96 == 0 && counter != 0) {
				saveText = saveText + "\n";
			}


			saveText = saveText + s.getBlockType();





			counter++;

		}
	}


	public static void initialize() {
		//Square(int xPosArg, int yPosArg, int blockTypeArg, int wallTypeArg)

		hvlLoad("INOF.hvlft");	        //0
		hvlFont(0);	
		for(int j = 0; j < 1080; j=j+Square.SIZE) {
			for(int i = 0; i < 1920; i=i+Square.SIZE) {

				if(i == 0 || j == 0 || i == 1920 - Square.SIZE || j == 1080 - Square.SIZE) {
					squares.add(new Square(i+Square.SIZE/2, j+Square.SIZE/2, 1, 0));
				}else {
					squares.add(new Square(i+Square.SIZE/2, j+Square.SIZE/2, 0, -1));
				}

			}
		}

	}

	public static void update(){

		if(Keyboard.isKeyDown(Keyboard.KEY_1)) {	
			brushType = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_2)) {	
			brushType = 2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_3)) {	
			brushType = 3;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_4)) {	
			brushType = 4;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_5)) {	
			brushType = 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_6)) {	
			brushType = 6;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_7)) {	
			brushType = 7;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_8)) {	
			brushType = 8;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_9)) {	
			brushType = 9;
		}

		
		
		//Pause key
		if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			pauseStatus = false;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !pauseStatus){
			Main.screen = Main.SCREEN_SETTINGS;
			pauseStatus = true;
		}
		
		//Grid key
		if(!Keyboard.isKeyDown(Keyboard.KEY_G)){
			gridStatus = false;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_G) && !gridStatus){
			gridStatus = true;
			gridEnabled = !gridEnabled;
		}
		
		
		//Save key
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			squaresToText();
			try {
				SaveLoad.writeToFile(saveText);
				System.out.println("Saved!");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}



		if(squares.size() > 0) {
			for(int k = 0; k < squares.size(); k++) {
				squares.get(k).draw();
			}
		}


		//Draw Grid
		if(gridEnabled) {
			if(squares.size() > 0) {
				for(int i = 0; i < squares.size(); i++) {
					hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), 2), Color.orange);
					hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), 2), Color.orange);
					hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), 2), Color.orange);
					hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), 2), Color.orange);
				}
			}
		}



		for(int l = 0; l < squares.size(); l++) {
			//Placing blocks with left click, need to set current block type being painted
			if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= squares.get(l).getxPos() - Square.SIZE/2 && (Mouse.getX()*10/9) <= squares.get(l).getxPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= squares.get(l).getyPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= squares.get(l).getyPos() - Square.SIZE/2) {
				squares.get(l).setBlockType(brushType);	
			}

			//Removing blocks with right click
			if(Mouse.isButtonDown(1) && (Mouse.getX()*10/9) >= squares.get(l).getxPos() - Square.SIZE/2 && (Mouse.getX()*10/9) <= squares.get(l).getxPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= squares.get(l).getyPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= squares.get(l).getyPos() - Square.SIZE/2) {
				if(!(squares.get(l).getBlockType()== 0)) {
					squares.get(l).setBlockType(0);
				}	
			}

		}

		if(fontTimer < 600) {
			hvlFont(0).draw("Left click to place, right click to delete", (1920 / 2) - 503, fontY + 102, Color.black, 0.3f);
			hvlFont(0).draw("Left click to place, right click to delete", (1920 / 2) - 500, fontY + 100, Color.white, 0.3f);

			//fontY = fontY - 1;
		}

		if(fontTimer > 500) {
			fontY = fontY - 2;
		}

		fontTimer = fontTimer + 1;


	}


}
