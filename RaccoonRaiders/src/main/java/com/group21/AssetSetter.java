package com.group21;

/**
 * AssetSetter class
 */
public class AssetSetter {

    private GamePanel gp;

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
        gp.rewards[0].x = 1 * gp.tileSize;
        gp.rewards[0].y = 22 * gp.tileSize;

        gp.rewards[1] = new Coffee();
        gp.rewards[1].x = 1 * gp.tileSize;
        gp.rewards[1].y = 7 * gp.tileSize;

        gp.rewards[2] = new Coffee();
        gp.rewards[2].x = 23 * gp.tileSize;
        gp.rewards[2].y = 3 * gp.tileSize;

        gp.rewards[3] = new Coffee();
        gp.rewards[3].x = 11 * gp.tileSize;
        gp.rewards[3].y = 1 * gp.tileSize;

        gp.rewards[4] = new Coffee();
        gp.rewards[4].x = 8 * gp.tileSize;
        gp.rewards[4].y = 13 * gp.tileSize;

        gp.rewards[5] = new Coffee();
        gp.rewards[5].x = 25 * gp.tileSize;
        gp.rewards[5].y = 16 * gp.tileSize;

        gp.rewards[6] = new Coffee();
        gp.rewards[6].x = 36 * gp.tileSize;
        gp.rewards[6].y = 12 * gp.tileSize;

        gp.rewards[7] = new Coffee();
        gp.rewards[7].x = 13 * gp.tileSize;
        gp.rewards[7].y = 14 * gp.tileSize;

        gp.rewards[8] = new Coffee();
        gp.rewards[8].x = 24 * gp.tileSize;
        gp.rewards[8].y = 11 * gp.tileSize;

        gp.rewards[9] = new BubbleTea();
        gp.rewards[9].x = 15 * gp.tileSize;
        gp.rewards[9].y = 22 * gp.tileSize;

        //set up punishments
        gp.punishments[0] = new Punishment();
        gp.punishments[0].x = 5 * gp.tileSize;
        gp.punishments[0].y = 6 * gp.tileSize;

        gp.punishments[1] = new Punishment();
        gp.punishments[1].x = 12 * gp.tileSize;
        gp.punishments[1].y = 8 * gp.tileSize;

        gp.punishments[2] = new Punishment();
        gp.punishments[2].x = 16 * gp.tileSize;
        gp.punishments[2].y = 20 * gp.tileSize;

        gp.punishments[3] = new Punishment();
        gp.punishments[3].x = 21 * gp.tileSize;
        gp.punishments[3].y = 16 * gp.tileSize;

        gp.punishments[4] = new Punishment();
        gp.punishments[4].x = 30 * gp.tileSize;
        gp.punishments[4].y = 19 * gp.tileSize;

        gp.punishments[5] = new Punishment();
        gp.punishments[5].x = 36 * gp.tileSize;
        gp.punishments[5].y = 15 * gp.tileSize;

        gp.punishments[6] = new Punishment();
        gp.punishments[6].x = 38 * gp.tileSize;
        gp.punishments[6].y = 6 * gp.tileSize;

        gp.punishments[7] = new Punishment();
        gp.punishments[7].x = 8 * gp.tileSize;
        gp.punishments[7].y = 18 * gp.tileSize;

        gp.punishments[8] = new Punishment();
        gp.punishments[8].x = 10 * gp.tileSize;
        gp.punishments[8].y = 20 * gp.tileSize;

        gp.punishments[9] = new Punishment();
        gp.punishments[9].x = 13 * gp.tileSize;
        gp.punishments[9].y = 21 * gp.tileSize;
    }

    public void setRaccoon() {
        gp.raccoons[0] = new Raccoon(gp);
        gp.raccoons[0].x = gp.tileSize * 35;
        gp.raccoons[0].y = gp.tileSize * 9;
        
        gp.raccoons[1] = new Raccoon(gp);
        gp.raccoons[1].x = gp.tileSize * 14;
        gp.raccoons[1].y = gp.tileSize * 18;

        gp.raccoons[2] = new Raccoon(gp);
        gp.raccoons[2].x = gp.tileSize * 20;
        gp.raccoons[2].y = gp.tileSize * 5;
    }
}
