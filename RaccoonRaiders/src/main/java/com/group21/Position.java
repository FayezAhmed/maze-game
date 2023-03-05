package com.group21;

public class Position {
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Default Constructor, initialize x = 0, and y = 0
     */
    Position(){
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    /**
     * Constructor, initialize x, y with given
     * @param initX initial x position
     * @param initY initial y position
     */
    Position(int initX, int initY){
        this.xCoordinate = initX;
        this.yCoordinate = initY;
    }

    /**
     * get the current x position
     * @return the current x position
     */
    public int getX_position(){
        return xCoordinate;
    }

    /**
     * get the current y position
     * @return
     */
    public int getY_position(){
        return yCoordinate;
    }

    /**
     * update the new x position
     * @param newX new x position to be updated
     */
    public void setX_position(int newX){
        this.xCoordinate = newX;
    }

    /**
     * update the new y position
     * @param newY new y position to be updated
     */
    public void setY_position(int newY){
        this.yCoordinate = newY;
    }

    /**
     * increase the x by the amount of speed's value
     * @param speed the amount that how far can move at once
     */
    public void incX(int speed){
        this.xCoordinate += speed;
    }

    /**
     * increase the y by the amount of speed's value 
     * @param speed the amount that how far can move at once
     */
    public void incY(int speed){
        this.yCoordinate += speed;
    }

    /**
     * decrease the x by the amount of speed's value
     * @param speed the amount that how far can move at once
     */
    public void decX(int speed){
        this.xCoordinate -= speed;
    }

    /**
     * decrease the y by the amount of speed's value
     * @param speed the amount that how far can move at once
     */
    public void decY(int speed){
        this.yCoordinate -= speed;
    }
}