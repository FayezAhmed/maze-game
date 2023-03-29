package com.group21;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Abstract Items Class
 */
public abstract class Items {

    //Default Variables
    protected BufferedImage image;
    protected String name;
    protected int score;
    protected boolean collision = false;
    protected int xPosition,yPosition;
    protected Rectangle solidArea = new Rectangle(0,0,16,16);
    protected int solidAreaDefaultX = 0;
    protected int solidAreaDefaultY = 0;

    /**
     * Draw onto panel.
     * 
     * @param g2 the Graphics2D object to draw on
     * @param gp target GamePanel to draw on
     */
    public abstract void draw(Graphics2D g2, GamePanel gp);
}
