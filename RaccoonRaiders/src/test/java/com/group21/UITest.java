package com.group21;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UITest {

    private UI UI;
    private GamePanel gp;

    @Before
    public void setUp() {
        gp = new GamePanel();
        UI = new UI(gp);
    }
    @Test
<<<<<<< HEAD
    public void fileTest(){
        assertNotNull(UI.heartImage);
        assertNotNull(UI.titleImage);
        assertNotNull(UI.raccoonImage);
    }

    @Test
    public void DrawTest() {
        UI.draw();//call draw method
=======
    public void testDrawTitle() {
        UI.drawTitle();
        assertEquals(UI.g2.getFont(), UI.retroFont);
        assertEquals(UI.g2.getFont().getStyle(), Font.PLAIN);
        assertEquals(UI.g2.getFont().getSize(), 100f, 0.1f);
        assertEquals(UI.getCenterX("RACCOON RAIDERS"), 341);
    }

    @Test
    public void testDrawPause() {
        UI.drawPause();
>>>>>>> 65269cc1f004f1a76002cf03266c273c052807aa
        assertEquals(UI.g2.getFont(), UI.retroFont);
        assertEquals(UI.g2.getFont().getStyle(), Font.PLAIN);
        assertEquals(UI.g2.getColor(), Color.gray);
    }

}