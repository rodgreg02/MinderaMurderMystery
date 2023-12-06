package Characters;

import java.util.ArrayList;
import GameCore.Cards;
import GameCore.Game;
import Weapons.Weapons;

public class Characters extends Cards{

    public Characters(String name, String tipGuilty, String tipNotGuilty, boolean suspectFound) {
        this.name = name;
        this.clueSus = tipGuilty;
        this.clueNonSus = tipNotGuilty;
        this.wasUsedToKill = false;
    }


    public String getName() {
        return name;
    }

    public String getTipGuilty() {
        return clueSus;
    }

    public String getTipNotGuilty() {
        return clueNonSus;
    }

    public boolean isTipUsed() {
        return wasUsedToKill;
    }
    //-------------------------

    public static ArrayList<Characters> suspects = new ArrayList<>();

    public static ArrayList<Characters> createCharacters() {
        Characters Bruna = new Characters("Bruna", "Guilty", "Not Guilty", false);
        Characters Francisco = new Characters("Francisco", "Guilty", "Not Guilty", false);
        Characters Fatima = new Characters("Fátima", "Guilty", "Not Guilty", false);
        Characters Paulo = new Characters("Paulo", "Guilty", "Not Guilty", false);
        Characters Gabi = new Characters("Gabi", "Guilty", "Not Gilty", false);
        Characters Rodrigo = new Characters("Rodrigo", "Guilty", "Not Guilty", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(Gabi);
        suspects.add(Rodrigo);

        return suspects;
    }

    public static void chooseRandomCharacterKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Characters.suspects.get(valueRandom).setWasUsedToKill(true);
    }

}
