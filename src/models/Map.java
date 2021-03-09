package models;

import enums.Direction;
import lib.ConsoleIO;
import movement.PlayerMovement;
import movement.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private Enemy grunt = new Enemy();
    private String map2[][] = new String[3][3];
    private ArrayList<Room> map;
    private PlayerMovement playerMovement;
    private Player playerStats = new Player();

    public void startup(){
        this.map = new ArrayList<Room>();
        List<String> commands = new ArrayList<>(Arrays.asList("1", "2", "3", "n", "s", "e", "w"));
        //                      Room name               description                  N           S           E           W
        //Direction.NOEXIT means that you cannot exit the room going that particular way
        /* index 0 */map.add(new Room("Home Room", "Your starting point", Direction.NOEXIT, Direction.NOEXIT, 2, 1));
        /* index 1 */map.add(new Room("", "", Direction.NOEXIT, 5, 0, Direction.NOEXIT));
        /* index 2 */map.add(new Room("", "", Direction.NOEXIT, Direction.NOEXIT, 3, 0));
        /* index 3 */map.add(new Room("", "", Direction.NOEXIT, 4, Direction.NOEXIT, 2));
        /* index 4 */map.add(new Room("Healing Fountain", "Restore your health and take a break", 3, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        /* index 5 */map.add(new Room("", "", 1, 6, Direction.NOEXIT, Direction.NOEXIT));
        /* index 6 */map.add(new Room("Miniboss Room", "", 5, Direction.NOEXIT, 7, 8));
        /* index 7 */map.add(new Room("Boss Room", "The final boss. Are you ready for this?", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 6));
        /* index 8 */map.add(new Room("", "", Direction.NOEXIT, Direction.NOEXIT, 6, Direction.NOEXIT));
        playerMovement = new PlayerMovement("player", "you!", map.get(0));
    }

    public void startingRoom(){
        startup();
        System.out.println("\nWelcome to your doom.");
        System.out.println("Which way would you like to move?\n");
        ConsoleIO.promptForMenuSelection(new String[]{"Left", "Right", "Forward", "Backward"}, false);
    }

    public void commonRoom(){
        System.out.println("You enter a common room");


    }

    public void healingFountain(int difficulty){
        int timesUsed = difficulty;
        if (timesUsed != 0){
            playerStats.setHealthPoints(100);
            timesUsed--;
            System.out.println("Your health has been restored. You are at " + playerStats.getHealthPoints() + " health.");
        } else {
            System.out.println("Unfortunately, you've used the healing fountain too many times. Your health is currently at " + playerStats.getHealthPoints() + ". Good luck out there.");
        }
    }

    public void bossRoom(){
        System.out.println("This is the boss room. Are you sure you're ready for this?");
        ConsoleIO.promptForMenuSelection(new String[]{"Yes", "No"}, false);


    }

    public String playerLocation(){
        return "You are currently in the " + playerMovement.getRoom() + " room.";
    }

    void movePlayerTo(PlayerMovement playerMovement, Room room){
        playerMovement.setRoom(room);
    }

    int moveTo (PlayerMovement playerMovement, Direction direction){
        //return: a number representing the room the player moved to or NOEXIT
        Room r = playerMovement.getRoom();
        int exit;

        switch (direction){
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT;
                break;
        }
        if (exit != Direction.NOEXIT){
            movePlayerTo(playerMovement, map.get(exit));
        }
        return exit;
    }

    void updateOutput(int roomNumber){
        String s;
        if (roomNumber == Direction.NOEXIT){
            s = "That is not an exit. Please try another direction.";
        } else {
            Room r = playerMovement.getRoom();
            s = "You are currently in the " + r.getName() + ". ";
        }
        System.out.println(s);
    }

//    public void mapView() {
//        //This should be almost identical to the connect four board, but populated with locations.
//        for(int i = 0 ; i < 6; i++){
//            for (int j = 0; j < 7; j++) {
//                map[i][j] = " ";
//            }
//        }
//    }
}
