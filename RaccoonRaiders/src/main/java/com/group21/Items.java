package com.group21;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Abstract Items Class
 */
public abstract class Items {

    //default variables
    protected BufferedImage image;
    protected String name;
    protected int score;
    protected boolean collision = false;
    protected int x,y;
    protected Rectangle solidArea = new Rectangle(0,0,48,48);
    protected int solidAreaDefaultX = 0;
    protected int solidAreaDefaultY = 0;

    public abstract void draw(Graphics2D g2, GamePanel gp);
}
