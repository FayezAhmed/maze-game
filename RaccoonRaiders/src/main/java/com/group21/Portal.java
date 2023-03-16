package com.group21;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Portal {

    protected boolean collision;
    protected BufferedImage p1, p2, p3, p4, p5, p6;
    protected int spriteCounter = 0;
    protected int spriteNumber = 1;
    protected int x, y;
    protected Rectangle solidArea = new Rectangle(39 * 32, 32, 16,16);

    public Portal(){

        collision = true;

        try{
            p1 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals1.png"));
            p2 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals2.png"));
            p3 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals3.png"));
            p4 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals4.png"));
            p5 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals5.png"));
            p6 = ImageIO.read(getClass().getResourceAsStream("/items_image/portals/portals0.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * draw onto panel
     * @param g2 the Graphics2D object to draw on
     * @param gp target panel to draw on
     */
    public void draw(Graphics2D g2, GamePanel gp){

        spriteCounter++;
            if (spriteCounter > 90){
                spriteCounter = 0;
            }
            else if (spriteCounter > 75){
                spriteNumber = 6;
            }
            else if (spriteCounter > 60){
                spriteNumber = 5;
            }
            else if (spriteCounter > 45){
                spriteNumber = 4;
            }
            else if (spriteCounter > 30){
                spriteNumber = 3;
            }
            else if (spriteCounter > 15){
                spriteNumber = 2;
            }
            else{
                spriteNumber = 1;
            }

        BufferedImage image = null;

        switch(spriteNumber){
            case 1:
                image = p1;
                break;
            case 2:
                image = p2;
                break;
            case 3:
                image = p3;
                break;
            case 4:
                image = p4;
                break;  
            case 5:
                image = p5;
                break;  
            case 6:
                image = p6;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

