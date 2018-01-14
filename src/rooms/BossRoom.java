package rooms;

import java.util.concurrent.TimeUnit;

public class BossRoom extends Room{

	
	private static final long serialVersionUID = 1L;
	public BossRoom() {
		this.isLocked = true;
		
	}
	
	@Override
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("The door is locked! A chill runs down your spine... \n there's something sinister about this door...");
		TimeUnit.SECONDS.sleep(3);
		player.getMAP().getCurrentRoom().setVisited(false);
		player.getMAP().setCurrentRoom(player.getMAP().getPreviousRoom());
		
	}
}
