package com.roylenferink.kevertjegooien.model;

import java.util.Observable;

/**
 * Created by Roy on 20-3-2015.
 */
public class Kevertje extends Observable {

    private int body;
    private int sprieten;

    public Kevertje(){
        this.body = 0;
        this.sprieten = 0;
    }

    public void addStepToBody(){
        if (this.body < 8){
            this.body++;
        }
        setChanged();
        notifyObservers();
    }

    public void addSpriet(){
        if (this.sprieten < 2 && this.body >= 2){
            this.sprieten++;
        }
        setChanged();
        notifyObservers();
    }

    public int getBody(){
        return this.body;
    }

    public int getSprieten(){
        return this.sprieten;
    }

}
