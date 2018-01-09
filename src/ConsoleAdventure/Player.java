package ConsoleAdventure;

import java.io.Serializable;

class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private double HP;
	private String NAME;
	private double STR;
	private int STORY_STATUS;
	private Map MAP;
	private Inventory INV;
	
	Player() {
		HP = 10.0;
		NAME = "";
		STR = 5.0;
		STORY_STATUS = 0;
		MAP = new Map();
		INV = new Inventory(10);
	}
	
	Player(double HP, String NAME, double STR, int STORY_STATUS){
		this.HP = HP;
		this.NAME = NAME;
		this.STR = STR;
		this.STORY_STATUS = STORY_STATUS;
		MAP = new Map();
		INV = new Inventory(10);
		
	}
	
	void setHP(double newHP) {
		this.HP = newHP;
	}
	
	void setNAME(String newNAME) {
		this.NAME = newNAME;
	}
	
	void setSTR(double str) {
		this.STR = str;
	}
	
	void setSTORY_STATUS(int status) {
		this.STORY_STATUS = status;
	}
	
	double getHP() {
		return this.HP;
	}
	
	String getNAME() {
		return this.NAME;
	}
	
	double getSTR() {
		return this.STR;
	}
	
	int getSTORY_STATUS() {
		return this.STORY_STATUS;
	}
	
	Map getMAP() {
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
	
	
}
