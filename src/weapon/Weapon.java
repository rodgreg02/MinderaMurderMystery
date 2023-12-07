package weapon;

import java.util.ArrayList;
import gameCore.Card;

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





    public static ArrayList<Weapon> createWeapons() {
        Weapon knife = new Weapon("Knife", "This Knife is poorly clean", "This Knife is clean", false);
        Weapon pistol = new Weapon("Pistol", "This Pistol is poorly clean", "This Pistol is clean", false);
        Weapon pipe = new Weapon("Pipe", "This Pipe is poorly clean", "This Pipe is clean", false);
        Weapon chandelier = new Weapon("Chandelier", "This Chandelier is poorly clean", "This Chandelier is clean", false);
        Weapon rope = new Weapon("Rope", "This Rope is poorly clean", "This Rope is clean", false);
        Weapon hammer = new Weapon("Hammer", "This Hammer is poorly clean", "This Hammer is clean", false);

        arrayListWeapons.add(knife);
        arrayListWeapons.add(pistol);
        arrayListWeapons.add(pipe);
        arrayListWeapons.add(chandelier);
        arrayListWeapons.add(rope);
        arrayListWeapons.add(hammer);

        return arrayListWeapons;
    }





    public void setWasUsedToKill(boolean wasUsedToKill) {
        this.wasUsedToKill = wasUsedToKill;
    }



    public String getClue(Weapon oneWeapon) {
        return (oneWeapon.wasUsedToKill() ? getTipSus() : getTipNonSus());
    }

}
