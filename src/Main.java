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
        ArrayList<Card> selectedClues = new ArrayList<>();

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
            for (Card allClue : allClues) {
                if (allClue.wasUsedToKill && !(selectedClues.contains(allClue))) {
                    selectedClues.add(allClue);
                }
            }
        }
        while (selectedClues.size() != 8) {
            int randomClue = Game.randomNumberGenerator(21);
            if (!allClues.get(randomClue).getWasUsedToKill() && !(selectedClues.contains(allClues.get(randomClue)))) {
                selectedClues.add(allClues.get(randomClue));
            }

        }
        for (Card selectedClue : selectedClues) {
            System.out.println(selectedClue.getName() + " " + selectedClue.getClue()+ " " + selectedClue.getWasUsedToKill());
        }
    }
}