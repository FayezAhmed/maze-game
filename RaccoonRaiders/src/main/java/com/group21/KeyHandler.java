package com.group21;

import java.awt.event.*;

/**
 * KeyHanler class -- interact with Students <--> Keyboard input from player
 */


public class KeyHandler implements KeyListener {
    protected GamePanel gp;
    protected boolean up, down, right, left;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if(gp.state == gp.titleState) {
            switch (code){
                case KeyEvent.VK_UP:
                    gp.ui.order--;
                    if(gp.ui.order < 0){
                        gp.ui.order = 1;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    gp.ui.order++;
                    if(gp.ui.order > 1){
                        gp.ui.order = 0;
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if(gp.ui.order == 0){
                        gp.state = gp.gameState;
                        gp.stopMusic();
                        gp.playMusic(0);
                    }
                    if(gp.ui.order == 1){
                        System.exit(0);
                    }
            }
        }

            switch (code) {
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_P:
                    if (gp.state == gp.gameState) {
                        gp.state = gp.pauseState;
                    }
                    else if (gp.state == gp.pauseState) {
                        gp.state = gp.gameState;
                    }
                    break;
            }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code){
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
        }
    }
    
}