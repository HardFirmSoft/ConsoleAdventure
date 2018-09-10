package rooms;

import java.util.ArrayList;

import items.BucketOfTar;
import items.Item;

public class StartingRoom extends ItemFoundRoom {


	private static final long serialVersionUID = 1L;
	
	public StartingRoom(int x, int y){
		super();
		this.setx_coordinate(x);
		this.sety_coordinate(y);
		this.items.add(new BucketOfTar());
	}

}
