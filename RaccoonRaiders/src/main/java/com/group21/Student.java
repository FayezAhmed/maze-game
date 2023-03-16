package com.group21;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.awt.image.*;

/**
 * Main character -- Student class
 */
public class Student extends Characters {
   
    protected KeyHandler key;

    protected int heart = 3;            // life
    protected int numCollected = 0;     // number of collected rewards

    /**
     * Construct new Student.
     * 
     * @param gp target GamePanel to draw on
     * @param key KeyHandler
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
     * Sets character's default values.
     */
    public void setDefaultValues(){
        x = 7 * gp.tileSize;
        y = 1 * gp.tileSize;
        speed = 2;
        direction = "down";
    }

    /**
     * Restores the characters values.
     */
    public void restoreHealthAndScore() {
        heart = 3;
        score = 0;
        invincible = false;
        numCollected = 0;
    }

    /**
     * Read the student sprite images. 
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
     * Update the student's location (status) by interacting with keyboard inputs.
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

            // Rewards collision
            int rewardIndex = gp.cChecker.checkRewards(this, true);
            pickUpRewards(rewardIndex);

            // Punishments collision
            int punishmentsIndex = gp.cChecker.checkPunishments(this, true);
            pickUpPunishments(punishmentsIndex);

            // Enemy collision
            int enemyIndex = gp.cChecker.checkEntity(this);
            interactEnemy(enemyIndex);

            if (numCollected == 10){
                gp.cChecker.checkPortal(this, true, gp.portal);
            }
            
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

        // Game over clause
        if (heart <= 0 || score < 0) {
            gp.state = gp.gameOverState;
        }
    }

    /**
     * Increases score when picking up items.
     * 
     * @param index index of the item on rewards array
     */
    public void pickUpRewards(int index){
        if (index != -1){
            score += gp.rewards[index].score;
            System.out.println(gp.rewards[index].name + " !! Score: " + score);

            // Double the speed if bubble tea is collected
            if (gp.rewards[index].name == "BubbleTea")
                speed *= 2;

            gp.rewards[index] = null;
            numCollected++;
        }
    }

    /**
     * Decreases score when picking up items.
     * 
     * @param index index of the item on punishments array
     */
    public void pickUpPunishments(int index){
        if (index != -1){
            score -= gp.punishments[index].score;
            System.out.println(gp.punishments[index].name + " !! Score: " + score);
            gp.punishments[index] = null;
            if (speed > 1) speed -= 1;
        }
    }
    
    /**
     * Decreases player's health when it contacts and enemy.
     * 
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
     * Checks if all the rewards are collected.
     * 
     * @return true if all rewards are collected, false otherwise
     */
    public boolean collectAllChecker(){
        if (numCollected == 10){
            return true;
        }
        return false;
    }

    /**
     * Draw the student
     * 
     * @param g2 Graphics2D object to draw on
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

        // Visualizes that damage was taken
        if (invincible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
    }
}
