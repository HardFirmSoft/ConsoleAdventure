package Items;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String category; //possibly unnecessary, may have sub classes
	
	public Item() {
		this.name = " ";
		this.description = " ";
		this.category = " ";
	}
	public Item(String name, String description,String category){
		this.name = name;
		this.description= description;
		this.category = category;
	}

	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public String getCategory() {
		return this.category;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public void setDescription(String newDescript) {
		this.description = newDescript;
	}
	public void setCategory(String newCat) {
		this.category = newCat;
	}
	
	/*
	 * Basic examine method giving info about an item. 
	 * Will most likely be overriden in subclasses.
	 */
	public void examine() {
		System.out.println(this.getDescription());
	}
	
}
