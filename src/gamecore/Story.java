package gamecore;

import characters.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Story {
    static String startStory(Player player) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("\t\t\t\t\tMindera Murder Mystery");

        String storyText = """
                \tNuma noite o detetive""" + " " + player.getName() + """
                  foi chamado para um caso complicado.
                \tA policia ligou-lhe para ir a casa do Sr Flávio pois o mesmo foi assassinado.
                \tA policia precisa da sua ajuda para resolver o caso pois:
                \t-Todos os suspeitos se dizem "inocentes" e não encontram provas em contrario;
                \t-Todos os lugares da casa foram limpos pela equipa de limpeza antes do tempo;
                \t-A policia também não consegue encontrar a arma do crime.
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
