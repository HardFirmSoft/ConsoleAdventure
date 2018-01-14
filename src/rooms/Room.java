package rooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ConsoleAdventure.Main;
import items.Item;
import mobs.Mob;
import npcs.NPC;

public class Room extends Main implements Serializable{
	
	String option = "";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean visited;
	private int x_coordinate;
	private int y_coordinate;
	protected boolean isLocked = false;
	private ArrayList<Item> items;
	private ArrayList<Mob> mobs;
	private ArrayList<NPC> npcs;
	
	public Room() {
		
		items = new ArrayList<Item>();
		mobs = new ArrayList<Mob>();
		npcs = new ArrayList<NPC>();
		
	}
	
	
	public Room(int x, int y) {
		this.x_coordinate = x;
		this.y_coordinate = y;
		items = new ArrayList<Item>();
		mobs = new ArrayList<Mob>();
		npcs = new ArrayList<NPC>();
	}
	
	public static String toString(ArrayList<Item> items) {
		String output = "";
		for(int i=0; i<items.size(); i++) {
			output = output + items.get(i).getName() + ",\n";
		}
		return output;
	}
	
	public int getx_coordinate() {
		return this.x_coordinate;
	}
	
	public int gety_coordinate() {
		return this.y_coordinate;
	}
	
	public void setx_coordinate(int x) {
		this.x_coordinate=x;
	}
	public void sety_coordinate(int y) {
		this.y_coordinate=y;
	}
	public boolean isLocked() {
		return this.isLocked;
	}
	public boolean isVisited(){
		if(this.visited == true)return true;
		else return false;
	}
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}


	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public ArrayList<Mob> getMobs() {
		return mobs;
	}


	public void setMobs(ArrayList<Mob> mobs) {
		this.mobs = mobs;
	}


	public ArrayList<NPC> getNpcs() {
		return npcs;
	}


	public void setNpcs(ArrayList<NPC> npcs) {
		this.npcs = npcs;
	}


	public boolean equals(Room room) {
		if(this.getx_coordinate() == room.getx_coordinate() && this.gety_coordinate() == room.gety_coordinate()) {
			return true;
		}else {
			return false;
		}
	}

	public void describe() throws InterruptedException{
		option="";
		//if the room isn't empty, describe it, and offer to pick up item.
		if(!this.getItems().isEmpty()) {
			menus.clear();
			System.out.println("Looking around the room, you see: " +  toString(this.getItems()));
			System.out.println("Would you like to pick it up? [y/n]");
			
			while(option.length()==0) option = scanner.nextLine();
			while(option.charAt(0)!= 'n' && option.charAt(0) !='y') {
				option="";
				while(option.length() == 0) option = scanner.nextLine();
			}
			if(option.charAt(0)=='y') {
				System.out.println(this.getItems().get(0).getName() + " has been added to your inventory.");
				TimeUnit.SECONDS.sleep(2);
				player.getINV().getItems().add(this.getItems().get(0));
				this.getItems().remove(0);
				
			}
		}else {
			System.out.println("The room is empty, you've already cleared it!");
			//TimeUnit.SECONDS.sleep(2);
		}
		
		
	}
	
	
}
