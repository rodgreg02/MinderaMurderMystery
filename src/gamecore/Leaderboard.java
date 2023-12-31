package gamecore;

import file.FileManager;
import file.WriteableFormat;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Leaderboard {
    static public void finalLeader(Timestamp start,Timestamp end){
        Scanner scanner = new Scanner(System.in);
        FileManager fm = new FileManager();
        fm.createFile();
        List<WriteableFormat> leaderboard = fm.readDatabase();
        long totalTime = end.getTime() - start.getTime();
        long seconds = totalTime / 1_000;
        long minutes = seconds / 60;
        seconds = seconds % 60;

        String formattedDuration = String.format("%02d:%02d", minutes, seconds);
        System.out.println("You took: " + formattedDuration + " to solve the crime");
        System.out.println("Insert your name for the leaderboard!");
        WriteableFormat playerScore = new WriteableFormat(scanner.next(), totalTime);
        leaderboard.add(playerScore);
        leaderboard = leaderboard.stream()
                .sorted((e1, e2) -> e2.getTime().compareTo(e1.getTime()))
                .collect(Collectors.toList());
        fm.writeDatabase(playerScore.toString());
        leaderboard.forEach(Leaderboard::printResultFormatted);
    }

    public static void showLeaderBoard(){
        Scanner scanner = new Scanner(System.in);
        FileManager fm = new FileManager();
        List<WriteableFormat> leaderboard = fm.readDatabase();
        leaderboard = leaderboard.stream()
                .sorted(Comparator.comparingLong(WriteableFormat::getTime))
                .collect(Collectors.toList());

        for (int i = 0; i < leaderboard.size(); i++) {
            int position = i + 1;
            WriteableFormat format = leaderboard.get(i);
            System.out.print(position + " - ");
            printResultFormatted(format);
        }

        System.out.println("Press any key to go to the main menu:");
        scanner.next();
    }

    private static void printResultFormatted(WriteableFormat writeableFormat) {
        long seconds = writeableFormat.getTime() / 1_000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String formattedDuration = String.format("%02d:%02d - %s", minutes, seconds, writeableFormat.getName());
        System.out.println(formattedDuration);
    }}
