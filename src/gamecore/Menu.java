package gamecore;

import characters.CharactersEnding;
import characters.Player;
import com.sun.tools.javac.Main;
import room.Room;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Player player;
    SoundTrackSystem soundTrackSystem1 = new SoundTrackSystem();


    public void mainMenu() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        soundTrackSystem1.firstGameSound();

        boolean quitGame = false;
        while (!quitGame && !Game.gameOver) {
            System.out.println("==== Welcome to MinderaMurderMystery Game ====");
            System.out.println("1 => Play");
            System.out.println("2 => Rules");
            System.out.println("0 => Exit");
            System.out.print("" +
                    "\t\t\t\t\t\t\t\t                              x/^\\/^\\\n" +
                    "\t\t\t\t\t\t\t\t                              \\----|\n" +
                    "\t\t\t\t\t\t\t\t                          _---'---~~~~-_\n" +
                    "\t\t\t\t\t\t\t\t                           ~~~|~~L~|~~~~\n" +
                    "\t\t\t\t\t\t\t\t                              (/_  /~~--\n" +
                    "\t\t\t\t\t\t\t\t                            \\~ \\  /  /~\n" +
                    "\t\t\t\t\t\t\t\t                          __~\\  ~ /   ~~----,\n" +
                    "\t\t\t\t\t\t\t\t                          \\    | |       /  \\\n" +
                    "\t\t\t\t\t\t\t\t                          /|   |/       |    |\n" +
                    "\t\t\t\t\t\t\t\t                          | | | o  o     /~   |\n" +
                    "\t\t\t\t\t\t\t\t                        _-~_  |        ||  \\  /\n" +
                    "\t\t\t\t\t\t\t\t                       (// )) | o  o    \\\\---'\n" +
                    "\t\t\t\t\t\t\t\t                       //_- |  |          \\\n" +
                    "\t\t\t\t\t\t\t\t                      //   |____|\\______\\__\\\n" +
                    "\t\t\t\t\t\t\t\t                     ~      |   / |    |\n" +
                    "\t\t\t\t\t\t\t\t                              |_ /   \\ _|\n" +
                    "\t\t\t\t\t\t\t\t                            /~___|  /____\\");
            String option = scan.next();

            switch (option) {
                case "0":
                    System.out.println("Exiting");
                    quitGame = true;
                    break;
                case "1":
                    storyMenu();
                    break;
                case "2":
                    showRules();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private void storyMenu() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        SoundTrackSystem soundTrackSystem = new SoundTrackSystem();
        soundTrackSystem.policeSound();
        System.out.println("Insert the name of your detective: ");
        String detectiveName = scan.next();
        player = new Player(detectiveName);
        cleanConsole();
        Render.drawMap(Room.rooms);
        Thread.sleep(5000);
        cleanConsole();
        Story.printWithDelay(Story.startStory(player));
        Thread.sleep(2000);
        soundTrackSystem.stop();
        soundTrackSystem1.stop();
        gameMenu(Room.rooms);
    }


    private int currentPosition = 0;


    private void gameMenu(ArrayList<Room> rooms) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        SoundTrackSystem soundTrackSystem = new SoundTrackSystem();
        soundTrackSystem.backgroundMusicSurvivalFirst();
        Scanner scan = new Scanner(System.in);
        boolean leaveMission = false;
        while (!leaveMission && !Game.gameOver) {

            System.out.println("You are in " + rooms.get(currentPosition).getName());
            Render.drawRoom(rooms.get(currentPosition));

            menu();

            System.out.println("0=> Quit");
            String option = scan.next();
            switch (option) {
                case "1":
                    player.investigate(rooms.get(currentPosition));
                    break;
                case "2":
                    walkToNextRoom(rooms);
                    break;
                case "3":
                    walkToPreviousRoom(rooms);
                    break;
                case "4":
                    player.checkInventory();
                    break;
                case "5":
                    scan.reset();
                    checkIfPossibleGuess();
                    break;
                case "0":
                    leaveMission = true;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private void menu() {
        System.out.println("1=> Investigate");
        System.out.println("2=> Next Room");
        System.out.println("3=> Previous Room");
        System.out.println("4=> Check Inventory");
        if (currentPosition >= 5) {
            System.out.println("5=> Go to the Pool");
        }
    }

    private void showRules() {
        System.out.println("Rules");
        System.out.println("""
                In this game there are 6 suspects, 6 suspected weapons and 9 locations to investigate.\s              
                From the 5th room onwards you could go to the pool to give your final answer as to who is to blame.\s              
                YOU ONLY HAVE ONE CHANCE.
                """);
    }

    private void walkToNextRoom(ArrayList<Room> rooms) throws InterruptedException {
        System.out.print("Walking.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        rooms.get(currentPosition + 1);
        currentPosition++;
        if(currentPosition == 8){
            Game.finalEnd(player);
        }
    }

    private void walkToPreviousRoom(ArrayList<Room> rooms) throws InterruptedException {
        System.out.print("Walking.");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println(".");
        try {
            rooms.get(currentPosition - 1);
            currentPosition--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You abandoned the mission");
            System.exit(0);
        }

    }

    private void checkIfPossibleGuess() {
        Game.finalEnd(player);

    }

    private void cleanConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
