package gamecore;

import characters.Character;
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
    public static void charactersEnding() {
        System.out.print("It was during the night that ");
        int counter = 0;
        boolean seeIfCounterMax = false;

        for (int i = 0; i < 6; i++) {
            if (Character.suspects.get(i).getWasUsedToKill()) {
                System.out.print(Character.suspects.get(i).getName() + " used a ");
            }
            if (Weapon.arrayListWeapons.get(i).getWasUsedToKill()) {
                System.out.print(Weapon.arrayListWeapons.get(i).getName() + " to kill Flávio in the ");
            }
        }
        for (int i = 0; i < Room.rooms.size(); i++) {
            if(Room.rooms.get(i).getWasUsedToKill()){
                System.out.print(Room.rooms.get(i).getName());
            }
        }
        System.out.println();
    }
}
