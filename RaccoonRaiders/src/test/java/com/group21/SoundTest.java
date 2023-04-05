package com.group21;

import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SoundTest {
    @Before
    private Sound sound;

    public void setUp() {sound = new Sound;}
    @Test
    public void fileTest() {assertNotNull(sound.ais);}

}