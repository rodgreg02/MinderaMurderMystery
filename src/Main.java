<<<<<<< HEAD

public class Main {
    public static void main(String[] args) {

=======
import Characters.Player;
import GameCore.Render;
import Rooms.Room;
import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        Room[] map = Room.createMap();
        Render.drawMap(map);
>>>>>>> 29eb30a8379e0a3efa7776c1301c2640244d8dd6
    }
}