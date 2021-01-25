import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;


public class SettingsScreen {
	
	static final int KEY_SIZE = 80;
	
	static final int POINTER_SIZE = 90;

	public static void update() {
		
		System.out.println("Brush type: " + program.brushType);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_1)) {	
			program.brushType = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_2)) {	
			program.brushType = 2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_3)) {	
			program.brushType = 3;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_4)) {	
			program.brushType = 4;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_5)) {	
			program.brushType = 5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_6)) {	
			program.brushType = 6;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_7)) {	
			program.brushType = 7;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_8)) {	
			program.brushType = 8;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_9)) {	
			program.brushType = 9;
		}

		if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 300 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 300 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 1;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 500 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 2;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 700 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 700 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 3;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 900 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 900 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 4;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 1100 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 1100 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 5;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 1300 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 1300 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 6;
		}else if(Mouse.isButtonDown(0) && (Mouse.getX()*10/9) >= 1500 - KEY_SIZE/2 && Mouse.getX()*10/9 <= 1500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 <= 500 + KEY_SIZE/2 && (Display.getHeight()-(Mouse.getY()))/.9 >= 500 - KEY_SIZE/2) {
			program.brushType = 7;
		}
		
		if(program.brushType == 1) {
			hvlDraw(hvlQuadc(300, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 2) {
			hvlDraw(hvlQuadc(500, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 3) {
			hvlDraw(hvlQuadc(700, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 4) {
			hvlDraw(hvlQuadc(900, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 5) {
			hvlDraw(hvlQuadc(1100, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 6) {
			hvlDraw(hvlQuadc(1300, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}else if(program.brushType == 7) {
			hvlDraw(hvlQuadc(1500, 500, POINTER_SIZE, POINTER_SIZE), Color.white);
		}
		
		if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			program.pauseStatus = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !program.pauseStatus){
			Main.screen = Main.SCREEN_MAIN;
			program.pauseStatus = true;
		}
		
		hvlFont(0).draw("Esc to return to program", (1920 / 2) - 330, 100, Color.white, 0.3f);
		hvlFont(0).draw("\"g\" to toggle grid on/off", (1920 / 2) - 260, 800, Color.white, 0.2f);
		
		hvlDraw(hvlQuadc(300, 500, KEY_SIZE, KEY_SIZE), Color.darkGray);
		hvlDraw(hvlQuadc(500, 500, KEY_SIZE, KEY_SIZE), Color.green);
		hvlDraw(hvlQuadc(700, 500, KEY_SIZE, KEY_SIZE), Color.red);
		hvlDraw(hvlQuadc(900, 500, KEY_SIZE, KEY_SIZE), Color.yellow);
		hvlDraw(hvlQuadc(1100, 500, KEY_SIZE, KEY_SIZE), Color.magenta);
		hvlDraw(hvlQuadc(1300, 500, KEY_SIZE, KEY_SIZE), Color.cyan);
		hvlDraw(hvlQuadc(1500, 500, KEY_SIZE, KEY_SIZE), Color.blue);
		
		
		hvlFont(0).drawc("wall", 300, 600, Color.white, 0.2f);
		hvlFont(0).drawc("safezone", 500, 600, Color.white, 0.2f);
		hvlFont(0).drawc("danger", 700, 600, Color.white, 0.2f);
		hvlFont(0).drawc("treasure", 900, 600, Color.white, 0.2f);
		hvlFont(0).drawc("????", 1100, 600, Color.white, 0.2f);
		hvlFont(0).drawc("spawn", 1300, 600, Color.white, 0.2f);
		hvlFont(0).drawc("exit", 1500, 600, Color.white, 0.2f);
		
	}
	
}
