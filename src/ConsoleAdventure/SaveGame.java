package ConsoleAdventure;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SaveGame extends Main implements Serializable{
	private static final long serialVersionUID = 1L;
	
	static void save(){
		
		try {
			// savePlayerStatus();
			 saveData();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static void saveData() throws IOException{
		//Write Student array to file.
	    FileOutputStream fileOutputStream = new FileOutputStream("./src/ConsoleAdventure/savedata/player_data.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
	    oos.writeObject(player);
	    oos.close();
	    System.out.println("Game has been saved!");
	}
}
