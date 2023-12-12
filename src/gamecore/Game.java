package gamecore;

import characters.Character;
import characters.Player;
import room.Room;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    static Scanner scan = new Scanner(System.in);
    Menu menu = new Menu();

    public void startGame() throws InterruptedException {
        menu.mainMenu();
    }


    static public int randomNumberGenerator(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    public static void chooseRandomWeaponKill() {
        int valueRandom = (Game.randomNumberGenerator(6));
        Weapon.arrayListWeapons.get(valueRandom).setWasUsedToKill(true);
    }


    static ArrayList<Character> suspects = new ArrayList<>();

    public int numbRandomSuspects(int numbRandom) {
        Random random = new Random();
        return random.nextInt(numbRandom);
    }

    public void chooseRandomSuspect() {
        int randomSuspects = (numbRandomSuspects(6));
        suspects.get(randomSuspects).setWasUsedToKill(true);
        System.out.println(suspects.get(randomSuspects).getName());
    }

    public static ArrayList<Card> selectClues(ArrayList<Card> allClues) {
        ArrayList<Card> selectedClues = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (Card allClue : allClues) {
                if (allClue.getWasUsedToKill() && !(selectedClues.contains(allClue))) {
                    selectedClues.add(allClue);
                }
            }
        }
        while (selectedClues.size() != 8) {
            int randomClue = Game.randomNumberGenerator(12);
            if (!allClues.get(randomClue).getWasUsedToKill() && !(selectedClues.contains(allClues.get(randomClue)))) {
                selectedClues.add(allClues.get(randomClue));
            }

        }
        return selectedClues;
    }

    static void finalEnd(Player player) {
        System.out.println("\tAll the suspects items\t\t| All the weapon's clues\t  | Room's Name");
        System.out.println("\t+—————————————————————————————————————————————————————————————————————+");

        for (int i = 0; i < Room.rooms.size(); i++) {
            String formatString = "\t%-" + (27) + "s | %-" + (27) + "s | %s";

            String suspectsInString;
            String weaponsInString;
            if (i < Character.suspects.size()) {
                suspectsInString = Character.suspects.get(i).getName();
            } else suspectsInString = " ";

            if (i < Weapon.arrayListWeapons.size()) {
                weaponsInString = Weapon.arrayListWeapons.get(i).getName();
            } else weaponsInString = " ";

            System.out.println(String.format(formatString,
                    suspectsInString,
                    weaponsInString,
                    Room.rooms.get(i).getName()));
        }
        System.out.println("\t+—————————————————————————————————————————————————————————————————————+");
        System.out.println("\n");

        System.out.println("Your clues");
        player.checkInventory();
        System.out.println();
        System.out.println("Your guess...");
        System.out.println("Who is the guilty (only name)");
        System.out.print("=> ");
        String nameGuess = scan.next();
        System.out.println("What weapon was used?");
        System.out.print("=> ");
        String weaponGuess = scan.next();
        System.out.println("Where was the crime room?");
        System.out.print("=> ");
        String roomGuess = scan.next();
    }
}
