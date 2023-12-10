package characters;

import gameCore.Card;
import weapon.Weapon;
import room.Room;

import java.util.*;

public class Player {

    private final String name;

    List<Object> detectiveBag = new LinkedList<>();


    public void investigate(Room room) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Investigating...");
        System.out.println(room.getClueRoom());
        System.out.println("Press any key to continue");
        String anykey = scan.next();
        System.out.print("Continue Investigating.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println("You found " + room.getClues().getName());

        System.out.println("1 - Examine item.");
        System.out.println("2 - Keep investigating");
        String option = scan.next();
        if (option.equals("1")){
            examine(room);
        }
        if (!option.equals("1") && !option.equals("2")){
            System.out.println("Invalid Input");
        }

    }


    public void examine(Room room) throws InterruptedException {
        System.out.print("Examining the " + room.getClues().getName()+"");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println(room.getClueObject());
        detectiveBag.add(room.getClueObject());
    }

    public void checkInventory(){
        if(detectiveBag.isEmpty()){
            System.out.println("Your bag is Empty!!");
        }
        System.out.println("== Detective Bag ==");
       detectiveBag.forEach(System.out::println);
    }



    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        String emoji = "🕵🏽‍♂️️";
        return emoji;
    }
}
