package room;
import gameCore.Game;
import gameCore.Card;

import java.util.ArrayList;


public class Room extends Card {
    private Card clue;

    public Room(String name) {
        this.name = name;
    }

    public static ArrayList<Room> rooms = new ArrayList<>();

    public static void createMap() {
        Room hall = new Room("Hall");
        rooms.add(hall);
        Room livingRoom = new Room("Living Room");
        rooms.add(livingRoom);
        Room gameRoom = new Room("Game Room");
        rooms.add(gameRoom);
        Room kitchen = new Room("Kitchen");
        rooms.add(kitchen);
        Room partyRoom = new Room("Party Room");
        rooms.add(partyRoom);
        Room musicRoom = new Room("Music Room");
        rooms.add(musicRoom);
        Room library = new Room("Library");
        rooms.add(library);
        Room office = new Room("Office");
        rooms.add(office);
        Room pool = new Room("Pool");
        rooms.add(pool);
    }

    public String getName() {
        return name;
    }

    public Object getClue() {
        return clue;
    }

    public void setClue(Card clue) {
        this.clue = clue;
    }

    public static Room[] distributeClues(Room[] rooms, Card[] clues){

        for (int i = 0; i < rooms.length; i++) {
            rooms[Game.randomNumberGenerator(7)].setClue(clues[i]);
        }
        return rooms;
    }

    public static void chooseRandomRoomKill() {
        int valueRandom = (Game.randomNumberGenerator(7));
        Room.rooms.get(valueRandom).setWasUsedToKill(true);
    }
}
