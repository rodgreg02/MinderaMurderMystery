import Characters.Characters;

import java.util.ArrayList;

public class Main {
    static ArrayList<Characters> arrayListSuspects = Characters.createCharacters();
    public static void main(String[] args) {

        System.out.println(arrayListSuspects.get(2).getName());

    }
}