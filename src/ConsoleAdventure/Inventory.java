package ConsoleAdventure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import items.Item;

public class Inventory implements Serializable, Iterable<Item>{

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

	@Override
	public Iterator<Item> iterator(){
		return this.getItems().iterator();

	}

	public boolean contains(Item item) {
		for(Item i: this) {
			if(i.getName().equals(item.getName())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Prints contents of items in a nice fashion.
	 */
	public void print() {
		for(int i=0; i<this.getItems().size(); i++) {
			System.out.print(i + ":");
			System.out.println((this.items.get(i).getName()));
		}
	}
	
	
}
