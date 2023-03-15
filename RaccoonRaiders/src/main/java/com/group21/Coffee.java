package com.group21;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * Class Coffee -- rewarding scores
 */
public class Coffee extends Items{
    
    /**
     * Constructor
     */
    public Coffee(){
        name = "Coffee";
        score = 50;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items_image/coffee.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

    /**
     * draw onto panel
     * @param g2 Graphic
     * @param gp target panel to draw on
     */
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
