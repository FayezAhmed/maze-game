package com.group21;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * The Sound class provides methods for Sound control.
 */
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound()
    {
        soundURL[0] = getClass().getResource("/sound/MainBG.wav");
        soundURL[1] = getClass().getResource("/sound/Title.wav");
//        soundURL[2] = getClass().getResource("/sound/MainBG.mp3");
//        soundURL[3] = getClass().getResource("/sound/MainBG.mp3");
    }
    /**
     * Select the music file input stream.
     *
     * @param i index of different music paths.
     */
    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
