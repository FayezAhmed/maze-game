package com.group21;

/**
 * AssetSetter class
 */
public class AssetSetter {

    GamePanel gp;

    /**
     * Constructor
     * @param gp Game panel to be updated
     */
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    /**
     * set the items location
     */
    public void setObject(){
        gp.items[0] = new Coffee();
        // randomize later
        gp.items[0].x = 20 * gp.tileSize;
        gp.items[0].y = 20 * gp.tileSize;

        gp.items[1] = new Coffee();
        // randomize later
        gp.items[1].x = 30 * gp.tileSize;
        gp.items[1].y = 10 * gp.tileSize;

        gp.items[2] = new BubbleTea();
        // randomize later
        gp.items[2].x = 13 * gp.tileSize;
        gp.items[2].y = 4 * gp.tileSize;

        gp.items[3] = new BubbleTea();
        // randomize later
        gp.items[3].x = 25 * gp.tileSize;
        gp.items[3].y = 14 * gp.tileSize;
    }
}
