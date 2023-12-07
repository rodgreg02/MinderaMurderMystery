package Characters;

import java.util.ArrayList;

public class Characters {
    String name;
    String tipGuilty;
    String tipNotGuilty;
    boolean suspectFound;

    public Characters(String name, String tipGuilty, String tipNotGuilty, boolean suspectFound) {
        this.name = name;
        this.tipGuilty = tipGuilty;
        this.tipNotGuilty = tipNotGuilty;
        this.suspectFound = false;
    }

    public String isSuspectFound(Characters characters){
        return (characters.suspectFound) ? getTipGuilty() : getTipNotGuilty();
    }

    public String getName() {
        return name;
    }

    public String getTipGuilty() {
        return tipGuilty;
    }

    public String getTipNotGuilty() {
        return tipNotGuilty;
    }

    public boolean isTipUsed() {
        return suspectFound;
    }

    public void setTipUsed(boolean tipUsed) {
        this.suspectFound = tipUsed;
    }

    static ArrayList<Characters> suspects = new ArrayList<>();
    public static ArrayList<Characters> createCharacters() {


        Characters Bruna = new Characters("Bruna", "Thorough observation revealed suspicious stains. Blood in the photo? This clue is macabre, but essential to the investigation.",
                "Did you find blood in the photo? I bet it's just a lighting trick or something.", false);
        Characters Francisco = new Characters("Francisco",
                "In this photo, one piece of information turned out to be crucial. We've discovered a clue that takes us straight to the heart of the mystery!",
                "Clues in a photo? This feels more like a movie than a real investigation.", false);
        Characters Fatima = new Characters("Fátima",
                "The date on the edge of the photo is the key to connecting the events. This clue is a missing link we have found!" ,
                "Data and time in the image? This can be easily manipulated. How can we trust this?", false);
        Characters Paulo = new Characters("Paulo",
                "The location in the photograph is our next point of interest. This geographic clue will guide us in the search for the truth.",
                "Data, locations and times can be manipulated. I need more solid evidence than that.", false);
        Characters David = new Characters("David",
                "When examining the exact time of the photo, we noticed something extraordinary. This clue is like a clock that ticks the mystery revealer!",
                "This 'clue' seems more like a creative interpretation than a solid discovery.", false);
        Characters Rodrigo = new Characters("Edgar",
                "The location in the photo corresponds to a specific place. We're closer to solving the puzzle thanks to this clue!",
                "Specific location in the photo? Or someone was simply traveling and decided to take a photo.", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(David);
        suspects.add(Rodrigo);

        return suspects;
    }
}