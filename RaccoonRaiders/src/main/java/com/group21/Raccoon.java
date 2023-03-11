package com.group21;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.*;

public class Raccoon extends Characters{
    
    public Raccoon(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 4;

        getImage();

    }
    
    /**
     * Read the student sprite images 
     */
    public void getImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/raccoon_image/raccoon_right_2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 90) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; // Picks num from 1-100
    
            if (i <= 25) direction = "up";
            if (i > 25 && i <= 50) direction = "down";
            if (i > 50 && i <= 75) direction = "left";
            if (i > 75 && i <= 100) direction = "right";

            actionLockCounter = 0;
        }
    }


    @Override
    public void update() {
        
        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);

        if (collisionOn == false){
            switch(direction){
                case "up": y -= speed;
                    break;
                case "down": y += speed;
                    break;
                case "right": x += speed;
                    break;
                case "left": x -= speed;
                    break;
            }
        }

        spriteCounter++;
        if (spriteCounter > 15){
            if (spriteNumber == 1){
                spriteNumber = 2;
            }
            else if (spriteNumber == 2){
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if (spriteNumber == 1){
                    image = up1;
                }
                if (spriteNumber == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1){
                    image = down1;
                }
                if (spriteNumber == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1){
                    image = left1;
                }
                if (spriteNumber == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1){
                    image = right1;
                }
                if (spriteNumber == 2){
                    image = right2;
                }
                break;
            
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
