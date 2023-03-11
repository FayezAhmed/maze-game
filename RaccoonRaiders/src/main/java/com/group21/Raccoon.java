package com.group21;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Raccoon extends Characters{
    
    public Raccoon(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 5;

        getImage();

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
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

}
