package com.roylenferink.kevertjegooien.model;

import java.util.Observable;
import java.util.Random;

/**
 * Created by Roy on 20-3-2015.
 */
public class Dobbelsteen extends Observable {

    private int number;
    private Random r;

    public Dobbelsteen(){
        this.number = 0;
        r = new Random();
    }

    public void rollDice(){
        this.number = r.nextInt(6) + 1;
        setChanged();
        notifyObservers();
    }

    public int getNumber(){
        return this.number;
    }

}
