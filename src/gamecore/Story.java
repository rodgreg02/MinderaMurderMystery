package gamecore;

import characters.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Story {
    static String startStory(Player player) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("\t\t\t\t\tMindera Murder Mystery");

        String storyText = """
                \tOne night the detective""" + " " + player.getName() + """
                  was called to a complicated case.
                \tThe police called you to go to Mr. Flavio's house because he had been murdered.
                \tThe police need your help to solve the case:
                \t-All the suspects say they are "innocent" and they can't find any evidence to the contrary;
                \t-Everywhere in the house has been cleaned by the cleaning team ahead of time;
                \t-The police can't find the murder weapon either.
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

    static void goodEnding() {
        System.out.println("\tGraças a ti a policia encontrou o assassino, a arma, e o local do crime.");
    }

    static void badEnding() {
        System.out.println("\tPor tua causa policia prendeu uma pessoa inocente.");
        System.out.println("\tO verdadeiro culpado matou-o na piscina da casa.");
    }
}
