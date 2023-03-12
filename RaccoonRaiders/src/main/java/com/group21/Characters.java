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
    protected int x, y;    
    protected int speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    protected String direction;
    protected boolean collisionOn = false;
    protected Rectangle solidArea = new Rectangle(0, 0, 32, 32);
    protected int score = 0;
    protected int actionLockCounter = 0;

    protected int solidAreaDefaultX, solidAreaDefaultY;

    protected int spriteCounter = 0;
    protected int spriteNumber = 1;

    public Characters(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {}
    public abstract void update();
    public abstract void draw(Graphics2D g2);
}
