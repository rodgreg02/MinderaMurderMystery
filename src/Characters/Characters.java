package Characters;

import java.util.ArrayList;
import java.util.Random;

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
}
