package com.group21;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    // Screen Setting Variables
    protected final int originalTileSize = 16; // 16*16 tiles
    protected final int scale = 2;    // scaler size

    protected final int tileSize = originalTileSize * scale; // 32*32 tile
    protected final int maxScreenCol = 40;
    protected final int maxScreenRow = 24;

    protected final int screenWidth = tileSize * maxScreenCol;    // 1280 pixels
    protected final int screenHeight = tileSize * maxScreenRow;   // 768 pixels
    
    // FPS
    protected final int FPS = 60;

    // default Position
    int playerX = 100;  // x coordinate
    int playerY = 100;  // y coordinate
    int PlayerS = 5;    // player speed

    /**
     * Default Constructor. Creates Game Panel 
     */
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // setup size
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    /**
     * updates the game
     */
    public void update(){

    }

    /**
     * draw the components on the panel
     * @param g Graphic 
     */
    public void printComponent(Graphics g){

    }

    @Override
    public void run() {
        
    }
    
}
