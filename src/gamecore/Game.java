package gamecore;

import characters.Character;
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

    public int numbRandomSuspects(int numbRandom){
        Random random = new Random();
        return random.nextInt(numbRandom);
    }

    public void chooseRandomSuspect(){
        int randomSuspects = (numbRandomSuspects(6));
        suspects.get(randomSuspects).setWasUsedToKill(true);
        System.out.println(suspects.get(randomSuspects).getName());
    }

    public  static ArrayList<Card> selectClues(ArrayList<Card> allClues){
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


}
