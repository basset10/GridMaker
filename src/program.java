import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

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


	public static void initialize() {


		hvlLoad("INOF.hvlft");	        //0
		hvlFont(0);	

		for(int i = 0; i < 1920; i=i+Square.SIZE) {
			for(int j = 0; j < 1080; j=j+Square.SIZE) {
				if(i == 0 || j == 0 || i == 1920 - Square.SIZE || j == 1080 - Square.SIZE) {
					squares.add(new Square(i+Square.SIZE/2, j+Square.SIZE/2, false));
				}else {
					squares.add(new Square(i+Square.SIZE/2, j+Square.SIZE/2, true));
				}

			}
		}

	}

	public static void update(){
		
		if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			pauseStatus = false;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !pauseStatus){
			Main.screen = Main.SCREEN_SETTINGS;
			pauseStatus = true;
		}



		if(squares.size() > 0) {
			for(int k = 0; k < squares.size(); k++) {
				squares.get(k).draw();
			}
		}

		if(squares.size() > 0) {
			for(int i = 0; i < squares.size(); i++) {
				hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), 2), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), 2), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() - (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), 2), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() + (Square.SIZE/2)), new HvlCoord(squares.get(i).getxPos() + (Square.SIZE/2), squares.get(i).getyPos() - (Square.SIZE/2)), 2), Color.orange);
			}
		}



		for(int l = 0; l < squares.size(); l++) {
			if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= squares.get(l).getxPos() - Square.SIZE/2 && (Mouse.getX()*10/9) <= squares.get(l).getxPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= squares.get(l).getyPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= squares.get(l).getyPos() - Square.SIZE/2) {
				if(squares.get(l).isOpen()) {
					squares.get(l).setOpen(false);
					if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
						squares.get(l).setSpecial(true);
					}
				}	
			}

			if(Mouse.isButtonDown(1) && (Mouse.getX()*10/9) >= squares.get(l).getxPos() - Square.SIZE/2 && (Mouse.getX()*10/9) <= squares.get(l).getxPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= squares.get(l).getyPos() + Square.SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= squares.get(l).getyPos() - Square.SIZE/2) {
				if(!(squares.get(l).isOpen())) {
					squares.get(l).setOpen(true);
					squares.get(l).setSpecial(false);
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
