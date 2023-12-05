package Weapons;


public class AddWeapons {
    String[] cardsOfWeapons = {
            WeaponCards.WEAPON_PISTOL.getWeaponName(),
            WeaponCards.WEAPON_KNIFE.getWeaponName(),
            WeaponCards.WEAPON_ROPE.getWeaponName(),
            WeaponCards.WEAPON_CHANDELIER.getWeaponName(),
            WeaponCards.WEAPON_PIPE.getWeaponName(),
            WeaponCards.WEAPON_TOOL.getWeaponName()
    };

    public void showWeaponArray() {
        for (int i = 0; i < cardsOfWeapons.length; i++) {
            System.out.println(cardsOfWeapons[i]);
        }
    }
}
