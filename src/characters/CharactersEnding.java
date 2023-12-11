package characters;

import gamecore.Game;
import room.Room;
import weapon.Weapon;

import java.util.ArrayList;

public class CharactersEnding {
    public static void charactersEnding() {
        System.out.print("It was during the night that ");
        int counter = 0;
        boolean seeIfCounterMax = false;
        for (int i = 0; i < 6; i++) {
            if (Character.suspects.get(i).getWasUsedToKill()) {
                System.out.print(Character.suspects.get(i).getName() + " and used a ");
            }
            if (Weapon.arrayListWeapons.get(i).getWasUsedToKill()) {
                System.out.print(Weapon.arrayListWeapons.get(i).getName() + " to kill Flávio in that room");
            }

        }
        System.out.println();
    }
}
