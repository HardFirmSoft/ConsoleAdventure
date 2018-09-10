package items;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;

	public Item() {
		this.name = " ";
		this.description = " ";
		
	}
	public Item(String name, String description,String category){
		this.name = name;
		this.description= description;
		
	}

	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	public void setDescription(String newDescript) {
		this.description = newDescript;
	}
	
	
	/*
	 * Basic examine method giving info about an item. 
	 * Will most likely be overriden in subclasses.
	 */
	public void examine() {
		System.out.println(this.getDescription());
	}
	
	public void use(){
		System.out.println("Used item: " + this.getName());
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}
	
	
}
