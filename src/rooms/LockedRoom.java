package rooms;

import ConsoleAdventure.TextSequences;
import items.ColorKey;
import items.Item;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LockedRoom extends Room {

	public String colour;
	public boolean isLocked;
	private static final long serialVersionUID = 1L;

	public LockedRoom(String colour, int x, int y) {
		this.isLocked = true;
		this.colour = colour;
		this.setx_coordinate(x);
		this.sety_coordinate(y);
	}
	
	@Override
	public void describe() {
		menus.clear();
		ArrayList<String> message = new ArrayList<>();
		if(this.isLocked()){
			message.add("The door is locked! You notice a " + this.colour + " tinge to the lock...");
			TextSequences.displayMessagesWithDelay(message, 3);
			player.getMAP().getCurrentRoom().setVisited(false);
			player.getMAP().setCurrentRoom(player.getMAP().getPreviousRoom());
		}else {
			//Do something here.
		}
	}

	public boolean isLocked() {
		return this.isLocked;
	}

	public void unlock(){
		menus.clear();
		for(Item item: player.getINV()){
			if(item instanceof ColorKey && ((ColorKey) item).colour.equals(colour)){
				this.isLocked = false;
			}
		}
		if(this.isLocked){
			System.out.println("You don't have the correct key!");
		}
	}

}
