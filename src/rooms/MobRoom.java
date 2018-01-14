package rooms;

import java.util.concurrent.TimeUnit;

public class MobRoom extends Room {
	
	private static final long serialVersionUID = 1L;

	public MobRoom() {
		super();
	}
	
	@Override
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("This will be a mob room.");
		TimeUnit.SECONDS.sleep(3);
		
	}
	
}
