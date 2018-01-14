package ConsoleAdventure;
import java.io.Serializable;

import rooms.BossRoom;
import rooms.ItemFoundRoom;
import rooms.ItemNeededRoom;
import rooms.LockedRoom;
import rooms.LoreRoom;
import rooms.MobRoom;
import rooms.NpcRoom;
import rooms.PuzzleRoom;
import rooms.Room;
import rooms.StartingRoom;

public class Map extends Main implements Serializable{
	
	
	/*
	 * Map is an 11 by 11 grid of rooms
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Room[][] rooms = new Room[7][7];
	Room currentRoom;
	Room previousRoom;
	Room tempRoom;
	//instantiating the rooms
	
	public Map(){
		
		
		currentRoom = new StartingRoom(3,6);
		currentRoom.setVisited(true);
		rooms[6][3] = currentRoom;
		rooms[0][0] = new LockedRoom("blue",0,0);
		rooms[0][6] = new LockedRoom("red",6,0);
		rooms[6][0] = new LockedRoom("golden",0,6);
		rooms[6][6] = new LockedRoom("green",6,6);
		rooms[3][3] = new LockedRoom("orange",3,3);
		
		BossRoom bossroom = new BossRoom();
		this.putRandomLocation(bossroom);
		
		for(int i=0; i<14;i++) {
			MobRoom mobRoom = new MobRoom();
			this.putRandomLocation(mobRoom);
		}
		for(int i=0; i<5; i++) {
			NpcRoom npcRoom = new NpcRoom();
			this.putRandomLocation(npcRoom);
			ItemFoundRoom foundRoom = new ItemFoundRoom();
			this.putRandomLocation(foundRoom);
		}
		for(int i=0; i<10; i++) {
			ItemNeededRoom neededRoom = new ItemNeededRoom();
			this.putRandomLocation(neededRoom);
		}
		
		for(int i=0; i<4; i++) {
			LoreRoom lore = new LoreRoom();
			this.putRandomLocation(lore);
			PuzzleRoom puzzle = new PuzzleRoom();
			this.putRandomLocation(puzzle);
		}
		
		
		
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	public Room getPreviousRoom() {
		return this.previousRoom;
	}
	
	/*
	 * Displays map with all current data in ASCII text.
	 */
	public void print() {
		
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
	
	public void putRandomLocation(Room room) {
		
		while(1<2) {
			int randomX= (int) (Math.random()*7);
			int randomY = (int) (Math.random()*7);
			if(this.rooms[randomY][randomX]==null ) {
				rooms[randomY][randomX] = room;
				room.setx_coordinate(randomX);
				room.sety_coordinate(randomY);
				break;
			}
		}
	}
	public void move(char direction) throws InterruptedException{
		int newX;
		int newY;
		switch (direction) {
        	case 'w': 
        		if(this.getCurrentRoom().gety_coordinate()==0) {
        			System.out.println("There is no door in that direction!");
        			//TimeUnit.SECONDS.sleep(1);
        		}else {
        			this.previousRoom = this.getCurrentRoom();
        			newY = this.getCurrentRoom().gety_coordinate()-1;
        			this.setCurrentRoom(this.rooms[newY][this.currentRoom.getx_coordinate()]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().sety_coordinate(newY);
        			System.out.println("You step through the door to the north...");
        			//TimeUnit.SECONDS.sleep(1);
        			this.getCurrentRoom().describe();
        		}
        	
        	
        		break;
        	case 'a':  
        		
        		if(currentRoom.getx_coordinate()==0) {
        			System.out.println("There is no door in that direction!");
        			//TimeUnit.SECONDS.sleep(1);
        		}else {
        			this.previousRoom = this.getCurrentRoom();
        			newX = this.getCurrentRoom().getx_coordinate()-1;
        			this.setCurrentRoom(rooms[this.currentRoom.gety_coordinate()][newX]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().setx_coordinate(newX);
        			System.out.println("You step through the door to the west...");
        			//TimeUnit.SECONDS.sleep(1);
        			this.getCurrentRoom().describe();
        		}
        
        		break;
        	case 's': 
        		if(this.getCurrentRoom().gety_coordinate()==6) {
        			System.out.println("There is no door in that direction!");
        			//TimeUnit.SECONDS.sleep(2);
        		}else {
        			this.previousRoom = this.getCurrentRoom();
        			newY = this.getCurrentRoom().gety_coordinate()+1;
        			this.setCurrentRoom(this.rooms[newY][this.getCurrentRoom().getx_coordinate()]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().sety_coordinate(newY);
        			System.out.println("You step through the door to the south...");
        			//TimeUnit.SECONDS.sleep(1);
        			this.getCurrentRoom().describe();
        		}
        		
        		break;
        	case 'd': 
        		if(this.getCurrentRoom().getx_coordinate()==6) {
        			System.out.println("There is no door in that direction!");
        			//TimeUnit.SECONDS.sleep(2);
        		}else {
        			this.previousRoom = this.getCurrentRoom();
        			newX = this.getCurrentRoom().getx_coordinate()+1;
        			this.setCurrentRoom(rooms[this.getCurrentRoom().gety_coordinate()][newX]);
        			this.getCurrentRoom().setVisited(true);
        			this.getCurrentRoom().setx_coordinate(newX);
        			System.out.println("You step through the door to the east...");
        			//TimeUnit.SECONDS.sleep(1);
        			this.getCurrentRoom().describe();
        		}
        		break;
        	default: return;
		}
    


	}
}
