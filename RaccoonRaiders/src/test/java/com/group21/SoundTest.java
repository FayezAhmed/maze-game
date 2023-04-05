package com.group21;

import org.junit.Test;
import static org.junit.Assert.*;

public class SoundTest {

    @Test
    public void testPlay() {
        Sound sound = new Sound();
        sound.setFile(0);
        sound.play();
        assertTrue(sound.clip.isRunning());
        sound.stop();
    }

    @Test
    public void testLoop() {
        Sound sound = new Sound();
        sound.setFile(1);
        sound.loop();
        assertTrue(sound.clip.isRunning());
        sound.stop();
    }

    @Test
    public void testStop() {
        Sound sound = new Sound();
        sound.setFile(0);
        sound.play();
        assertTrue(sound.clip.isRunning());
        sound.stop();
        assertFalse(sound.clip.isRunning());
    }
}