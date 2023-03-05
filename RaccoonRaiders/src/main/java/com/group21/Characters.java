package com.group21;

public abstract class Characters {
    // Characters' common instance variables
    private double health;
    private double damage;
    private Position position = null;
    private int speed;

    Characters(){
        health = 100;
        damage = 10;
        position = new Position();
        speed = 5;
    }
    
    public double getHealth(){
        return health;
    }

    public double getDamage(){
        return damage;
    }

    public Position getPosition(){
        return position;
    }

    public int getSpeed(){
        return speed;
    }

    public void setHealth(double newHealth){
        health = newHealth;
    }

    public void setDamage(double newDamange){
        damage = newDamange;
    }

    public void setPosition(int x, int y){
        position.setX_position(x);
        position.setY_position(y);
    }

    public void setPosition(Position newPosition){
        position = newPosition;
    }

    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }

    public boolean isDead(){
        if (health <= 0){
            return true;
        }
        return false;
    }
    public abstract void move(Direction dir);
}