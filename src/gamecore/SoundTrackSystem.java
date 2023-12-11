package gamecore;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundTrackSystem {
    private Clip clip;

    public void backgroundMusicSurvivalFirst() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        clip = AudioSystem.getClip();
        File file = new File("resources/backgroundMusic.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.loop(10);
        clip.start();
    }

    public void keyboardSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        clip = AudioSystem.getClip();
        File file = new File("resources/keyboardSound.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.loop(10);
        clip.start();
    }


    public void policeSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        clip = AudioSystem.getClip();
        File file = new File("resources/policeWwSound.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.loop(10);
        clip.start();
    }
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.close();
            clip.setFramePosition(0);
            clip = null;
        }
    }
}