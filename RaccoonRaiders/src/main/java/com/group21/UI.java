package com.group21;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {

    GamePanel gp;
    Font arial_italic;
    BufferedImage heartImage;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_italic = new Font("Arial", Font.ITALIC,40);
        //create health heart
        try {
            heartImage = ImageIO.read(getClass().getResourceAsStream("/UI_image/heart.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_italic);
        g2.setColor(Color.white);
        g2.drawImage(heartImage, 16, 12,48,48, null);
        g2.drawString("x " + gp.student.heart, 74, 50);

    }
}
