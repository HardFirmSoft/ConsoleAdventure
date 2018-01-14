package ConsoleAdventure;

import java.util.Scanner;

import items.Rope;

public class GameLoop extends Main {
	
	
	public static void launch() throws InterruptedException {
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		int print=1;
		player.getMAP().getCurrentRoom().describe();
		while(quit==false) {
			if(print==1){
				menus.clear();
				System.out.print("***********CONSOLE ADVENTURE**********\n");
				System.out.print("***      For Help Menu: Press 'h'  ***\n");
				System.out.print("***     'w,a,s,d' Keys to move.    ***\n");
				System.out.print("***      For Map Menu: Press 'm'   ***\n");
				System.out.print("*** For room description Press 'r' ***\n");
				System.out.print("***To open Inventory Menu Press 'i'***\n");
				System.out.print("***To open Save/Quit Menu Press 'q'***\n");
				System.out.print("***********CONSOLE ADVENTURE**********\n");
				print=0;
			}
			String option="";
			while(option.length()==0)option= input.nextLine();
			if(option.charAt(0)=='w') {
				player.getMAP().move('w');
				print=1;
			}
			if(option.charAt(0)=='a') {
				player.getMAP().move('a');
				print=1;
			}
			if(option.charAt(0)=='s') { 
				player.getMAP().move('s');
				print=1;
			}
			if(option.charAt(0)=='d') {
				player.getMAP().move('d');
				print=1;
			}
			if(option.charAt(0)=='h') {
				menus.tutorialMenu();
				print=1;
			}
			if(option.charAt(0)=='q') {
				menus.saveMenu();
				print=1;
			}
				
			if(option.charAt(0)=='i') {
				menus.itemsMenu();
				print=1;
			}
			if(option.charAt(0)=='m') {
				menus.mapMenu();
				print=1;
			}
			if(option.charAt(0)=='r') {
				player.getMAP().getCurrentRoom().describe();
				print=1;
			}
		}
		input.close();
	}
}
