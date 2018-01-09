package ConsoleAdventure;

public class Main {
		static Player player;
		static Menus menus = new Menus();
		
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
