import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoad {
	
	static File savedLevel;
	static FileWriter fw;
	
	
	public static void createFile() throws IOException{
		savedLevel = new File ("FloorPlan.txt");

		if (!savedLevel.exists()) {
			System.out.println("Creating Save File...");
		}

		fw = new FileWriter(savedLevel);
		

	}
	
	public static void writeToFile(String textToWrite) throws IOException{
		BufferedWriter write = new BufferedWriter(fw);
		System.out.println("Writing to FloorPlan.txt...");
		write.write(textToWrite);
		write.flush();
		write.close();
		
	}

}
