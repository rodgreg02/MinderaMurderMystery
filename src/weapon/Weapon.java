package weapon;

import java.util.ArrayList;
import gamecore.Card;

public class Weapon extends Card {


    public Weapon(String name, String tipSus, String tipNonSus, boolean wasUsedToKill) {
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
        Weapon knife = new Weapon("Knife",
                "The knife, with traces of dried blood, was hidden behind some books on the shelf.",
                "The knife's sharp blade was carefully stored in a wooden box, like a precious relic.",
                false);
        Weapon pistol = new Weapon("Pistol",
                "An abandoned pistol, still smoking, rested on the table, an instrument of sinister purpose.",
                "The pistol, polished to a shine, rested inside its velvet case, a silent witness to the last time it was used.",
                false);
        Weapon pipe = new Weapon("Pipe",
                "The pipe, now used as a weapon, was lying on the floor, revealing a history of violence.",
                "The metallic pipe hung neatly on the wall, a piece of decoration that denoted class rather than violence.",
                false);
        Weapon chandelier = new Weapon("Chandelier",
                "Fragments of wax scattered across the carpet testified to the chandelier's transformation from adornment to lethal instrument.",
                "The perfectly polished crystal chandelier hung majestically in the center of the room, a suspended work of art.",
                false);
        Weapon rope = new Weapon("Rope",
                "Marks of rough use on the rope suggested that it had been wrapped around hands shaking with fear.",
                "The sailor's rope, perfectly coiled, was stored in the toolbox, a tool of utility, not crime.",
                false);
        Weapon hammer = new Weapon("Hammer",
                "The destroyed hammer, a tool now stained by crime, lay in a dark corner of the room.",
                "The carpenter's hammer rested on his workbench, a tool worthy of construction, not destruction.",
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
