package com.group21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SoundTest {

    private Sound sound;
    @BeforeEach
    public void setUp() {sound = new Sound;}
    @Test
    public void fileTest() {assertNotNull(sound.ais);}

}