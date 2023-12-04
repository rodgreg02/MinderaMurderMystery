package Weapons;

enum WeaponCards {
    WEAPON_PISTOL(0,"PISTOL"),
    WEAPON_KNIFE(1,"KNIFE"),
    WEAPON_ROPE(2,"ROPE"),
    WEAPON_CHANDELIER(3,"CHANDELIER"),
    WEAPON_PIPE(4,"PIPE"),
    WEAPON_TOOL(5,"HAMMER"),
    ;
    private final String tileName;
    private final int index;

    WeaponCards(int index, String tileName) {
        this.tileName = tileName;
        this.index = index;
    }

}
