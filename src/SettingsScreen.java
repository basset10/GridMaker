import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;


public class SettingsScreen {
	
	static final int KEY_SIZE = 80;

	public static void update() {
		
		if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			program.pauseStatus = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !program.pauseStatus){
			Main.screen = Main.SCREEN_MAIN;
			program.pauseStatus = true;
		}
		
		hvlFont(0).draw("Esc to return to program", (1920 / 2) - 330, 100, Color.white, 0.3f);
		
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
