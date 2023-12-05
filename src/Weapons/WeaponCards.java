package Weapons;

enum WeaponCards {
    WEAPON_PISTOL(0, "PISTOL","Tem polvora seca"),
    WEAPON_KNIFE(1, "KNIFE","Tem uma substancia vermelha"),
    WEAPON_ROPE(2, "ROPE","Esta tão desgastada"),
    WEAPON_CHANDELIER(3, "CHANDELIER","Esta sem cera"),
    WEAPON_PIPE(4, "PIPE","Nota-se que esta bastante dobrado"),
    WEAPON_TOOL(5, "HAMMER","Porque que este martelo tem uma parte vermelha?"),
    ;
    private final String weaponName;
    private final int index;

    private final String description;

    WeaponCards(int index, String weaponName, String description) {
        this.weaponName = weaponName;
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public String getDescription() {
        return description;
    }
}
