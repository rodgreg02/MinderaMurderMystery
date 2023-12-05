import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            System.out.println(Weapons.CreateWeapons().get(i).getWeaponName());
            System.out.println(Weapons.CreateWeapons().get(i).getTipSus());
            System.out.println(Weapons.CreateWeapons().get(i).getTipNonSus());
            System.out.println(Weapons.CreateWeapons().get(i).wasUsedToKill());
        }
    }
}