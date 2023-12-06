package GameCore;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);

    public void mainMenu () {
        Scanner scan = new Scanner(System.in);
        boolean quitGame = false;
        while (!quitGame) {
            System.out.println("==== Welcome to MurderMistery GameCore.Game ====");
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


    private void gameMenu () {
        System.out.println("Insert the name of your detective: ");
        String detectiveName = scan.next();
        Player player = new Player(detectiveName);
        Story.startStory(player);
    }
}
