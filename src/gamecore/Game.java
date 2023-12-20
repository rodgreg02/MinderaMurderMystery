package gamecore;

import characters.Character;
import characters.Player;
import com.sun.tools.javac.Main;
import room.Room;
import weapon.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Game {
    static public boolean solveGame = false;
    static public boolean gameOver = false;
    static Scanner scan = new Scanner(System.in);

    Menu menu = new Menu();
    SoundTrackSystem soundTrackSystem = new SoundTrackSystem();

    public void startGame() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        ArrayList<Card> allClues = new ArrayList<>();
        ArrayList<Card> selectedClues = new ArrayList<>();
        Room.createMap();
        Room.chooseRandomRoomKill();
        Character.createCharacters();
        Character.chooseRandomCharacterKill();
        allClues.addAll(Character.suspects);
        Weapon.createWeapons();
        Game.chooseRandomWeaponKill();
        allClues.addAll(Weapon.arrayListWeapons);
        Room.distributeClues(allClues);
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
        String nameGuess = scan.next().toLowerCase().trim();
        System.out.println("What weapon was used?");
        System.out.print("=> ");
        String weaponGuess = scan.next().toLowerCase().trim();
        System.out.println("Where was the crime room?");
        System.out.print("=> ");
        String roomGuess = scan.next().toLowerCase().trim();

        charactersEnding(nameGuess, weaponGuess, roomGuess);
    }

    public static void charactersEnding(String nameGuess, String weaponGuess, String roomGuess) {
        long counter = Character.suspects.stream()
                .filter(e -> e.getName().toLowerCase().contains(nameGuess) && e.getWasUsedToKill())
                .count()
                +
                Weapon.arrayListWeapons.stream()
                        .filter(e -> e.getName().toLowerCase().contains(weaponGuess) && e.getWasUsedToKill())
                        .count()
                +
                Room.rooms.stream()
                        .filter(e -> e.getName().toLowerCase().contains(roomGuess) && e.getWasUsedToKill())
                        .count();

        //
        System.out.println();
        if (counter == 3) {
            solveGame = true;
            gameOver = true;
            System.out.println("Your awnser is right");
            //-----------------
            String onlyName = Character.suspects.stream()
                    .filter(Character::getWasUsedToKill) //.filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName().substring(0, e.getName().indexOf("'s")))
                    .collect(Collectors.joining(" "));

            String onlyWeapon = Weapon.arrayListWeapons.stream()
                    .filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName())
                    .collect(Collectors.joining(" "));

            String onlyRoom = Room.rooms.stream()
                    .filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName())
                    .collect(Collectors.joining(" "));
            System.out.println(onlyName + " used a " + onlyWeapon + " to kill Flávio in the " + onlyRoom + ".");

        } else {
            System.out.println("Your awnser is wrong, and the true killer kill you in the pool.");
            System.out.println();
            String onlyName = Character.suspects.stream()
                    .filter(Character::getWasUsedToKill) //.filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName().substring(0, e.getName().indexOf("'s")))
                    .collect(Collectors.joining(" "));

            String onlyWeapon = Weapon.arrayListWeapons.stream()
                    .filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName())
                    .collect(Collectors.joining(" "));

            String onlyRoom = Room.rooms.stream()
                    .filter(e -> e.getWasUsedToKill())
                    .map(e -> e.getName())
                    .collect(Collectors.joining(" "));
            System.out.println(onlyName + " used a " + onlyWeapon + " to kill Flávio in the " + onlyRoom + ".");
            gameOver = true;
        }
    }
}

