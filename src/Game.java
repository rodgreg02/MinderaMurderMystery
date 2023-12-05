import Weapons.Weapons;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    static ArrayList<Weapons> weapons = Weapons.CreateWeapons();

    static int StandardRandom(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    static void chooseRandomWeaponKill() {
        int valueRandom = (Game.StandardRandom(6));
        weapons.get(valueRandom).setWasUsedToKill(true);
        System.out.println(weapons.get(valueRandom).getWeaponName());
    }


}
