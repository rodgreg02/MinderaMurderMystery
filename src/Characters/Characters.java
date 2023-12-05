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

        Characters Bruna = new Characters("Bruna", "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);
        Characters Francisco = new Characters("Francisco",
                "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);
        Characters Fatima = new Characters("Fátima",
                "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);
        Characters Paulo = new Characters("Paulo",
                "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);
        Characters David = new Characters("David",
                "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);
        Characters Rodrigo = new Characters("Rodrigo",
                "Às vezes, a máscara da inocência esconde segredos, assim como a sombra da culpa pode encobrir a verdade.",
                "Na simplicidade da verdade, a luz revela um caminho claro, onde a inocência é a narrativa indiscutível.", false);

        suspects.add(Bruna);
        suspects.add(Francisco);
        suspects.add(Fatima);
        suspects.add(Paulo);
        suspects.add(David);
        suspects.add(Rodrigo);

        return suspects;
    }

}
