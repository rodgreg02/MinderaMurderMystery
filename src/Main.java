import characters.Character;
import gamecore.Card;
import gamecore.Game;
import room.Room;
import weapon.Weapon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        Game game = new Game();
        game.startGame();
    }
}