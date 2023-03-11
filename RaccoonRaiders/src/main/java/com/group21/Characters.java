package com.group21;

import java.awt.image.BufferedImage;

import javax.swing.text.html.parser.Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Character class
 */
public abstract class Characters {

    GamePanel gp;

    // Character Variables
    public int x, y;    
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public boolean collisionOn = false;
    public Rectangle solidArea = new Rectangle(0, 0, 32, 32);
    public int score = 0;
    public int actionLockCounter = 0;

    public int solidAreaDefaultX, solidAreaDefaultY;

    public int spriteCounter = 0;
    public int spriteNumber = 1;

    public void setAction() {}

    public abstract void update();
    public abstract void draw(Graphics2D g2);

    public Characters(GamePanel gp) {
        this.gp = gp;
    }
}
