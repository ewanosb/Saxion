package com.roylenferink.kevertjegooien.model;

import android.util.Log;

import java.util.Observable;

/**
 * Created by Roy on 20-3-2015.
 */
public class Kevertje extends Observable {

    private int poot;
    private int sprieten;

    public Kevertje(){
        this.poot = 0;
        this.sprieten = 0;
    }

    public void addPoot(){
        if (this.poot < 6){
            this.poot++;
        }
    }

    public void addSpriet(){
        if (this.sprieten < 2){
            this.sprieten++;
        }
    }

    public int getPoot(){
        return this.poot;
    }

    public int getSprieten(){
        return this.sprieten;
    }

}
