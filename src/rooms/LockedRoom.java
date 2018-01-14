package rooms;

import java.util.concurrent.TimeUnit;

public class LockedRoom extends Room {

	private String color;
	private static final long serialVersionUID = 1L;
	
	public LockedRoom(String color, int x, int y) {
		this.isLocked = true;
		this.color = color;
		this.setx_coordinate(x);
		this.sety_coordinate(y);
	}
	
	@Override
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("The door is locked! You notice a " + this.color + " tinge to the lock...");
		TimeUnit.SECONDS.sleep(3);
		player.getMAP().getCurrentRoom().setVisited(false);
		player.getMAP().setCurrentRoom(player.getMAP().getPreviousRoom());
		
	}
}
