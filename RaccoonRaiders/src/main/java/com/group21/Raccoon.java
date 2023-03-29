package com.group21;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.*;
/**
 * Main enemy character -- Raccoon class
 */
public class Raccoon extends Characters{

    /**
     * Constructor.
     * 
     * @param gp the GamePanel to be updated
     */
    public Raccoon(GamePanel gp) {
        super(gp);

        type = 1;
        direction = "down";
        speed = 2;
        directory = "/raccoon_image/raccoon";
        
        // hitting area
        solidArea = new Rectangle(5, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    /**
     * Triggers the pathfinding algorithm on the raccoons.
     */
    public void setAction() {
        int goalCol = (gp.student.x + gp.student.solidArea.x) / gp.tileSize;
        int goalRow = (gp.student.y + gp.student.solidArea.y) / gp.tileSize;

        searchPath(goalCol, goalRow);
    }

    /**
     * Searches for the shortest path to player.
     * 
     * @param goalCol goal column
     * @param goalRow goal row
     */
    public void searchPath(int goalCol, int goalRow) {

        int startCol = (x + solidArea.x)/gp.tileSize;
        int startRow = (y + solidArea.y)/gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

        if(gp.pFinder.search() == true) {

            // next x and y
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            // enemies solidarea positions
            int enLeftX = x + solidArea.x;
            int enRightX = x + solidArea.x + solidArea.width;
            int enTopY = y + solidArea.y;
            int enBottomY = y + solidArea.y + solidArea.height;

            if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "up";
            }
            else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            }
            else if (enTopY >= nextY && enBottomY <= nextY + gp.tileSize) {
                // left or right
                if (enLeftX > nextX) {
                    direction = "left";
                }
                if (enLeftX < nextX) {
                    direction = "right";
                }
            }
            else if (enTopY > nextY && enLeftX > nextX) {
                // up or left
                direction = "up";
                checkCollision();
                if(collisionOn == true) {
                    direction = "left";
                }
            }
            else if (enTopY > nextY && enLeftX < nextX) {
                // up or right
                direction = "up";
                checkCollision();
                if(collisionOn == true) {
                    direction = "right";
                }
                
            }
            else if (enTopY < nextY && enLeftX > nextX) {
                // down or left
                direction = "down";
                checkCollision();
                if(collisionOn == true) {
                    direction = "left";
                }
            }
            else if (enTopY < nextY && enLeftX < nextX) {
                // down or right
                direction = "down";
                checkCollision();
                if(collisionOn == true) {
                    direction = "right";
                }
            }
        }
    }

    /**
     * Damages player if raccoon contacts enemy.
     */
    public void checkCollision() {
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkRewards(this, false);
        boolean touchPlayer = gp.cChecker.checkPlayer(this);

        if (this.type == 1 && touchPlayer == true) {
            if (gp.student.invincible == false) {
                // gp.student.score = 0;
                gp.student.heart -= 1;
                System.out.println("Enemy is hitting you!! Score: " + gp.student.score);
                gp.student.invincible = true;
            }
        }
    }

    @Override
    public void update() {
        
        setAction();
        checkCollision();

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
