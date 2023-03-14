package com.group21;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;
import java.awt.image.*;

/**
 * Main character -- Student class
 */
public class Student extends Characters {
   
    protected KeyHandler key;

    protected int heart = 3;
    protected boolean flag = false;

    /**
     * Construct new Student
     * @param gp Game Panel
     * @param key KeyHanlder
     */
    public Student(GamePanel gp, KeyHandler key) {
        super(gp);
        this.key = key;

        // hitting area
        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();
        
    }

    /**
     * set character's default value
     */
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "up";
    }

    /**
     * Read the student sprite images 
     */
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/student_image/student_right_2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * update the student's location (status) by interacting with keyboard inputs
     */
    public void update(){
        
        if (key.up == true || key.down == true || key.left == true || key.right == true){
            if (key.up == true && key.down == false && key.left == false && key.right == false){
                direction = "up";
            }
            if (key.up == false && key.down == true && key.left == false && key.right == false){
                direction = "down";
            }
            if (key.up == false && key.down == false && key.left == false && key.right == true){
                direction = "right";
            }
            if (key.up == false && key.down == false && key.left == true && key.right == false){
                direction = "left";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            // rewards collision
            int rewardIndex = gp.cChecker.checkRewards(this, true);
            pickUpRewards(rewardIndex);

            // punishments collision
            int punishmentsIndex = gp.cChecker.checkPunishments(this, true);
            pickUpPunishments(punishmentsIndex);

            // enemy collision
            int enemyIndex = gp.cChecker.checkEntity(this);
            interactEnemy(enemyIndex);

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

        // Keep outside of the main if statement
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    /**
     * picking up the item
     * @param index index of the item on rewards array
     */
    public void pickUpRewards(int index){
        if (index != -1){
            score += gp.rewards[index].score;
            System.out.println(gp.rewards[index].name + " !! Score: " + score);
            gp.rewards[index] = null;
        }
    }

    /**
     * picking up the item
     * @param index index of the item on punishments array
     */
    public void pickUpPunishments(int index){
        if (index != -1){
            score -= gp.punishments[index].score;
            System.out.println(gp.punishments[index].name + " !! Score: " + score);
            gp.punishments[index] = null;
        }
    }
    
    /**
     * touching an enemy
     * @param index index of the item on items array
     */
    public void interactEnemy(int index){
        if (index != -1){
            if (invincible == false) {
                // score = 0;
                heart -= 1;
                System.out.println("You are hitting an enemy!! Score: " + score);
                invincible = true;
            }
        }
    }

    /**
     * Check if all the rewards are collected
     * @return true --> all rewards are collected // false otherwise
     */
    public boolean collectAllChecker(){
        flag = true;
        for (Items i : gp.rewards){
            if ( i != null ) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * draw the student
     * @param g2 Graphic
     */
    public void draw(Graphics2D g2){
        
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

        if (invincible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
    }
}
