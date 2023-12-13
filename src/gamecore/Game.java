package gamecore;

import characters.Character;
import characters.Player;
import room.Room;
import weapon.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where was the crime room?");
        System.out.print("=> ");
        String roomGuess = scanner.nextLine().toLowerCase().trim();
        charactersEnding(nameGuess, weaponGuess, roomGuess);
    }

    public static void charactersEnding(String nameGuess, String weaponGuess, String roomGuess) {
        int counter = 0;
        System.out.println(nameGuess + weaponGuess + roomGuess);
        for (int i = 0; i < Character.suspects.size(); i++) {
            if (Character.suspects.get(i).getName().toLowerCase().contains(nameGuess) && Character.suspects.get(i).getWasUsedToKill()) {
                counter++;
            }
        }

        for (int i = 0; i < Weapon.arrayListWeapons.size(); i++) {
            if (Weapon.arrayListWeapons.get(i).getName().toLowerCase().contains(weaponGuess) && Weapon.arrayListWeapons.get(i).getWasUsedToKill()) {
                counter++;
            }
        }

        for (int i = 0; i < Room.rooms.size(); i++) {
            if (Room.rooms.get(i).getName().toLowerCase().contains(roomGuess) && Room.rooms.get(i).getWasUsedToKill()) {
                counter++;
            }
        }

        System.out.println();
        if (counter == 3) {
            System.out.println("Your awnser is right");
            for (int i = 0; i < Character.suspects.size(); i++) {
                if (Character.suspects.get(i).getWasUsedToKill()) {
                    String onlyName = Character.suspects.get(i).getName().substring(0, Character.suspects.get(i).getName().indexOf("'s"));
                    System.out.print(onlyName + " used a ");
                }
            }
            for (int i = 0; i < Weapon.arrayListWeapons.size(); i++) {
                if (Weapon.arrayListWeapons.get(i).getWasUsedToKill()) {
                    System.out.print(Weapon.arrayListWeapons.get(i).getName() + " to kill Flávio in the ");
                }
            }

            for (int i = 0; i < Room.rooms.size(); i++) {
                if (Room.rooms.get(i).getWasUsedToKill()) {
                    System.out.print(Room.rooms.get(i).getName());
                }
            }
            System.exit(0);

        } else {
            System.out.println("Your awnser is wrong, and the true killer kill you in the pool.");
            System.out.println();
            for (int i = 0; i < Character.suspects.size(); i++) {
                if (Character.suspects.get(i).getWasUsedToKill()) {
                    String onlyName = Character.suspects.get(i).getName().substring(0, Character.suspects.get(i).getName().indexOf("'s"));
                    System.out.print(onlyName + " used a ");
                }
            }
            for (int i = 0; i < Weapon.arrayListWeapons.size(); i++) {
                if (Weapon.arrayListWeapons.get(i).getWasUsedToKill()) {
                    System.out.print(Weapon.arrayListWeapons.get(i).getName() + " to kill Flávio in the ");
                }
            }

            for (int i = 0; i < Room.rooms.size(); i++) {
                if (Room.rooms.get(i).getWasUsedToKill()) {
                    System.out.print(Room.rooms.get(i).getName());
                }
            }
            System.out.println();
            System.exit(0);
        }
    }
}

