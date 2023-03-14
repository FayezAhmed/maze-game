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
        gp.rewards[0] = new Coffee();
        gp.rewards[0].x = 20 * gp.tileSize;
        gp.rewards[0].y = 20 * gp.tileSize;

        gp.rewards[1] = new Coffee();
        gp.rewards[1].x = 30 * gp.tileSize;
        gp.rewards[1].y = 10 * gp.tileSize;

        gp.rewards[2] = new BubbleTea();
        gp.rewards[2].x = 13 * gp.tileSize;
        gp.rewards[2].y = 4 * gp.tileSize;

        // gp.items[3] = new Punishment();
        // gp.items[3].x = 21 * gp.tileSize;
        // gp.items[3].y = 9 * gp.tileSize;

        // gp.items[4] = new Punishment();
        // gp.items[4].x = 22 * gp.tileSize;
        // gp.items[4].y = 3 * gp.tileSize;

        // gp.items[5] = new Punishment();
        // gp.items[5].x = 24 * gp.tileSize;
        // gp.items[5].y = 5 * gp.tileSize;

        // gp.items[6] = new Punishment();
        // gp.items[6].x = 25 * gp.tileSize;
        // gp.items[6].y = 8 * gp.tileSize;
    }

    public void setRaccoon() {
        gp.raccoons[0] = new Raccoon(gp);
        gp.raccoons[0].x = gp.tileSize * 35;
        gp.raccoons[0].y = gp.tileSize * 9;
        
    }
}
