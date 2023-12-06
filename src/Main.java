import Characters.Characters;
import GameCore.Game;
import GameCore.Render;
import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room.createMap();
        Room.chooseRandomRoomKill();
        for (int i = 0; i < Room.rooms.size(); i++) {
            System.out.println(Room.rooms.get(i).getName() + " " + Room.rooms.get(i).wasUsedToKill);
        }
        Characters.createCharacters();
        Characters.chooseRandomCharacterKill();
        for (int i = 0; i < Characters.suspects.size(); i++) {
            System.out.println(Characters.suspects.get(i).getName() + " " + Characters.suspects.get(i).wasUsedToKill);
        }
    Weapons.CreateWeapons();
        System.out.println("\n\n\n");
        Game.chooseRandomWeaponKill();
        for (int i = 0; i < Weapons.arrayListWeapons.size(); i++) {
            System.out.println(Weapons.arrayListWeapons.get(i).getWeaponName() + " " + Weapons.arrayListWeapons.get(i).wasUsedToKill());
        }
    }
}