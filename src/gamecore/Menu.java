package gamecore;

import characters.Player;
import room.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    private String detectiveName = "";
    Player player = new Player(detectiveName);


    public void mainMenu() throws InterruptedException {
        boolean quitGame = false;
        while (!quitGame) {
            System.out.println("==== Welcome to MinderaMurderMystery Game ====");
            System.out.println("1 => Play");
            System.out.println("2 => Exit");
            String option = scan.next();
            if (option.equals("1")) {
                storyMenu();
            }
            if (option.equals("2")) {
                quitGame = true;
            }
            if (!option.equals("1") && !option.equals("2")) {
                System.out.println("Invalid Input");
            }
        }
    }

    private void storyMenu() throws InterruptedException {
        System.out.println("Insert the name of your detective: ");
        detectiveName = scan.next();
        Render.drawMap(Room.rooms);
        Thread.sleep(5000);
        cleanConsole();
        Story.startStory(player);
        Thread.sleep(2000);
        gameMenu(Room.rooms);

    }


    private int currentPosition = 0;


    private void gameMenu(ArrayList<Room> rooms) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        boolean leaveMission = false;
        while (!leaveMission) {

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
                    finalEnd(rooms);
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

    private void walkToNextRoom(ArrayList<Room> rooms) throws InterruptedException {
        System.out.print("Walking.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        rooms.get(currentPosition + 1);
        currentPosition++;
    }

    private void walkToPreviousRoom(ArrayList<Room> rooms) throws InterruptedException {
        System.out.print("Walking.");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println(".");
        rooms.get(currentPosition - 1);
        currentPosition--;

    }

    private boolean checkIfPossibleGuess(ArrayList<Room> rooms) {
        String option = scan.next();
        if (option.equals("5")) {
            finalEnd(rooms);
        }

        return false;
    }

    private void finalEnd(ArrayList<Room> rooms) {
        currentPosition = 8;
        System.out.println("You are in " + rooms.get(currentPosition).getName());
        Render.drawRoom(rooms.get(currentPosition));
        player.checkInventory();
    }

    private int checkGuessFromDetective() {
        return 0;
    }

    private void cleanConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}