package mobs;

import java.io.Serializable;
import java.util.ArrayList;

import ConsoleAdventure.Main;

public class Mob extends Main implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	public Mob() {
		
	}
	
	public void encounter() throws InterruptedException{
		System.out.println("You have time to make a move! Fight ('f'), run back('r'), or try to sneak past('s')?");
		String option = "";
		option=scanner.nextLine();
		while(option.length()==0) {
			option = scanner.nextLine();
			scanner.reset();
		}
		
		if(option.charAt(0)=='r'){
			
		}
		else if(option.charAt(0)=='s'){
			System.out.println("Which direction?");
			option="";
			while(option.length()==0) option = scanner.nextLine();
			while(option.charAt(0)!='w' && option.charAt(0) != 'a' && option.charAt(0)!='s' && option.charAt(0)!='d'){
				while(option.length() ==0)option = scanner.nextLine();
			}
			player.sneak(option.charAt(0));
		}
		else if(option.charAt(0)=='f'){
			menus.itemsMenu();
		}
	}
	
	public void describe() {
		
	}
}
