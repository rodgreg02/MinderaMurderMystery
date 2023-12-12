package characters;

import java.util.ArrayList;

import gamecore.Card;
import gamecore.Game;


public class Character extends Card {

    public Character(String name, String tipGuilty, String tipNotGuilty, boolean suspectFound) {
        this.name = name;
        this.clueSus = tipGuilty;
        this.clueNonSus = tipNotGuilty;
        this.wasUsedToKill = false;
    }

    public String getSuspectClue(Character characters){
        return (characters.wasUsedToKill) ? getClueGuilty() : getClueNotGuilty();
    }

    public String getClueGuilty() {
        return clueSus;
    }

    public String getClueNotGuilty() {
        return clueNonSus;
    }

    public boolean  getWasUsedToKill() {
        return wasUsedToKill;
    }

    public static ArrayList<Character> suspects = new ArrayList<>();

    public static void createCharacters() {


        Character bruna = new Character("Bruna's hair spring", "Blood stains are found on the hair clip, indicating its use as a possible instrument in the crime.",
                "The spring shows no signs of violent use, ruling out the possibility of its direct involvement in the crime.",
                false);
        Character francisco = new Character("Francisco's cigarettes",
                "The distinctive aroma of L&M cigarette hangs in the air, suggesting the culprit's habit.",
                "The suspect claims to have had his pack of cigarettes stolen, indicating that others may have had access to the same type of cigarette.",
                false);
        Character fatima = new Character("Fátima's notes",
                "The unique vocabulary used in the note matches the suspect's way of speaking, suggesting he may be the perpetrator." ,
                "Forensic analysis indicates differences in writing style, pointing to the possibility that more than one person contributed to the note.",
                false);
        Character paulo = new Character("Paulo's ping pong paddle",
                "The racket exhibits signs of abnormal use, indicating that it was used in an unusual manner during the crime event.",
                "The racket shows signs of conventional use in a recent tournament, ruling out suspicion of involvement in the crime.",
                false);
        Character david = new Character("David's umbrella",
                "A fabric fiber matching the victim's clothing is found stuck in the folds of the umbrella, connecting it to the crime scene.",
                "The umbrella shows normal signs of outdoor use, with no evidence of involvement in criminal activity.",
                false);
        Character edgar = new Character("Edgar's tally marks",
                "A large number of tally marks suggests that the culprit may have recorded the execution of several actions during the crime.",
                "The marks are consistent with the suspect's record of pastimes, such as awarding points to students, indicating an innocent explanation for the count.",
                false);

        suspects.add(bruna);
        suspects.add(francisco);
        suspects.add(fatima);
        suspects.add(paulo);
        suspects.add(david);
        suspects.add(edgar);

    }

    public static void chooseRandomCharacterKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Character.suspects.get(valueRandom).setWasUsedToKill(true);
    }
}
