package rooms;

import java.util.concurrent.TimeUnit;

public class ItemNeededRoom extends Room {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNeededRoom() {
		super();
	}
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("This will be a puzzle room.");
		TimeUnit.SECONDS.sleep(3);
		
	}
}
