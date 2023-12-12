package weapon;

import java.util.ArrayList;
import gamecore.Card;

public class WeaponPT extends Card {


    public WeaponPT(String name, String tipSus, String tipNonSus, boolean wasUsedToKill) {
        this.name = name;
        this.clueSus = tipSus;
        this.clueNonSus = tipNonSus;
        this.wasUsedToKill = wasUsedToKill;
    }

    public String getWeaponName() {
        return name;
    }

    public String getTipSus() {
        return clueSus;
    }

    public String getTipNonSus() {
        return clueNonSus;
    }

    public boolean wasUsedToKill() {
        return wasUsedToKill;
    }


    public static ArrayList<Weapon> arrayListWeapons = new ArrayList<>();





    public static void createWeapons() {
        Weapon knife = new Weapon("Faca",
                "A faca, com vestígios de sangue seco, estava escondida atrás de alguns livros na estante.",
                "A lâmina afiada da faca estava cuidadosamente guardada numa caixa de madeira, como uma relíquia preciosa.",
                false);
        Weapon pistol = new Weapon("Pistola",
                "Uma pistola abandonada, ainda a fumegar, repousava sobre a mesa, um instrumento de propósito sinistro.",
                "A pistola, polida até brilhar, repousava dentro do seu estojo de veludo, uma testemunha silenciosa da última vez que foi usada.",
                false);
        Weapon pipe = new Weapon("Pipe",
                "O cano, agora usado como arma, estava deitado no chão, revelando um historial de violência",
                "O cano metálico estava bem pendurado na parede, uma peça de decoração que denotava classe e não violência.",
                false);
        Weapon chandelier = new Weapon("Candelabro",
                "Fragmentos de cera espalhados pela alcatifa testemunham a transformação do candelabro de adorno em instrumento letal.",
                " lustre de cristal perfeitamente polido pendia majestosamente no centro da sala, uma obra de arte suspensa.",
                false);
        Weapon rope = new Weapon("Corda",
                "As marcas de uso grosseiro na corda sugeriam que tinha sido enrolada em mãos que tremiam de medo.",
                "A corda de marinheiro, perfeitamente enrolada, estava guardada na caixa de ferramentas, uma ferramenta de utilidade, não de crime.",
                false);
        Weapon hammer = new Weapon("Martelo",
                "O martelo destruído, uma ferramenta agora manchada pelo crime, estava num canto escuro da sala.",
                "O martelo do carpinteiro repousava na sua bancada de trabalho, uma ferramenta digna de construção, não de destruição.",
                false);

        arrayListWeapons.add(knife);
        arrayListWeapons.add(pistol);
        arrayListWeapons.add(pipe);
        arrayListWeapons.add(chandelier);
        arrayListWeapons.add(rope);
        arrayListWeapons.add(hammer);

        return;
    }





    public void setWasUsedToKill(boolean wasUsedToKill) {
        this.wasUsedToKill = wasUsedToKill;
    }



    public String getClue(Weapon oneWeapon) {
        return (oneWeapon.wasUsedToKill() ? getTipSus() : getTipNonSus());
    }

}
