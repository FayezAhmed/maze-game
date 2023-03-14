package com.group21;

// import com.sun.xml.internal.ws.addressing.WsaTubeHelper;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_italic;
    public String message = "";
    BufferedImage heartImage;
    public int order = 0;
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
        this.g2 = g2;
        g2.setFont(arial_italic);
        g2.setColor(Color.white);

        // HEART
        g2.drawImage(heartImage, 16, 12,48,48, null);
        g2.drawString("x " + gp.student.heart, 74, 50);

        // Score
        g2.drawString("Score: " + gp.student.score, 16, 100);

        //TITLE STATE
        if(gp.state == gp.titleState)
        {
            drawTitle();
        }
        if(gp.state == gp.gameState)
        {
        }
        if(gp.state == gp.pauseState)
        {
            drawPause();
        }

    }
    public void drawTitle()
    {
        //Background
        g2.setColor(new Color(252,230,201));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        //TITLE
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 120));
        String txt = "RACCOON RAIDERS";
        int x = getCenterX(txt);
        int y = gp.tileSize*9;

        g2.setColor(Color.gray);
        g2.drawString(txt,x+5,y+5);
        g2.setColor(Color.white);
        g2.drawString(txt,x,y);
//        String startTxt = "press Enter to begin";

        //IMAGE OF Character
        x = gp.screenWidth/2 - (gp.tileSize*2) /2 - 380;
        y += gp.tileSize*2 + 60;

        g2.drawImage(gp.student.down2, x,y, gp.tileSize*6, gp.tileSize*6, null);

        //OPTION
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80));
        txt = "NEW GAME";
        x = getCenterX(txt)+150;
        y += gp.tileSize*2;
        g2.drawString(txt,x,y);
        if(order == 0) {
            g2.drawString(">",x-gp.tileSize*3,y);
        }

        txt = "QUIT";
        x = getCenterX(txt)+150;
        y += gp.tileSize*4;
        g2.drawString(txt,x,y);
        if(order == 1) {
            g2.drawString(">",x-gp.tileSize*2 -28,y);
        }




    }

    public void drawPause(){
        String txt = "PAUSE";
        int x = getCenterX(txt);
        int y = gp.screenHeight/2;
        g2.drawString(txt,x,y);
    }
    public int getCenterX (String txt)
    {
        int len = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
        int x = gp.screenWidth/2 - len/2;
        return x;
    }
}
