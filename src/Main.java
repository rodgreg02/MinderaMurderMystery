import characters.Character;
import gameCore.Card;
import gameCore.Game;
import gameCore.Render;
import room.Room;
import weapon.Weapon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Card> allClues = new ArrayList<>();
        ArrayList<Card> selectedClues = new ArrayList<>();

        Room.createMap();
        Room.chooseRandomRoomKill();

        Character.createCharacters();
        Character.chooseRandomCharacterKill();
        allClues.addAll(Character.suspects);

        Weapon.createWeapons();
        Game.chooseRandomWeaponKill();
        allClues.addAll(Weapon.arrayListWeapons);

        Room.distributeClues(allClues);

        /*for (Room room:
             Room.rooms) {
            System.out.println(room.getClueObject());
        }*/
        System.out.println(Room.rooms.get(3).getClueRoom());

    }
}