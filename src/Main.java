import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
        //Story.startStory();
        //Story.goodEnding();
        //Story.badEnding();


        Weapons Weapons = new Weapons();
        //Weapons.showWeaponArray();
    }
}