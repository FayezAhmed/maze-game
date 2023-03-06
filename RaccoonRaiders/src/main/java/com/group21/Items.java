package com.group21;

public abstract class Items {
    
    // Items' common instance variables
    private Position position = null;
    private int rewardValue;

    Items(){
        rewardValue = 0;
    }
    Items(Position pos, int val){
        this.position = pos;
        this.rewardValue = val;
    }

    public Position getPosition(){
        return position;
    }

    public int getRewardValue(){
        return rewardValue;
    }

    public void setPosition(Position pos){
        this.position = pos;
    }

    public void setPosition(int x, int y){
        this.position.setX_position(x);
        this.position.setY_position(y);
    }

    public void setRewardValue(int newVal){
        this.rewardValue = newVal;
    }

}
