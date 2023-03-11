package com.group21;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Abstract Items Class
 */
public abstract class Items {

    //default variables
    public BufferedImage image;
    public String name;
    public int score;
    public boolean collision = false;
    public int x,y;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public abstract void draw(Graphics2D g2, GamePanel gp);
}
