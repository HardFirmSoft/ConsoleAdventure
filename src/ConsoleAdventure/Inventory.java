package ConsoleAdventure;
import java.io.Serializable;
import java.util.ArrayList;

import items.Item;
public class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;
	private int size;
	private ArrayList<Item> items;
	
	/*
	 * Constructors
	 */
	public Inventory(int size) {
		this.size = size;
		this.items = new ArrayList<Item>();
		for(int i=0; i<size; i++) {
			items.add(new Item());
		}
	}
	
	public Inventory(int size, ArrayList<Item> items) {
		this.size = size;
		this.items = items;
		for(int i=0; i<size; i++) {
			items.add(new Item());
		}
	}
	
	/*
	 * Getters + Setters
	 */
	public int getSize() {
		return size;
	}
	public void setSize(int capacity) {
		this.size = capacity;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	/*
	 * Prints contents of items in a nice fashion.
	 */
	public boolean contains(Item key) {
		for(int i=0; i<this.getSize(); i++) {
			if(this.getItems().get(i).getName().equals(key.getName())) {
				return true;
			}
		}
		return false;
	}
	public void print() {
		
		for(int i=0; i<this.getItems().size(); i++) {
			System.out.print(i + ":");
			System.out.println((this.items.get(i).getName()));
		}
	}
	
	
}
