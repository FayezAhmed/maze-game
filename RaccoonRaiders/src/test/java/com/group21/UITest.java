package com.group21;

import static org.junit.Assert.*;

import org.junit.BeforeEach;
import org.junit.Test;

public class UITest {

    private UI UI;
    private GamePanel gp;

    @BeforeEach
    public void setUp() {
        gp = new GamePanel();
        UI = new UI(gp);
    }
    @Test
    public void fileTest(){
        assertNotNull(UI.heartImage);
        assertNotNull(UI.titleImage);
        assertNotNull(UI.raccoonImage);
    }

    @Test
    public void DrawTest() {
        UI.draw();//call draw method
        assertEquals(UI.g2.getFont(), UI.retroFont);
        assertEquals(UI.g2.getFont().getStyle(), Font.PLAIN);
        assertEquals(UI.g2.getColor(), Color.gray);
    }

    @Test
    public void GetCenterXTest() {
        // Test a short string
        String shortString = "Test";
        int shortCenterX = ui.getCenterX(shortString);
        assertEquals(528, shortCenterX);

        // Test an empty string
        String emptyString = "";
        int emptyCenterX = ui.getCenterX(emptyString);
        assertEquals(640, emptyCenterX);
    }


}