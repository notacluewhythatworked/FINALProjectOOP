package models;

import lib.ConsoleIO;

public class Map {
    private Enemy grunt = new Enemy();

    private String map[][] = new String[3][3];

    public void startingRoom(){
        System.out.println("\nWelcome to your doom.");
        System.out.println("Which way would you like to move?\n");
        ConsoleIO.promptForMenuSelection(new String[]{"Left", "Right", "Forward", "Backward"}, false);
    }

    public void commonRoom(){
        System.out.println("You enter a common room");


    }

    public void healingFountain(){
        int timesUsed = 3;
        if (timesUsed != 0){
            //What happens in the healing fountain
            //the player is healed to full - phil
            timesUsed--;
        } else {
            System.out.println("Unfortunately, you've used the healing fountain too many times. Good luck out there.");
        }
        //Reduce the amount of times the room can be entered based on difficulty.

    }

    public void bossRoom(){
        System.out.println("This is the boss room. Are you sure you're ready for this?");
        ConsoleIO.promptForMenuSelection(new String[]{"Yes", "No"}, false);

    }

    public String playerLocation(){
        return "You are currently in the " + " room.";
    }

    public void mapView() {
        //This should be almost identical to the connect four board, but populated with locations.
        for(int i = 0 ; i < 6; i++){
            for (int j = 0; j < 7; j++) {
                map[i][j] = " ";
            }
        }
    }
}
