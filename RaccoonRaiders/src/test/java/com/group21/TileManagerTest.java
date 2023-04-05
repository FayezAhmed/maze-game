package com.group21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TileManagerTest {
    private GamePanel gp;
    private TileManager tm;

    @BeforeEach
    public void setup(){
        gp = new GamePanel();
        tm = new TileManager(gp);
    }

    @Test
    public void mapArrayTest(){
        tm.loadMap();

        assertNotNull(tm.mapArr);
    }

    @Test
    public void imagesTest(){
        for (Tile t : tm.tiles){
            assertNotNull(t);
        }
    }
}