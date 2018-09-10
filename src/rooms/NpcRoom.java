package rooms;

import java.util.concurrent.TimeUnit;

public class NpcRoom extends Room {

	private static final long serialVersionUID = 1L;

	public NpcRoom() {
		super();
	}
	
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("This will be a puzzle room.");
		TimeUnit.SECONDS.sleep(3);
	}
}
