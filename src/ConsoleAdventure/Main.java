package ConsoleAdventure;

import java.util.Scanner;

public class Main {
		public static Player player;
		public static Menus menus = new Menus();
		public Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			
			/*
			 * Launches welcome menu.
			 * Handles all lingering exceptions coming from subclasses 
			 * All subclasses requiring fields contained in:
			 * "player" or "menus" will extend Main.
			 * 
			 */
			try {
				
				menus.welcomeMenu();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
