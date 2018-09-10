package ConsoleAdventure;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private double HP;
	private String NAME;
	private int STORY_STATUS;
	private Map MAP;
	private Inventory INV;
	
	Player() {
		HP = 10.0;
		NAME = "";
		STORY_STATUS = 0;
		MAP = new Map();
		INV = new Inventory(0);
	}
	
	Player(double HP, String NAME, double STR, int STORY_STATUS){
		this.HP = HP;
		this.NAME = NAME;
		this.STORY_STATUS = STORY_STATUS;
		MAP = new Map();
		INV = new Inventory(10);
	}
	
	public void setHP(double newHP) {
		this.HP = newHP;
	}

	public double getHP() {
		return this.HP;
	}

	public void setSTORY_STATUS(int status) {
		this.STORY_STATUS = status;
	}

	public int getSTORY_STATUS() {
		return this.STORY_STATUS;
	}

	public void setNAME(String newNAME) {
		this.NAME = newNAME;
	}
	
	public String getNAME() {
		return this.NAME;
	}


	
	public Map getMAP() {
		return this.MAP;
	}

	public void setMap(Map newMap) {
		this.MAP = newMap;
		
	}

	public Inventory getINV() {
		return INV;
	}

	public void setINV(Inventory INV) {
		this.INV = INV;
	}
	
	public void run() {
		this.getMAP().setCurrentRoom(this.getMAP().previousRoom);
	}
	
	public void sneak(char direction) {
		System.out.println("You sneak past...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getMAP().move(direction);
	}

	public void fight() {

	}
	
}
