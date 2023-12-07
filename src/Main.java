import characters.Character;
import gameCore.Game;
import room.Room;
import weapon.Weapon;
import gameCore.Render;

public class Main {
    public static void main(String[] args) {
        Room.createMap();
        Room.chooseRandomRoomKill();
      Render.drawRoom(Room.rooms.get(1));
        for (int i = 0; i < Room.rooms.size(); i++) {
            System.out.println(Room.rooms.get(i).getName() + " " + Room.rooms.get(i).wasUsedToKill);
        }
        Character.createCharacters();
        Character.chooseRandomCharacterKill();
        for (int i = 0; i < Character.suspects.size(); i++) {
            System.out.println(Character.suspects.get(i).getName() + " " + Character.suspects.get(i).wasUsedToKill);
        }
    Weapon.createWeapons();
        System.out.println("\n\n\n");
        Game.chooseRandomWeaponKill();
        for (int i = 0; i < Weapon.arrayListWeapons.size(); i++) {
            System.out.println(Weapon.arrayListWeapons.get(i).getWeaponName() + " " + Weapon.arrayListWeapons.get(i).wasUsedToKill());
        }
    }
}