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
    //-------------------------

    public static ArrayList<Characters> createCharacters() {
        ArrayList<Characters> suspects = new ArrayList<>();

        Characters Bruna = new Characters("Bruna", "Guilty", "Not Guilty", false);
        Characters Francisco = new Characters("Francisco", "Guilty", "Not Guilty", false);
        Characters Fatima = new Characters("Fátima", "Guilty", "Not Guilty", false);
        Characters Paulo = new Characters("Paulo", "Guilty", "Not Guilty", false);
        Characters David = new Characters("David", "Guilty", "Not Gilty", false);
        Characters Rodrigo = new Characters("Rodrigo", "Guilty", "Not Guilty", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(David);
        suspects.add(Rodrigo);

        return suspects;
    }

}
