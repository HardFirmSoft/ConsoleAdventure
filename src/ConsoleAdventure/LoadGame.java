package ConsoleAdventure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class LoadGame extends Main implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	static void loadGame(){
		 
		try {
			  loadData();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	}  
	
	
	static void loadData() throws IOException, ClassNotFoundException, InterruptedException{
		
		FileInputStream fis = new FileInputStream("./src/ConsoleAdventure/savedata/player_data.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    player = ((Player) ois.readObject());
	    ois.close();
	    System.out.println("Loading game data...");
		TimeUnit.SECONDS.sleep(2);
	}
}
