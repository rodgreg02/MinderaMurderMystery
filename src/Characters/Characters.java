package Characters;

import java.util.ArrayList;

import GameCore.Cards;
import GameCore.Game;
import Weapons.Weapons;

import java.util.Random;


public class Characters extends Cards{

    public Characters(String name, String tipGuilty, String tipNotGuilty, boolean suspectFound) {
        this.name = name;
        this.clueSus = tipGuilty;
        this.clueNonSus = tipNotGuilty;
        this.wasUsedToKill = false;
    }

    public String isSuspectFound(Characters characters){
        return (characters.suspectFound) ? getTipGuilty() : getTipNotGuilty();
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


    public static ArrayList<Characters> suspects = new ArrayList<>();


    static ArrayList<Characters> suspects = new ArrayList<>();

    public static ArrayList<Characters> createCharacters() {


        Characters Bruna = new Characters("Bruna", "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Characters Francisco = new Characters("Francisco",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Characters Fatima = new Characters("Fátima",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Characters Paulo = new Characters("Paulo",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Characters David = new Characters("David",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Characters Rodrigo = new Characters("Rodrigo",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(David);
        suspects.add(Rodrigo);

        return suspects;
    }


    public static void chooseRandomCharacterKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Characters.suspects.get(valueRandom).setWasUsedToKill(true);
    }


}
