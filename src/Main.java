import characters.Character;
import characters.Player;
import file.FileManager;
import file.WriteableFormat;
import gamecore.Card;
import gamecore.Credit;
import gamecore.Game;
import gamecore.Leaderboard;
import room.Room;
import weapon.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Game game = new Game();
            Timestamp start = Timestamp.from(Instant.now());
            game.startGame();
            if (Game.solveGame) {
                Timestamp end = Timestamp.from(Instant.now());
                Leaderboard.finalLeader(start,end);
            }
            Thread.sleep(2000);
            Credit.playCredit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}