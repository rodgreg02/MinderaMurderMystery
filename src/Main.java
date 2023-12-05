<<<<<<< HEAD
import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
=======

import Characters.Characters;

import java.util.ArrayList;

public class Main {

    static Player player = new Player("asdad");
    public static void main(String[] args) {
    Game game = new Game();
    game.startGame();



>>>>>>> 6f21fbd036129a43ee2b441acb729b5dc411db5a
    }
}