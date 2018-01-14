package rooms;

import java.util.ArrayList;

import items.BucketOfTar;
import items.Item;
import items.RegularKey;

public class ItemFoundRoom extends Room{

	
	private static final long serialVersionUID = 1L;
	
	public ItemFoundRoom(){
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new RegularKey());
		this.setItems(items);
	}
}
