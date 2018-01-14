package rooms;

import java.util.concurrent.TimeUnit;

public class PuzzleRoom extends Room{
	
	
	private static final long serialVersionUID = 1L;

	public PuzzleRoom() {
		super();
	}
	
	@Override
	public void describe() throws InterruptedException {
		menus.clear();
		System.out.println("This will be a puzzle room.");
		TimeUnit.SECONDS.sleep(3);
		
	}
}
