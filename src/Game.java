import Weapons.Weapons;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    static ArrayList<Weapons> weapons = Weapons.CreateWeapons();

    static int StandardRandom(int numRandom) {
        Random random = new Random();
        return random.nextInt(numRandom);
    }

    static void chooseRandomWeaponKill() {
        int valueRandom = (Game.StandardRandom(6));
        weapons.get(valueRandom).setWasUsedToKill(true);
        System.out.println(weapons.get(valueRandom).getWeaponName());

    
    public static void mainMenu(){
      Scanner scan = new Scanner(System.in);
        boolean quitGame = false;
        while (!quitGame) {
            System.out.println("==== Welcome to MurderMistery Game ====");
            System.out.println("1 => Play");
            System.out.println("2 => Exit");
            String option = scan.next();
            if (option.equals("1")){
                gameMenu();
            }
            if (option.equals("2")){
                quitGame = true;
            }
            if (!option.equals("1") && !option.equals("2")){
                System.out.println("Invalid Input");
            }
        }
    }




    private static void gameMenu(){
        System.out.println("Insert the name of your detective: ");
        String detectiveName = scan.next();
        Player player = new Player(detectiveName);
        Story.startStory(player);
    }


}
