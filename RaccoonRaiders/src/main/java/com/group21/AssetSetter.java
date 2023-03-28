package com.group21;

/**
 * AssetSetter class
 * Setting rewareds, punishments, and raccoons onto GamePanel
 */

public class AssetSetter {

  private GamePanel gp;

  /**
   * Constructor.
   *
   * @param gp Game panel to be updated
   */
  public AssetSetter(GamePanel gp) { this.gp = gp; }

  /**
   * Sets the items locations.
   */
  public void setObject() {

    int Xarrs[] = {1, 1, 23, 11, 8, 35, 36, 13, 24, 15};
    int Yarrs[] = {22, 7, 3, 1, 13, 16, 12, 14, 11, 22};

    for (int i = 0; i < 10; i++) {
      gp.rewards[i] = new Coffee();
      gp.rewards[i].x = Xarrs[i] * gp.tileSize;
      gp.rewards[i].y = Yarrs[i] * gp.tileSize;
    }

    // set up punishments
    int Xarrs2[] = {5, 12, 16, 21, 30, 36, 38, 8, 10, 13};
    int Yarrs2[] = {6, 8, 20, 16, 19, 15, 6, 18, 20, 21};

    for (int i = 0; i < 10; i++) {
      gp.rewards[i] = new Punishment();
      gp.rewards[i].x = Xarrs2[i] * gp.tileSize;
      gp.rewards[i].y = Yarrs2[i] * gp.tileSize;
    }
  }

  /**
   * Set the Raccoons locations.
   */
  public void setRaccoon() {
    int Xarrs[] = {35, 14, 20};
    int Yarrs[] = {9, 18, 5};

    for (int i = 0; i < 10; i++) {
      gp.rewards[i] = new Raccoon();
      gp.rewards[i].x = Xarrs[i] * gp.tileSize;
      gp.rewards[i].y = Yarrs[i] * gp.tileSize;
    }
  }
}
