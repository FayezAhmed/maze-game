package com.group21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

/**
 * TileManager Class
 */
public class TileManager {

    // Tile Manager default variables
    protected GamePanel gp;
    protected ArrayList<Tile> tiles;  // store types of tile
    protected int mapArr[][]; // store map info

    /**
     * Deafult Constructor
     * @param gp Main GamePanel
     */
    public TileManager(GamePanel gp){
        this.gp = gp;
        tiles = new ArrayList<Tile>();
        mapArr = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    /**
     * Store txt file to <code>mapArr</code>
     */
    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/mapFiles/mapInfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);
                    mapArr[col][row] = num;
                    col++;
                }
                if (col >= gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * store tile 1, tile 2, wall, water images to <code>tiles</code> array
     */
    public void getTileImage(){
        try{
            tiles.add(new Tile());
            tiles.get(0).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/tile1.png"));

            tiles.add(new Tile());
            tiles.get(1).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/tile2.png"));

            tiles.add(new Tile());
            tiles.get(2).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/wall.png"));
            tiles.get(2).collision = true;

            tiles.add(new Tile());
            tiles.get(3).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/water.png"));
            tiles.get(3).collision = true;

            tiles.add(new Tile());
            tiles.get(4).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/bridge.png"));

            tiles.add(new Tile());
            tiles.get(5).image = ImageIO.read(getClass().getResourceAsStream("/tiles_image/tree.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * draw tiles on GamePanel
     * @param g2 Graphics2D
     */
    public void draw(Graphics2D g2){
        // put tiles on the panel
        int col = 0;
        int row = 0;   
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapArr[col][row];

            g2.drawImage(tiles.get(tileNum).image, x,y, gp.tileSize, gp.tileSize, null);
            col++;
            x+=gp.tileSize;
            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+= gp.tileSize;
            }
        }
    }
}
