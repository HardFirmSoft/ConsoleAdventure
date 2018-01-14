package rooms;

import java.util.ArrayList;

import items.BucketOfTar;
import items.Item;

public class StartingRoom extends Room {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StartingRoom(int x, int y){
		this.setx_coordinate(x);
		this.sety_coordinate(y);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new BucketOfTar());
		this.setItems(items);
	}
	
	
}
