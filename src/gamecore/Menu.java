package gamecore;
import characters.Player;
import room.Room;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);

    public void mainMenu () throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean quitGame = false;
        while (!quitGame) {
            System.out.println("==== Welcome to MinderaMurderMystery Game ====");
            System.out.println("1 => Play");
            System.out.println("2 => Exit");
            String option = scan.next();
            if (option.equals("1")) {
                gameMenu();
            }
            if (option.equals("2")) {
                quitGame = true;
            }
            if (!option.equals("1") && !option.equals("2")) {
                System.out.println("Invalid Input");
            }
        }
    }


    private void gameMenu () throws InterruptedException {
        System.out.println("Insert the name of your detective: ");
        String detectiveName = scan.next();
        Player player = new Player(detectiveName);
        Render.drawMap(Room.rooms);
        Thread.sleep(5000);
        cleanConsole();
        Story.startStory(player);

    }

    private void cleanConsole(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nn\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
