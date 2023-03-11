package com.group21;

import javax.swing.text.html.parser.Entity;

/**
 * CollisionChecker class
 */
public class CollisionChecker {

    GamePanel gp;

    /**
     * Constructor
     * @param gp Game Panel that is affected
     */
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    /**
     * check the tile if wall or water, character cannot go forward
     * @param entity
     */
    public void checkTile(Characters entity){
        int left = entity.x + entity.solidArea.x;
        int right = entity.x - entity.solidArea.x + entity.solidArea.width;
        int top = entity.y + entity.solidArea.y;
        int bot = entity.y - entity.solidArea.y + entity.solidArea.height + 10;

        int leftCol = left/gp.tileSize;
        int rightCol = right/gp.tileSize;
        int topRow = top/gp.tileSize;
        int botRow = bot/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                topRow = (top - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapArr[leftCol][topRow];
                tileNum2 = gp.tm.mapArr[rightCol][topRow];
                if (gp.tm.tiles.get(tileNum1).collision == true || gp.tm.tiles.get(tileNum2).collision == true || top-10 < 0){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                botRow = (bot + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapArr[leftCol][botRow];
                tileNum2 = gp.tm.mapArr[rightCol][botRow];
                if (gp.tm.tiles.get(tileNum1).collision == true || gp.tm.tiles.get(tileNum2).collision == true || bot+10 > gp.screenHeight){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                leftCol = (left - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapArr[leftCol][topRow];
                tileNum2 = gp.tm.mapArr[leftCol][botRow];
                if (gp.tm.tiles.get(tileNum1).collision == true || gp.tm.tiles.get(tileNum2).collision == true || left-5 < 0){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                rightCol = (right + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapArr[rightCol][topRow];
                tileNum2 = gp.tm.mapArr[rightCol][botRow];
                if (gp.tm.tiles.get(tileNum1).collision == true || gp.tm.tiles.get(tileNum2).collision == true || right+10 > gp.screenWidth){
                    entity.collisionOn = true;
                }
                break;
        }
    }

    /**
     * checks the collision with items and return the index of item
     * @param stu student
     * @param isStudent true if student, false otherwise
     * @return index of item
     */
    public int checkObject(Characters stu, boolean isStudent){
        int index = -1;

        for (int i = 0; i < gp.items.length; i++){
            if (gp.items[i] != null){
                // get character's solid area position
                stu.solidArea.x = stu.x + stu.solidArea.x;
                stu.solidArea.y = stu.y + stu.solidArea.y;

                // get the imtem's solid area position
                gp.items[i].solidArea.x = gp.items[i].x + gp.items[i].solidArea.x;
                gp.items[i].solidArea.y = gp.items[i].y + gp.items[i].solidArea.y;
            
                switch(stu.direction){
                    case "up":
                        stu.solidArea.y -= stu.speed;
                        if (stu.solidArea.intersects(gp.items[i].solidArea)){
                            if (gp.items[i].collision == true){
                                stu.collisionOn = true;
                            }
                            if (isStudent == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        stu.solidArea.y += stu.speed;
                        if (stu.solidArea.intersects(gp.items[i].solidArea)){
                            if (gp.items[i].collision == true){
                                stu.collisionOn = true;
                            }
                            if (isStudent == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        stu.solidArea.x -= stu.speed;
                        if (stu.solidArea.intersects(gp.items[i].solidArea)){
                            if (gp.items[i].collision == true){
                                stu.collisionOn = true;
                            }
                            if (isStudent == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        stu.solidArea.x += stu.speed;
                        if (stu.solidArea.intersects(gp.items[i].solidArea)){
                            if (gp.items[i].collision == true){
                                stu.collisionOn = true;
                            }
                            if (isStudent == true){
                                index = i;
                            }
                        }
                        break;
                }
                stu.solidArea.x = stu.solidAreaDefaultX;
                stu.solidArea.y = stu.solidAreaDefaultY;
                gp.items[i].solidArea.x = gp.items[i].solidAreaDefaultX;
                gp.items[i].solidArea.y = gp.items[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * checks the collision if player contacts enemy
     * @param stu student
     * @return index of enemy
     */
    public int checkEntity(Characters stu) {
        int index = -1;

        for (int i = 0; i < gp.raccoons.length; i++){
            if (gp.raccoons[i] != null){
                // get character's solid area position
                stu.solidArea.x = stu.x + stu.solidArea.x;
                stu.solidArea.y = stu.y + stu.solidArea.y;

                // get the imtem's solid area position
                gp.raccoons[i].solidArea.x = gp.raccoons[i].x + gp.raccoons[i].solidArea.x;
                gp.raccoons[i].solidArea.y = gp.raccoons[i].y + gp.raccoons[i].solidArea.y;
            
                switch(stu.direction){
                    case "up":
                        stu.solidArea.y -= stu.speed;
                        if (stu.solidArea.intersects(gp.raccoons[i].solidArea)){
                            stu.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        stu.solidArea.y += stu.speed;
                        if (stu.solidArea.intersects(gp.raccoons[i].solidArea)){
                            stu.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        stu.solidArea.x -= stu.speed;
                        if (stu.solidArea.intersects(gp.raccoons[i].solidArea)){
                            stu.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        stu.solidArea.x += stu.speed;
                        if (stu.solidArea.intersects(gp.raccoons[i].solidArea)){
                            stu.collisionOn = true;
                            index = i;
                        }
                        break;
                }
                stu.solidArea.x = stu.solidAreaDefaultX;
                stu.solidArea.y = stu.solidAreaDefaultY;
                gp.raccoons[i].solidArea.x = gp.raccoons[i].solidAreaDefaultX;
                gp.raccoons[i].solidArea.y = gp.raccoons[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
