package Characters;

import Weapons.Weapons;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private final String name;
    private final String emoji = "🕵🏽‍♂️️";

    List<String> detectiveBag = new LinkedList<>();



    private void investigate(){

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
