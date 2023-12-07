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


        Character Bruna = new Character("Bruna", "Thorough observation revealed suspicious stains. Blood in the photo? This clue is macabre, but essential to the investigation.",
                "Did you find blood in the photo? I bet it's just a lighting trick or something.", false);
        Character Francisco = new Character("Francisco",
                "In this photo, one piece of information turned out to be crucial. We've discovered a clue that takes us straight to the heart of the mystery!",
                "Clues in a photo? This feels more like a movie than a real investigation.", false);
        Character Fatima = new Character("Fátima",
                "The date on the edge of the photo is the key to connecting the events. This clue is a missing link we have found!" ,
                "Data and time in the image? This can be easily manipulated. How can we trust this?", false);
        Character Paulo = new Character("Paulo",
                "The location in the photograph is our next point of interest. This geographic clue will guide us in the search for the truth.",
                "Data, locations and times can be manipulated. I need more solid evidence than that.", false);
        Character David = new Character("David",
                "When examining the exact time of the photo, we noticed something extraordinary. This clue is like a clock that ticks the mystery revealer!",
                "This 'clue' seems more like a creative interpretation than a solid discovery.", false);
        Character Rodrigo = new Character("Edgar",
                "The location in the photo corresponds to a specific place. We're closer to solving the puzzle thanks to this clue!",
                "Specific location in the photo? Or someone was simply traveling and decided to take a photo.", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(David);
        suspects.add(Rodrigo);

        return;
    }


    public static void chooseRandomCharacterKill() {
        int valueRandom = (Game.randomNumberGenerator(5));
        Character.suspects.get(valueRandom).setWasUsedToKill(true);
    }


}
