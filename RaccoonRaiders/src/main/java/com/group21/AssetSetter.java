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
    }
}
