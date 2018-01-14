package rooms;

import java.util.concurrent.TimeUnit;

public class LoreRoom extends Room {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoreRoom() {
		super();
	}
	
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("This will be a Lore room.");
		TimeUnit.SECONDS.sleep(3);
		
	}
}
