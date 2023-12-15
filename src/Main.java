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
import java.util.*;
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

            if (Game.solveGame) {
                Timestamp end = Timestamp.from(Instant.now());
                long totalTime = end.getTime() - start.getTime();
                long seconds = totalTime / 1_000;
                long minutes = seconds / 60;
                seconds = seconds % 60;

            Timestamp end = Timestamp.from(Instant.now());
            long totalTime = end.getTime() - start.getTime();
            String formattedDuration = WriteableFormat.formatTime(totalTime);
            System.out.println("You took: " + formattedDuration + " to solve the crime");
            System.out.println("Insert your name for the leaderboard!");
            WriteableFormat playerScore = new WriteableFormat(scanner.next(), totalTime);
            leaderboard.add(playerScore);
            leaderboard = leaderboard.stream()
                    .sorted(Comparator.comparing(WriteableFormat::getTime))
                    .collect(Collectors.toList());
            fm.writeDatabase(playerScore.toString());
            leaderboard.stream()
                    .forEach((e) -> System.out.println(e.getName() + "-" + WriteableFormat.formatTime(e.getTime())));

                String formattedDuration = String.format("%02d:%02d", minutes, seconds);
                System.out.println("You took: " + formattedDuration + " to solve the crime");
                System.out.println("Insert your name for the leaderboard!");
                WriteableFormat playerScore = new WriteableFormat(scanner.next(), totalTime);
                leaderboard.add(playerScore);
                leaderboard = leaderboard.stream()
                        .sorted((e1, e2) -> e2.getTime().compareTo(e1.getTime()))
                        .collect(Collectors.toList());
                fm.writeDatabase(playerScore.toString());
                leaderboard.stream()
                        .forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}