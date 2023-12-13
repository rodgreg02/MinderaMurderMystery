package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Long.valueOf;

public class FileManager {
    String FILE_PATH = "leaderboard.txt";
    public boolean createFile(){
            try {
                File dataStore = new File(FILE_PATH);
                if (dataStore.createNewFile()) {
                    System.out.println("No previous database found. Creating a new one.");
                    return true;
                } else {
                    System.out.println("Loading previous database...");
                    return false;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        public boolean writeDatabase(String toWrite) {

        try {
            FileWriter fw = new FileWriter(FILE_PATH,true);
            fw.write(toWrite + "\n");
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred writting to the DB.");
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<WriteableFormat> readDatabase() {
        try {
            ArrayList<WriteableFormat> scoreboard = new ArrayList<>();
            File obj = new File(FILE_PATH);
            Scanner reader = new Scanner(obj);
            while (reader.hasNext()) {
                String currLine = reader.next();
                String[] currLineSerialized = currLine.split("-");
                long longTime = Long.parseLong(currLineSerialized[1]);
                WriteableFormat wf = new WriteableFormat(currLineSerialized[0],longTime);
                scoreboard.add(wf);
            }
            reader.close();
            return scoreboard;
        } catch (IOException e) {
            System.out.println("Something went wrong reading database.");
        }
        return null;
    }
    }

