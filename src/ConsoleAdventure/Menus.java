package ConsoleAdventure;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import items.Item;

public class Menus extends Main{
	private String option;
	
	Menus() { //basic constructor
		option = "";
	}
	
	/*
	 * Prints 5000 newline chars to the console.
	 * Doesn't work if there are more than 5000 lines on screen.
	 * Text will as a consequence be printed to the bottom of the console.
	 */
	public void clear() {
		for(int i=0; i<5000; i++) {
			System.out.print("\n");
		}
		System.out.flush();
	}
	
	/*
	 * The main menu. Will only exit when the game is completely quit.
	 * Uses an infinite loop, only printing when print=1.
	 * Launches other menus, or in the case of load, launches main game loop.
	 */
	public void welcomeMenu() throws InterruptedException, IOException{

		int print=1;
		while(1<2){
			
			if(print==1){
				clear();
				System.out.print(
						"   ___                  _         _      _             _                 \n" +
						"  / __|___ _ _  ___ ___| |___    /_\\  __| |_ _____ _ _| |_ _  _ _ _ ___  \n" +
						" | (__/ _ \\ ' \\(_-</ _ \\ / -_)  / _ \\/ _` \\ V / -_) ' \\  _| || | '_/ -_) \n" +
						"  \\___\\___/_||_/__/\\___/_\\___| /_/ \\_\\__,_|\\_/\\___|_||_\\__|\\_,_|_| \\___| \n" +
						"                                                                         \n");
				System.out.print("       -----------------------WELCOME-----------------------\n");
				System.out.print("       ----------------------Main Menu----------------------\n");
				System.out.print("                         Tutorial: Press 't'           \n");
				System.out.print("                         New Game: Press 'n'           \n");
				System.out.print("                         Load Game: Press 'l'          \n");
				System.out.print("                           Exit: Press 'q'             \n");
				System.out.print("       -----------------------WELCOME-----------------------\n");
				print=0;
			}
			
			option=scanner.nextLine();
			while(option.length()==0) {
				option = scanner.nextLine();
				scanner.reset();
			}
			
			if(option.charAt(0)=='t'){
				option="\0";
				print=1;
				System.out.println(option);
				tutorialMenu();
			}
			else if(option.charAt(0)=='l'){
				option="\0";
				print=1;
				File save  = new File("./src/ConsoleAdventure/savedata/save_data.ser");
				if(save.exists())LoadGame.loadGame();
				else System.out.println("Couldn't load, no game exists!");
				GameLoop.launch();
			}
			else if(option.charAt(0)=='n'){
				option="\0";
				print=1;
				newGame();
				
			}
			else if(option.charAt(0)=='q'){
				System.out.print("See ya next time!\n");
				TimeUnit.SECONDS.sleep(1);
				clear();
				scanner.close();
				System.exit(0);
			}
			scanner.reset();

		}

	}
	
	/*
	 * Simple menu, protects from invalid char inputs.
	 * Only returns when input char is 'b'.
	 * Will return to main menu.
	 */
	public void tutorialMenu() {
		option = " ";
		clear();
		System.out.print("-------------Tutorial-------------\n");
		System.out.print("Press 'b' to return\n");
		System.out.print("-----------When in game:----------\n");
		System.out.print("'w','a','s','d' To move north,south, east.");
		System.out.print("'q' opens the save menu.\n");
		System.out.print("'h' opens this menu\n");
		System.out.print("'i' opens your inventory\n");
		System.out.print("'m' opens your map\n");
		System.out.print("'r' describes your current room again.\n");
		System.out.print("-------------Tutorial-------------\n");

			option = scanner.nextLine();
			while(option.length()==0) option = scanner.nextLine();
			while(option.charAt(0)!='b') {
				option="";
				while(option.length()==0)option= scanner.nextLine();
			}
			
	}

