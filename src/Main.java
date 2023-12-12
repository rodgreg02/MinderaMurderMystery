import characters.Character;
import characters.Player;
import file.WriteableFormat;
import gamecore.Card;
import gamecore.Game;
import room.Room;
import weapon.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Game game = new Game();
            Player player = new Player(scanner.next());
            Timestamp start= Timestamp.from(Instant.now());
            game.startGame();
            Timestamp end= Timestamp.from(Instant.now());
            long totalTime = end.getTime() - start.getTime();
            long seconds = totalTime / 1_000;
            long minutes = seconds / 60;
            seconds = seconds % 60;

            String formattedDuration = String.format("%02d:%02d", minutes, seconds);
            System.out.println("You took: " + formattedDuration + " to solve the crime");
            WriteableFormat playerScore = new WriteableFormat(formattedDuration, scanner.next());
            
        } catch (Exception e) {
            System.out.println("AHHHHHHHHHHHHH");
        }
    }
}