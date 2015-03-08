package com.roylenferink.kleurtjesapp.model;

import android.util.Log;

import java.util.Observable;

/**
 * Created by Roy on 23-2-2015.
 */
public class ColorModel extends Observable {

    private int red, green, blue;

    public ColorModel(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(int r){
        if (red != r){
            if (r < 0){
                red = 0;
            }else if (r > 255){
                red = 255;
            }else{
                red = r;
            }

            setChanged();
            notifyObservers();
        }
    }

    public void setGreen(int g){
        if (green != g){
            if (g < 0){
                green = 0;
            }else if (g > 255){
                green = 255;
            }else{
                green = g;
            }

            setChanged();
            notifyObservers();
        }
    }

    public void setBlue(int b){
        if (blue != b){
            if (b < 0){
                blue = 0;
            }else if (b > 255){
                blue = 255;
            }else{
                blue = b;
            }

            setChanged();
            notifyObservers();
        }
    }

    public int getRed(){
        return this.red;
    }

    public int getGreen(){
        return this.green;
    }

    public int getBlue(){
        return this.blue;
    }

}
