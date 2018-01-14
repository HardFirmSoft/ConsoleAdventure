package ConsoleAdventure;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private double HP;
	private String NAME;
	private int STORY_STATUS;
	private Map MAP;
	private Inventory INV;
	private Item HOLDING;
	
	Player() {
		HP = 10.0;
		NAME = "";
		STORY_STATUS = 0;
		MAP = new Map();
		INV = new Inventory(0);
		HOLDING=null;
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
	
	public void setNAME(String newNAME) {
		this.NAME = newNAME;
	}
	
	public void setHOLDING(Item item) {
		this.HOLDING = item;
	}
	
	public void setSTORY_STATUS(int status) {
		this.STORY_STATUS = status;
	}
	
	public double getHP() {
		return this.HP;
	}
	
	public String getNAME() {
		return this.NAME;
	}
	
	
	
	public int getSTORY_STATUS() {
		return this.STORY_STATUS;
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
	
	public Item getHOLDING() {
		return this.HOLDING;
	}
}
