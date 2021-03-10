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
    private ArrayList<Room> map;
    private PlayerMovement playerMovement;
    private Player playerStats = new Player();

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
        playerMovement = new PlayerMovement("player", "you!", map.get(0));
    }

    public void startingRoom(){
        startup();
        System.out.println("\nWelcome to your doom.");
        System.out.println("Which way would you like to move?\n");
         int shmoove=ConsoleIO.promptForMenuSelection(new String[]{"North", "South", "East", "West"}, false);
        switch (shmoove){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }

    public void commonRoom(){
//        moveTo(I dont know what info to input in here);
        System.out.println("You enter a common room");
        System.out.println("lets move out\n");

    }

    public void healingFountain(int difficulty){
        //moveTo(put info in here);
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


    public int moveTo(PlayerMovement playerMovement, Direction direction){
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
                exit = Direction.NOEXIT; //returns an error message and keeps the player in the same room
                break;
        }
        if (exit != Direction.NOEXIT){
            movePlayerTo(playerMovement, map.get(exit));
        }
        return exit;
    }

    public String processCommand(){
        return "";
    }

    public void movePlayerTo(PlayerMovement playerMovement, Room room){
        playerMovement.setRoom(room);
    }

    public int movePlayerTo(Direction direction){
        return moveTo(playerMovement, direction);
    }

    private void goN(){
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    private void goS(){
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    private void goE(){
        updateOutput(movePlayerTo(Direction.EAST));
    }

    private void goW(){
        updateOutput(movePlayerTo(Direction.WEST));
    }

    public void updateOutput(int roomNumber){
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
