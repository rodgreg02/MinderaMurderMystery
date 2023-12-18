package gamecore;

import characters.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Story {
    static String startStory(Player player) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("\t\t\t\t\tMindera Murder Mystery");

        String storyText = """
                \t The detective""" + " " + player.getName() + """ 
                 is called to investigate Flávio's murder.\s 
                \tAt the crime scene, you find an almost empty jar of Nutella, intriguing you.\s 
                \tDuring the investigation, it is discovered that Flávio had the habit of enjoying Nutella before going to sleep.\s
                \n
                \tAs you interview the suspects, you uncover a family secret and realize that the jar of Nutella was the cause of everything...
                """;

        return storyText;
    }

    public static void printWithDelay(String text) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        SoundTrackSystem soundTrackSystem = new SoundTrackSystem();
        soundTrackSystem.keyboardSound();

        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(0100); // Sleep for 1 second (1000 milliseconds)
            }
            System.out.println(); // Move to the next line after printing the text
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        soundTrackSystem.stop();
    }
}
