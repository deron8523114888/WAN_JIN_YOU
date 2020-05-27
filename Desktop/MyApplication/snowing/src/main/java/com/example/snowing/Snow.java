package com.example.snowing;

import java.util.Random;

public class Snow extends Thread{

    int x ;
    int y ;
    Random random = new Random();


    public Snow(int x , int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public void run() {





    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }


}
