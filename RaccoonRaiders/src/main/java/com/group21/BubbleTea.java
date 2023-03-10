package com.group21;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class BubbleTea extends Items{
    /**
     * Constructor
     */
    public BubbleTea(){
        name = "BubbleTea";
        score = 100;
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
     * @param GamePanel target panel to draw on
     */
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
