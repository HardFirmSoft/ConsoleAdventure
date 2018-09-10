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

	private static final long serialVersionUID = 1L;
	private boolean visited;
	private int x_coordinate;
	private int y_coordinate;
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

	public boolean isVisited(){
		return this.visited;
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

	public void describe() throws InterruptedException{}
	
	
}
