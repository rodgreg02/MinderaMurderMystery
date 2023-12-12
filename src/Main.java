import characters.Character;
import gamecore.Card;
import gamecore.Game;
import room.Room;
import weapon.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        Game game = new Game();
        game.startGame();
    }
}