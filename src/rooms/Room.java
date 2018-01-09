package rooms;

import java.io.Serializable;

public class Room implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean visited;
	private int x_coordinate;
	private int y_coordinate;
	
	public Room() {
		
	}
	
	public int getx_coordinate() {
		return this.x_coordinate;
	}
	
	public int gety_coordinate() {
		return this.y_coordinate;
	}
	
	public void setx_coordinate(int x) {
		this.x_coordinate=x;
	}
	public void sety_coordinate(int y) {
		this.y_coordinate=y;
	}
	
	public boolean isVisited(){
		if(this.visited == true)return true;
		else return false;
	}
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public boolean equals(Room room) {
		if(this.getx_coordinate() == room.getx_coordinate() && this.gety_coordinate() == room.gety_coordinate()) {
			return true;
		}else {
			return false;
		}
	}
}
