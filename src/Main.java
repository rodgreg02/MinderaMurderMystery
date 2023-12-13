import characters.Character;
import characters.Player;
import file.FileManager;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {

            FileManager fm = new FileManager();
            fm.createFile();
            List<WriteableFormat> leaderboard = fm.readDatabase();
            Scanner scanner = new Scanner(System.in);
            Game game = new Game();
            Timestamp start = Timestamp.from(Instant.now());
            game.startGame();
            Timestamp end = Timestamp.from(Instant.now());
            long totalTime = end.getTime() - start.getTime();
            String formattedDuration = WriteableFormat.formatTime(totalTime);
            System.out.println("You took: " + formattedDuration + " to solve the crime");
            System.out.println("Insert your name for the leaderboard!");
            WriteableFormat playerScore = new WriteableFormat(scanner.next(), totalTime);
            leaderboard.add(playerScore);
            leaderboard = leaderboard.stream()
                    .sorted((e1, e2) -> e1.getTime().compareTo(e2.getTime()))
                    .collect(Collectors.toList());
            fm.writeDatabase(playerScore.toString());
            leaderboard.stream()
                    .forEach((e) -> System.out.println(e.getName() + "-" + WriteableFormat.formatTime(e.getTime())));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}