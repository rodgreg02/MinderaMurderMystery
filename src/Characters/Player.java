package Characters;

import Rooms.Room;
import Weapons.Weapons;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private final String name;
    private final String emoji = "🕵🏽‍♂️️";

    List<Object> detectiveBag = new LinkedList<>();


    public void investigate(Room room) {
        System.out.println("Investigating...");
        System.out.println("You fond a " + room.getClue().toString());
        detectiveBag.add(room.getClue());
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }
}
