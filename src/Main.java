import characters.Character;
import gameCore.Card;
import gameCore.Game;
import room.Room;
import weapon.Weapon;
import gameCore.Render;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Card> allClues = new ArrayList<>();
        Card[] selectedClues = new Card[8];

        Room.createMap();
        Room.chooseRandomRoomKill();
        allClues.addAll(Room.rooms);

        Character.createCharacters();
        Character.chooseRandomCharacterKill();
        allClues.addAll(Character.suspects);

        Weapon.createWeapons();
        Game.chooseRandomWeaponKill();
        allClues.addAll(Weapon.arrayListWeapons);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < allClues.size(); j++) {
                if (allClues.get(j).wasUsedToKill) {
                    selectedClues[i] = allClues.get(j);
                }
            }
        }


    }
}