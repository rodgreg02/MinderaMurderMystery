import GameCore.Render;
import Rooms.Room;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
    }
}