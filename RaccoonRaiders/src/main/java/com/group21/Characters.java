package com.group21;

public abstract class Characters {
    // Characters' common instance variables
    private double health;
    private double damage;
    private Position position;
    private int speed;

    Characters(){
        health = 100;
        damage = 10;
        position = new Position();
        speed = 5;
    }
}