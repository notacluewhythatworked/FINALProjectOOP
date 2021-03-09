package movement;

public class PlayerMovement extends Objects {

    private Room room;

    public PlayerMovement(String name, String description, Room room){
        super(name, description);
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
