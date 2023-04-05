package com.group21;

import org.junit.jupiter.api.*;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.*;

class SoundTest {

    private Sound sound;

    @BeforeEach
    void setUp() {
        sound = new Sound();
        sound.initializeSoundURL();
    }

    @Test
    void testInitializeSoundURL() {
        assertNotNull(sound.soundURL);
        assertEquals(2, sound.soundURL.length);
    }

    @Test
    void testSetFile() {
        sound.setFile(0);
        assertNotNull(sound.clip);
        assertTrue(sound.clip instanceof Clip);
        assertFalse(sound.clip.isRunning());
    }

    @Test
    void testStop() {
        sound.setFile(0);
        sound.play();
        sound.stop();
        assertFalse(sound.clip.isRunning());
    }

}
