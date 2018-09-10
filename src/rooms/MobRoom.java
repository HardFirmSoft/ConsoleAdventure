package rooms;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import mobs.HeadlessSkeleton;

public class MobRoom extends Room implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public MobRoom(int seed) {
		switch(seed) {
			case 0: 
				break;
			default: this.getMobs().add(new HeadlessSkeleton());
		}
	}
	
	@Override
	public void describe() throws InterruptedException {
		menus.clear();
		this.fightSequence();
		TimeUnit.SECONDS.sleep(3);
		
	}
	public void fightSequence()  {
		
		try{
			this.getMobs().get(0).describe();
			TimeUnit.SECONDS.sleep(2);
			this.getMobs().get(0).encounter();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
