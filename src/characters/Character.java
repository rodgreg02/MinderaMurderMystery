package characters;

import java.util.ArrayList;

import gameCore.Card;
import gameCore.Game;


public class Character extends Card {

    public Character(String name, String tipGuilty, String tipNotGuilty, boolean suspectFound) {
        this.name = name;
        this.clueSus = tipGuilty;
        this.clueNonSus = tipNotGuilty;
        this.wasUsedToKill = false;
    }

    public String isSuspectFound(Character characters){
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


    public static ArrayList<Character> suspects = new ArrayList<>();


    static ArrayList<Character> suspects = new ArrayList<>();

    public static ArrayList<Character> createCharacters() {


        Character Bruna = new Character("Bruna", "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Character Francisco = new Character("Francisco",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Character Fatima = new Character("Fátima",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Character Paulo = new Character("Paulo",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Character David = new Character("David",
                "Sometimes the mask of innocence hides secrets, just as the shadow of guilt can cover the truth.",
                "In the simplicity of truth, the light reveals a clear path, where innocence is the indisputable narrative.", false);
        Character Rodrigo = new Character("Rodrigo",
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
        Character.suspects.get(valueRandom).setWasUsedToKill(true);
    }


}
