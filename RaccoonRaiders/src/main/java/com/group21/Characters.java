package com.group21;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Character class
 */
public abstract class Characters {

    protected GamePanel gp;

    // Character Variables
    protected int x, y;    
    protected int speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    protected String direction;
    protected boolean collisionOn = false;
    protected Rectangle solidArea = new Rectangle(0, 0, 32, 32);
    protected int score = 0;
    protected int actionLockCounter = 0;
    protected boolean invincible = false;
    protected int invincibleCounter = 0;
    protected int type; // 0 = player, 1 = enemy
    protected String directory;

    protected int solidAreaDefaultX, solidAreaDefaultY;

    protected int spriteCounter = 0;
    protected int spriteNumber = 1;

    /**
     * Constructor.
     *
     * @param gp target GamePanel to be updated
     */
    public Characters(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Read the character's sprite images.
     */
    public void getImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream(directory + "_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(directory + "_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream(directory + "_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(directory + "_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream(directory + "_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(directory + "_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream(directory + "_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(directory + "_right_2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Sets the actions of characters.
     */
    public void setAction() {
        actionLockCounter++;
    
        if (actionLockCounter == 90) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; // Picks num from 1-100
    
            if (i <= 25) direction = "up";
            if (i > 25 && i <= 50) direction = "down";
            if (i > 50 && i <= 75) direction = "left";
            if (i > 75 && i <= 100) direction = "right";

            actionLockCounter = 0;
        }
    }
    
    /**
     * Updates characters.
     */
    public abstract void update();
    
    /**
     * Draw onto panel.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public abstract void draw(Graphics2D g2);
}