	/*
	 * Checks to see if a folder called savedata exists.
	 * Warns the player if one exists.
	 * Only continues if the player chooses to override previous save.
	 * If yes, deletes old files, creates new ones.
	 * Then launches introduction text sequence.
	 * 
	 */
 public void newGame() throws IOException, InterruptedException{
		option = "";
		player = new Player(); //new player with default values
		File savedata = new File("./src/ConsoleAdventure/savedata");
		
		
		if(savedata.exists() && savedata.isDirectory()){
			System.out.println("A previous game already exists, creating a new game would overwrite it. Are you sure you want to continue? Press y for yes, n for no.\n");
			while(option.length()==0)option = scanner.nextLine();
			while(option.charAt(0)!= 'y' && option.charAt(0)!='n') {
				option="";
				while(option.length()==0)option = scanner.nextLine();
				
			}
			if(option.charAt(0)=='n') {
				clear();
				return;
			}
		}
			
		
		savedata.mkdir();
		File saveData = new File("./src/ConsoleAdventure/savedata/save_data.ser");
		saveData.delete();
		saveData.createNewFile();
		
		System.out.println("What would you like to be called?"); 
		String temp = "";
		while(temp.length() == 0)temp = scanner.nextLine();
		scanner.reset();
		player.setNAME(temp);
		SaveGame.save();
		TextSequences.introSequence();
	}
	
	/*
	 * Simple menu, protects from invalid char inputs.
	 * If player is about to quit without saving, warns player.
	 * Quits only if 'y' is input
	 * 
	 */
	public void saveMenu() throws InterruptedException{
		int saved=0;
		String option= "";

		clear();
		System.out.print("------Save Menu------\n");
		System.out.print("Press 's' to save game\n");
		System.out.print("Press 'q' to quit\n");
		System.out.print("Press 'b' to return to game.\n");
		System.out.print("------Save Menu------\n");
		
		while(option.length()==0) option=scanner.nextLine();
		while(option.charAt(0)!='b') {
					
			if(option.charAt(0)=='s'){
				saved=1;
			    SaveGame.save();
			}
			if(option.charAt(0)=='q'){
						
				if(saved==0){
					System.out.print("You have unsaved progress! Are you sure you want to quit? (y for yes, n for no)\n");
					option="";
					while(option.length()==0) option = scanner.nextLine();
					if(option.charAt(0) == 'y'){
						System.out.print("Bye for now!\n");
						TimeUnit.SECONDS.sleep(2);
						clear();
						System.exit(0);
					}
					else if(option.charAt(0)=='n') {
					}
				}
				else{
					System.out.print("Bye for now!\n");
					TimeUnit.SECONDS.sleep(2);
					clear();
					System.exit(0);
				}
			}
			option="";
			while(option.length()==0)option=scanner.nextLine(); //just before end of loop
		}
			

	}
	
	/*
	 * Simple menu, displays the map
	 */
	public void mapMenu() throws InterruptedException{
		String option = "";
		clear();
		player.getMAP().print();
		System.out.println("Press 'b' to return to game.");
		System.out.println("The 'x' represents your current location. The '*' represent the rooms you've visited.");
		
		while(option.length()==0) option = scanner.nextLine();
		while(option.charAt(0)!= 'b') {
			option="";
			while(option.length() == 0) option = scanner.nextLine();
		}
	}

	public void itemsMenu() throws InterruptedException{
		String option = "";
		clear();
		Inventory inv = player.getINV();
		
		System.out.print("-----------Items Menu-----------\n");
		System.out.print("Enter a number to select an item\n");
		System.out.print("Press 'b' to return to game.\n");
		inv.print();
		System.out.print("-----------Items Menu-----------\n");

		while(option.length()==0) option = scanner.nextLine();
		while(true){
			try{
				if(option.charAt(0) == 'b') break;
				int index = Integer.parseInt(option);
				if(index > inv.getSize()){
					throw new NumberFormatException();
				}
				Item item = inv.getItems().get(index);
				item.examine();
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Press 'u' to use: " + item.getName() + " or press 'b' to return.");
				option="";
				while(option.length() == 0) option = scanner.nextLine();
				if(option.charAt(0) == 'u'){
					clear();
					item.use();
					break;
				}
			}catch(NumberFormatException e){
				option = "";
				System.out.println("Enter a valid number or leave!");
				TimeUnit.SECONDS.sleep(2);
				while(option.length() == 0) option = scanner.nextLine();
			}
		}
	}
}
