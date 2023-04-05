package com.group21;

import static org.junit.Assert.*;

import java.awt.Font;
import java.awt.Graphics2D;

import org.junit.Before;
import org.junit.Test;

public class UITest {

    private UI UI;

    @Before
    public void setUp() {
        GamePanel gp = new GamePanel();
        UI = new UI(gp);
    }

    @Test
    public void testDrawTitle() {
        Graphics2D g2 = null; // You can mock the Graphics2D object if necessary
        UI.drawTitle();
        assertEquals(UI.g2.getFont(), UI.retroFont);
        assertEquals(UI.g2.getFont().getStyle(), Font.PLAIN);
        assertEquals(UI.g2.getFont().getSize(), 100f, 0.1f);
        assertEquals(UI.getCenterX("RACCOON RAIDERS"), 341);
    }

    @Test
    public void testDrawPause() {
        Graphics2D g2 = null; // You can mock the Graphics2D object if necessary
        UI.drawPause();
        assertEquals(UI.g2.getFont(), UI.retroFont);
        assertEquals(UI.g2.getFont().getStyle(), Font.PLAIN);
        assertEquals(UI.g2.getFont().getSize(), 150f, 0.1f);
        assertEquals(UI.getCenterX("PAUSED"), 395);
    }

    @Test
    public void testDraw() {
        Graphics2D g2 = null; // You can mock the Graphics2D object if necessary
        UI.draw(g2);
        // Add more assertions if necessary
    }

}