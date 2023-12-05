import Weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        //Story.startStory();
        //Story.goodEnding();
        //Story.badEnding();
        Game game = new Game();
        Weapons Weapons = new Weapons();
        Weapons.showWeaponArray();
        game.mainMenu();
    }
}