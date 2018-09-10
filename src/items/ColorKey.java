package items;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ConsoleAdventure.TextSequences;
import rooms.LockedRoom;
import rooms.Room;
import ConsoleAdventure.Main;


public class ColorKey extends Item {

	private static final long serialVersionUID = 1L;
	public String colour;

	public ColorKey(String colour) {
		this.setDescription("Can be used to open locked doors! It has a " + colour + " glow to it.");
		this.setName(colour + " " + "key");
		this.colour = colour;
	}

	@Override
    public void use(){
	    Room currentRoom = Main.player.getMAP().getCurrentRoom();
	    int currentYCoordinate = currentRoom.gety_coordinate();
	    int currentXCoordinate = currentRoom.getx_coordinate();

        ArrayList<Room> adjacentRooms = new ArrayList<>();
        //Add west room
        if(currentXCoordinate > 0) {
            adjacentRooms.add(Main.player.getMAP().getRoom(currentXCoordinate - 1, currentYCoordinate));
        }
        //Add east room
        if(currentXCoordinate < 6) {
            adjacentRooms.add(Main.player.getMAP().getRoom(currentXCoordinate + 1, currentYCoordinate));
        }
        //Add north room
        if(currentYCoordinate > 0) {
            adjacentRooms.add(Main.player.getMAP().getRoom(currentXCoordinate, currentYCoordinate - 1));
        }
        //Add south room
        if(currentYCoordinate < 6) {
            adjacentRooms.add(Main.player.getMAP().getRoom(currentXCoordinate, currentYCoordinate + 1));
        }

        boolean roomUnlocked = false;
        for(Room room: adjacentRooms){
            if(room instanceof LockedRoom){
                LockedRoom lockedRoom = (LockedRoom) room;
                if(lockedRoom.colour.equals(this.colour)) {
                    ArrayList<String> message = new ArrayList<>();
                    if (lockedRoom.isLocked()) {
                        ((LockedRoom) room).unlock();
                        message.add("Unlocked the door!");
                        ((LockedRoom) room).unlock();
                        roomUnlocked = true;
                    } else {
                        message.add("It's already unlocked!");
                    }
                    TextSequences.displayMessagesWithDelay(message, 2);
                }
            }
        }
        if(!roomUnlocked){
            ArrayList<String>  message = new ArrayList<>();
            message.add("There's no locked rooms nearby you can use this with!");
            TextSequences.displayMessagesWithDelay(message, 2);
        }
    }
}
