package characters;

import gameCore.Card;
import weapon.Weapon;
import room.Room;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

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
        System.out.println(room.getClues().getName());




    }


    public void examine(Room room) throws InterruptedException {
        System.out.print("Examining the " + room.getClues().getName()+"");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println(room.getClueObject());



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
