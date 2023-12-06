import Characters.Player;
import GameCore.Render;
import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
        Weapons machado = new Weapons("machado","lol","ocrlh",false);
        map[0].setClue(machado);
        Player player = new Player("asdad");
        player.investigate(map[0]);

    }
}