package GameCore;

import Characters.Characters;
import Weapons.Weapons;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    Menu menu = new Menu();

    public void startGame() {
        menu.mainMenu();
    }

    static ArrayList<Weapons> weapons = Weapons.CreateWeapons();

    static public int randomNumberGenerator(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    static void chooseRandomWeaponKill() {
        int valueRandom = (Game.randomNumberGenerator(6));
        weapons.get(valueRandom).setWasUsedToKill(true);
        System.out.println(weapons.get(valueRandom).getWeaponName());
    }


    static ArrayList<Characters> suspects = new ArrayList<>();

    public int numbRandomSuspects(int numbRandom){
        Random random = new Random();
        return random.nextInt(numbRandom);
    }

    public void chooseRandomSuspect(){
        int randomSuspects = (numbRandomSuspects(6));
        suspects.get(randomSuspects).setTipUsed(true);
        System.out.println(suspects.get(randomSuspects).getName());
    }


}
