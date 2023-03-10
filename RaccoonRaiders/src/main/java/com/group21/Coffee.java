package com.group21;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class Coffee extends Items{
    
    public Coffee(){

        name = "Coffee";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items_image/coffee.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
