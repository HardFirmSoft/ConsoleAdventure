package ConsoleAdventure;
import java.io.Serializable;

import Items.Item;
class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;
	private int capacity;
	private Item[] items;
	
	/*
	 * Constructors
	 */
	public Inventory(int cap) {
		this.capacity = cap;
		this.items = new Item[cap];
		for(int i=0; i<cap; i++) {
			items[i] = new Item();
		}
	}
	
	public Inventory(int cap, Item[] items) {
		this.capacity = cap;
		this.items = items;
		for(int i=0; i<cap; i++) {
			items[i] = new Item();
		}
	}
	
	/*
	 * Getters + Setters
	 */
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	/*
	 * Prints contents of items in a nice fashion.
	 */
	public void print() {
		
		for(int i=0;i<this.capacity; i++) {
			System.out.print(i + ":");
			System.out.println((this.items[i].getName()));
		}
	}
	
	
}
