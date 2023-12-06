package Rooms;
import GameCore.Game;


public class Room {
    private final String name;
    private Object clue;

    public Room(String name) {
        this.name = name;
    }

    public static Room[] createMap() {
        Room[] rooms = new Room[9];
        Room hall = new Room("Hall");
        rooms[0] = hall;
        Room livingRoom = new Room("Living Room");
        rooms[1] = livingRoom;
        Room gameRoom = new Room("Game Room");
        rooms[2] = gameRoom;
        Room kitchen = new Room("Kitchen");
        rooms[3] = kitchen;
        Room partyRoom = new Room("Party Room");
        rooms[4] = partyRoom;
        Room musicRoom = new Room("Music Room");
        rooms[5] = musicRoom;
        Room library = new Room("Library");
        rooms[6] = library;
        Room office = new Room("Office");
        rooms[7] = office;
        Room pool = new Room("Pool");
        rooms[8] = pool;
        return rooms;
    }

    public String getName() {
        return name;
    }

    public Object getClue() {
        return clue;
    }

    public void setClue(Object clue) {
        this.clue = clue;
    }

    public static Room getRandomRoom(Room[] rooms){
        return rooms[Game.randomNumberGenerator(7)];
    }
    public static Room[] distributeClues(Room[] rooms,Object[] clues){
        for (int i = 0; i < rooms.length; i++) {
            rooms[Game.randomNumberGenerator(7)].setClue(clues[i]);
        }
        return rooms;
    }
}
