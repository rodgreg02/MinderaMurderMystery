import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
    }
}