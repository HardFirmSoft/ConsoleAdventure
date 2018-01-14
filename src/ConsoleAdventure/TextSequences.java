package ConsoleAdventure;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

class TextSequences extends Main{
	static Scanner scanner = new Scanner(System.in);
	
	static void introSequence() throws InterruptedException{
		
		menus.clear();
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("**You open your eyes but everything is still black...**\n");
	    //TimeUnit.SECONDS.sleep(3);
		System.out.print("**Through the darkness, a voice echoes...**\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("Follow me...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("...If you think you're brave enough\n");
		//TimeUnit.SECONDS.sleep(3);
		
		System.out.print("Hello, " + player.getNAME() + "...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("Lets play a little game...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("If you can find me...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("Maybe I'll let you live...\n");
		//TimeUnit.SECONDS.sleep(3);
		menus.clear();
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("...Good luck..\n");
		//TimeUnit.SECONDS.sleep(3);
		menus.clear();
		tutorialSequence();
	}
	
	static void tutorialSequence() throws InterruptedException{
		scanner.reset();
		menus.clear();
		System.out.print("**A torch on the wall next to you bursts into flames!**\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("**In the new dim light, you take a look around you...**\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("**You find yourself alone, surrounded by mossy brick walls...**\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("**On the floor next to you, is a note: \n");
		//TimeUnit.SECONDS.sleep(3);
		menus.clear();
		System.out.print("INSTRUCTIONS\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("Travel room by room, using the 'w','a','s', and 'd' keys.\n");
		System.out.print("It would be wise to keep a map... press 'm' to access it\n");
		//TimeUnit.SECONDS.sleep(5);
		System.out.print("...Keep your wits about you... I said I'd let you live if you found me...\n");
		System.out.print("...But you haven't found me yet...\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("If you find items along the way, press 'i' to access them in your inventory\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("If you forget everything else, just press h for help.\n");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("You should save your progress often, press 'q' to access the save menu\n");
		System.out.print("Try it! Press 'q'\n");

		player.setSTORY_STATUS(1); //1 means done intro + tutorial.
		String option = "";
		while(option.length()==0) option = scanner.nextLine(); 
		while(option.charAt(0)!='q') {
			option="";
			while(option.length()==0) option = scanner.nextLine();
		}
			
			
		option="";
		menus.saveMenu();
		System.out.println("Excellent! Now try pressing 'm' to open your map.");
		while(option.length()==0) option = scanner.nextLine(); 
		while(option.charAt(0)!='m') {
			option="";
			while(option.length()==0) option = scanner.nextLine();
		}
		menus.mapMenu();
		System.out.println("Great, you're ready, now remember, if you need anything at all... Press 'h' to open the help menu");
		TimeUnit.SECONDS.sleep(2);
		GameLoop.launch(); //launch main game loop
	}
}
