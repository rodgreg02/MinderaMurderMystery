package GameCore;

import Weapons.Weapons;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
static Scanner scan = new Scanner(System.in);
    Menu menu = new Menu();

    public void startGame(){
        menu.mainMenu();
    }


    static public int randomNumberGenerator(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    public static void chooseRandomWeaponKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Weapons.arrayListWeapons.get(valueRandom).setWasUsedToKill(true);
    }


}
