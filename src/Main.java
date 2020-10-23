import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlScale;
import static com.osreboot.ridhvl2.HvlStatics.hvlTranslate;

import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.template.HvlDisplay;
import com.osreboot.ridhvl2.template.HvlDisplayWindowed;
import com.osreboot.ridhvl2.template.HvlTemplateI;


public class Main extends HvlTemplateI{
	//Test Push
	Camera cam;
	public static int SCREEN_MAIN = 1;
	public static int SCREEN_SETTINGS = 2;

	static int screen = 1;


	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super(new HvlDisplayWindowed(144, 1728, 972, "Gird Time", true));
		// TODO Auto-generated constructor stub
	}



	@Override
	public void initialize() {
		cam = new Camera(1920/2, 1080/2);
		program.initialize();
	}

	@Override
	public void update(float delta) {

		hvlTranslate(-(cam.getxPos() - Display.getWidth()/2), -(cam.getyPos() - Display.getHeight()/2), () ->{


			hvlScale(cam.getxPos(), cam.getyPos(), 0.9f, () -> {

				if(screen == SCREEN_MAIN) {
					program.update();
				}else if(screen == SCREEN_SETTINGS) {
					SettingsScreen.update();
				}
			});

		});


	}
}
