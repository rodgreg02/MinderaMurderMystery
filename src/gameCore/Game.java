package gameCore;

import characters.Character;
import weapon.Weapon;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    Menu menu = new Menu();

    public void startGame() {
        menu.mainMenu();
    }


    static public int randomNumberGenerator(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    public static void chooseRandomWeaponKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Weapon.arrayListWeapons.get(valueRandom).setWasUsedToKill(true);
    }


    static ArrayList<Character> suspects = new ArrayList<>();

    public int numbRandomSuspects(int numbRandom){
        Random random = new Random();
        return random.nextInt(numbRandom);
    }

    public void chooseRandomSuspect(){
        int randomSuspects = (numbRandomSuspects(6));
        suspects.get(randomSuspects).setWasUsedToKill(true);
        System.out.println(suspects.get(randomSuspects).getName());
    }


}
