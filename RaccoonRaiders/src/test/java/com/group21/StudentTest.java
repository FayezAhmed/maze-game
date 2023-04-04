package com.group21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private GamePanel gp;
    private Student student;
    private KeyHandler keyHandler;

    @BeforeEach
    public void setUp() {
        gp = new GamePanel();
        keyHandler = new KeyHandler(gp);
        student = new Student(gp, keyHandler);
        student.setDefaultValues();
    }

    // Tests for setting values

    @Test
    public void testSetDefaultValues() {
        assertEquals(7 * student.gp.tileSize, student.xPosition);
        assertEquals(1 * student.gp.tileSize, student.yPosition);
        assertEquals(2, student.speed);
        assertEquals("down", student.direction);
    }

    @Test
    public void testRestoreHealthAndScore() {
        student.heart = 0;
        student.score = -1;
        student.invincible = true;
        student.numCollected = 1;

        student.restoreHealthAndScore();

        assertEquals(1, student.heart);
        assertEquals(0, student.score);
        assertFalse(student.invincible);
        assertEquals(0, student.numCollected);
    }

}    