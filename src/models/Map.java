package models;

import enums.Direction;
import lib.ConsoleIO;
import movement.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private Enemy grunt = new Enemy();
    private ArrayList<Room> map;
    public Room currentRoom;
//    private Player playerStats = new Player();

    public void startup(){
        this.map = new ArrayList<Room>();
        List<Integer> commands = new ArrayList<>(Arrays.asList(1,2,3,4));
        //                      Room name               description                  N           S           E           W
        //Direction.NOEXIT means that you cannot exit the room going that particular way
        /* index 0 */map.add(new Room("Starting Room", "Your starting point", Direction.NOEXIT, Direction.NOEXIT, 2, 1));
        /* index 1 */map.add(new Room("ROOM 1", "", Direction.NOEXIT, 5, 0, Direction.NOEXIT));
        /* index 2 */map.add(new Room("ROOM 2", "", Direction.NOEXIT, Direction.NOEXIT, 3, 0));
        /* index 3 */map.add(new Room("ROOM 3", "", Direction.NOEXIT, 4, Direction.NOEXIT, 2));
        /* index 4 */map.add(new Room("Healing Fountain", "Restore your health and take a break", 3, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        /* index 5 */map.add(new Room("ROOM 5", "", 1, 6, Direction.NOEXIT, Direction.NOEXIT));
        /* index 6 */map.add(new Room("Miniboss Room", "", 5, Direction.NOEXIT, 7, 8));
        /* index 7 */map.add(new Room("Boss Room", "The final boss. Are you ready for this?", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 6));
        /* index 8 */map.add(new Room("ROOM 8", "", Direction.NOEXIT, Direction.NOEXIT, 6, Direction.NOEXIT));
        currentRoom= new Room(map.get(0).getName(), "you!", map.get(0).getN(),map.get(0).getS(),map.get(0).getE(),map.get(0).getW());
    }

    //returns the room user is going to
    public int moveTo(Room room, Direction direction){
        //return: a number representing the room the player moved to or NOEXIT
        int exit;

        switch (direction){
            case NORTH:
                exit = room.getN();
                break;
            case SOUTH:
                exit = room.getS();
                break;
            case EAST:
                exit = room.getE();
                break;
            case WEST:
                exit = room.getW();

                break;
            default:
                exit = Direction.NOEXIT; //returns an error message and keeps the player in the same room
                break;
        }
        return exit;
    }

    public boolean goDirection(Direction direction) {
         return updateOutput(moveTo(currentRoom, direction));
    }

    //if true there is a wall
    public boolean updateOutput(int roomNumber){
        if (roomNumber == Direction.NOEXIT){
            System.out.println("That is not an exit. Please try another direction.");
            return true;
        } else {
            currentRoom = map.get(roomNumber);
            //System.out.println("You are currently in the " + currentRoom.getName() + ". ");
            return false;
        }
    }
}
