package characters;

import gameCore.Card;
import weapon.Weapon;
import room.Room;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private final String name;

    List<Object> detectiveBag = new LinkedList<>();


    public void investigate(Room room) {
        System.out.println("Investigating...");
        System.out.println("You fond a " + room.getClue().toString());
        detectiveBag.add(room.getClue());
    }


    public void examine(Card card){

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        String emoji = "🕵🏽‍♂️️";
        return emoji;
    }
}
