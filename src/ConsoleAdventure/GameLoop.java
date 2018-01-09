package ConsoleAdventure;

import java.util.Scanner;

public class GameLoop extends Main {
	
	
	public static void launch() throws InterruptedException {
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		while(quit==false) {
			menus.clear();
			String option="";
			option="";
			while(option.length()==0)option= input.nextLine();
			if(option.charAt(0)=='w') player.getMAP().move('w');
			if(option.charAt(0)=='a') player.getMAP().move('a');
			if(option.charAt(0)=='s') player.getMAP().move('s');
			if(option.charAt(0)=='d') player.getMAP().move('d');
			if(option.charAt(0)=='h') menus.tutorialMenu();
			if(option.charAt(0)=='q') menus.saveMenu();
			if(option.charAt(0)=='i') menus.itemsMenu();
			if(option.charAt(0)=='m') menus.mapMenu();
		}
		input.close();
	}
}
