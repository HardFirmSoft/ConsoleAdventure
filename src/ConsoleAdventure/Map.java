package ConsoleAdventure;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import rooms.Room;

class Map extends Main implements Serializable{
	
	
	/*
	 * Map is an 11 by 11 grid of rooms
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Room[][] rooms = new Room[11][11];
	Room currentRoom;
	
	//instantiating the rooms
	
	public Map(){
		for(int i=0; i<rooms.length;i++) {
			for(int j=0;j<rooms.length;j++) {
				rooms[i][j] = new Room();
				rooms[i][j].setx_coordinate(j);
				rooms[i][j].sety_coordinate(i);
			}
		}
		
		currentRoom = rooms[10][5];
		currentRoom.setVisited(true);
	}
	
	Room getCurrentRoom() {
		return currentRoom;
	}
	
	void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	
	/*
	 * Displays map with all current data in ASCII text.
	 */
	void print() {
		
		for (int i=0;i<this.rooms.length;i++){
		      System.out.print("+---");
		    }
		    System.out.println("+");
		    //printing body of board
		    for(int j=0; j<this.rooms.length;j++){
		      for(int k=0;k<this.rooms.length;k++){
		        
		        if(this.rooms[j][k].equals(this.getCurrentRoom())) {
		        	System.out.print("| x ");
		        }else if(this.rooms[j][k].isVisited()) {
		        	System.out.print("| * ");
		        }else {
		        	System.out.print("|   ");
		        }
		       
		      } 
		      System.out.println('|');
		      //printing bottom of board
		      for (int r=0;r<this.rooms.length;r++){
		        System.out.print("+---");
		      }
		      System.out.println("+");
		    }
		
		
	}
	
	void move(char direction) throws InterruptedException{
		int newX;
		int newY;
		switch (direction) {
        	case 'w': 
        		if(this.getCurrentRoom().gety_coordinate()==0) {
        			System.out.println("There is no door in that direction!");
        			TimeUnit.SECONDS.sleep(1);
        		}else {
        			newY = this.getCurrentRoom().gety_coordinate()-1;
        			this.setCurrentRoom(this.rooms[newY][this.currentRoom.getx_coordinate()]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().sety_coordinate(newY);
        			System.out.println("You step through the door to the north...");
        			TimeUnit.SECONDS.sleep(1);
        		}
        	
        	
        		break;
        	case 'a':  
        		if(currentRoom.getx_coordinate()==0) {
        			System.out.println("There is no door in that direction!");
        			TimeUnit.SECONDS.sleep(1);
        		}else {
        			newX = this.getCurrentRoom().getx_coordinate()-1;
        			this.setCurrentRoom(rooms[this.currentRoom.gety_coordinate()][newX]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().setx_coordinate(newX);
        			System.out.println("You step through the door to the west...");
        			TimeUnit.SECONDS.sleep(1);
        		}
        
        		break;
        	case 's': 
        		if(this.getCurrentRoom().gety_coordinate()==10) {
        			System.out.println("There is no door in that direction!");
        			TimeUnit.SECONDS.sleep(2);
        		}else {
        			newY = this.getCurrentRoom().gety_coordinate()+1;
        			this.setCurrentRoom(this.rooms[newY][this.getCurrentRoom().getx_coordinate()]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().sety_coordinate(newY);
        			System.out.println("You step through the door to the south...");
        			TimeUnit.SECONDS.sleep(1);
        		}
        		
        		break;
        	case 'd': 
        		if(this.getCurrentRoom().getx_coordinate()==10) {
        			System.out.println("There is no door in that direction!");
        			TimeUnit.SECONDS.sleep(2);
        		}else {
        			newX = this.getCurrentRoom().getx_coordinate()+1;
        			this.setCurrentRoom(rooms[this.getCurrentRoom().gety_coordinate()][newX]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().setx_coordinate(newX);
        			System.out.println("You step through the door to the east...");
        			TimeUnit.SECONDS.sleep(1);
        		}
        		break;
        	default: return;
		}
    


	}
}
