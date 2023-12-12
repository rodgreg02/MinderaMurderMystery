package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    String FILE_PATH = "/file/leaderboard.txt";
    public boolean createFile(String string){
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
            FileWriter fw = new FileWriter(FILE_PATH,false);
            fw.write(toWrite);
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<WriteableFormat> readDatabase() {
        try {
            ArrayList<WriteableFormat> scoreBoard = new ArrayList<>();
            File obj = new File(FILE_PATH);
            Scanner reader = new Scanner(obj);

            reader.close();
            return scoreBoard;
        } catch (IOException e) {
            System.out.println("Something went wrong reading database.");
        }
        return null;
    }
    }

