package com.group21;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    // Screen Setting Variables
    protected final int originalTileSize = 16; // 16*16 tiles
    protected final int scale = 2;    // scaler size

    protected final int tileSize = originalTileSize * scale; // 32*32 tile
    protected final int maxScreenCol = 40;
    protected final int maxScreenRow = 24;

    protected final int screenWidth = tileSize * maxScreenCol;    // 1280 pixels
    protected final int screenHeight = tileSize * maxScreenRow;   // 768 pixels
    
    // FPS
    protected final int FPS = 60;

    // default Position
    int playerX = 100;  // x coordinate
    int playerY = 100;  // y coordinate
    int PlayerS = 5;    // player speed

    Thread gameThread;
    KeyHandler key = new KeyHandler();
    Student student = new Student(this, key);
    TileManager tm = new TileManager(this);
    CollisionChecker cChecker = new CollisionChecker(this);
    Items items[] = new Items[10];
    AssetSetter setter = new AssetSetter(this);

    /**
     * Default Constructor. Creates Game Panel 
     */
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // setup size
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true); // let GamePanel focus to recieve key input
    }

    /**
     * setting up the items on panel
     */
    public void setupGame(){
        setter.setObject();
    }

    /**
     * let Thread start the game
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // game loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
    
        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
                this.update();
                this.repaint();
                delta--;
            }
        }
    }

    /**
     * updates the game
     */
    public void update(){
        student.update(); 
    }

    /**
     * draw the components on the panel
     * @param g Graphic 
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tm.draw(g2);

        for (int i = 0; i < items.length; i++){
            if (items[i] != null)
                items[i].draw(g2, this);
        }
        student.draw(g2);

        g2.dispose();   // dispose of this graphics contxt and release any system resources that it is using    }
    }
}
