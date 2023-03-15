package com.group21;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    // Screen Setting Variables

    protected final int tileSize = 32; // 32*32 tile
    protected final int maxScreenCol = 40;
    protected final int maxScreenRow = 24;

    protected final int screenWidth = tileSize * maxScreenCol;    // 1280 pixels
    protected final int screenHeight = tileSize * maxScreenRow;   // 768 pixels
    
    // FPS
    protected final int FPS = 60;

    protected Thread gameThread;
    protected KeyHandler key = new KeyHandler(this);
    protected Student student = new Student(this, key);
    protected Sound sound = new Sound();
    protected UI ui = new UI (this);
    protected TileManager tm = new TileManager(this);
    protected CollisionChecker cChecker = new CollisionChecker(this);
    protected Pathfinder pFinder = new Pathfinder(this);

    protected Items rewards[] = new Items[10];
    protected Items punishments[] = new Items[10];

    protected AssetSetter setter = new AssetSetter(this);
    protected Characters raccoons[] = new Characters[5];

    protected Portal portal = new Portal();

    //STATE
    protected int state;
    protected final int titleState = 0;
    protected final int gameState = 1;
    protected final int pauseState = 2;
    protected final int gameOverState = 3;
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
        setter.setRaccoon();
        state = titleState;
        playMusic(1);
    }

    /**
     * let Thread start the game
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void retry() {
        student.setDefaultValues();
        student.restoreHealthAndScore();
        setter.setObject();
        setter.setRaccoon();
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
        if(state == gameState) {
            // PLAYER
            student.update();

            //ENEMIES
            for (int i = 0; i < raccoons.length; i++) {
                if (raccoons[i] != null) {
                    raccoons[i].update();
                }
            }
        }
    }

    /**
     * draw the components on the panel
     * @param g Graphic 
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (state == titleState)
        {
            ui.draw(g2);
        }
        else {
            //TITLE
            tm.draw(g2);

            if (!student.collectAllChecker()){
                //rewards
                for (int i = 0; i < rewards.length; i++){
                    if (rewards[i] != null)
                        rewards[i].draw(g2, this);
                }
            }
            else{
                portal.x = 38 * this.tileSize;
                portal.y = 1 * this.tileSize;
                portal.draw(g2, this);
            }
            

            //Punishments
            for (int i = 0; i < rewards.length; i++){
                if (punishments[i] != null)
                punishments[i].draw(g2, this);
            }
            
            //ENEMIES
            for(int i = 0; i < raccoons.length; i++) {
                if (raccoons[i] != null)
                    raccoons[i].draw(g2);
            }

            //UI
            ui.draw(g2);
            
            //PLAYER
            student.draw(g2);
        }
        g2.dispose();   // dispose of this graphics contxt and release any system resources that it is using  
    }
    public void playMusic(int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic()
    {
        sound.stop();
    }


}
