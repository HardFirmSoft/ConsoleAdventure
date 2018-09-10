package rooms;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import items.Item;
import items.ColorKey;

public class ItemFoundRoom extends Room{

	
	private static final long serialVersionUID = 1L;
	ArrayList<Item> items = new ArrayList<>();

	public ItemFoundRoom(){}
	public ItemFoundRoom(ArrayList<Item> items){
		this.items = items;
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
