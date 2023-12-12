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


        Character bruna = new Character("Bruna's bracelets", "Thorough observation revealed suspicious stains. Blood in the photo? This clue is macabre, but essential to the investigation.",
                "Did you find blood in the photo? I bet it's just a lighting trick or something.", false);
        Character francisco = new Character("Francisco's cigarettes",
                "In this photo, one piece of information turned out to be crucial. We've discovered a clue that takes us straight to the heart of the mystery!",
                "Clues in a photo? This feels more like a movie than a real investigation.", false);
        Character fatima = new Character("Fátima's notes",
                "The date on the edge of the photo is the key to connecting the events. This clue is a missing link we have found!" ,
                "Data and time in the image? This can be easily manipulated. How can we trust this?", false);
        Character paulo = new Character("Paulo's painting",
                "The location in the photograph is our next point of interest. This geographic clue will guide us in the search for the truth.",
                "Data, locations and times can be manipulated. I need more solid evidence than that.", false);
        Character david = new Character("David's card",
                "When examining the exact time of the photo, we noticed something extraordinary. This clue is like a clock that ticks the mystery revealer!",
                "This 'clue' seems more like a creative interpretation than a solid discovery.", false);
        Character edgar = new Character("Edgar's photo",
                "The location in the photo corresponds to a specific place. We're closer to solving the puzzle thanks to this clue!",
                "Specific location in the photo? Or someone was simply traveling and decided to take a photo.", false);

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
