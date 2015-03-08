package com.roylenferink.kleurtjesapp;

import android.app.Application;
import com.roylenferink.kleurtjesapp.model.ColorModel;

/**
 * Created by Roy on 23-2-2015.
 */
public class RGBApplication extends Application {

    private ColorModel model;

    @Override
    public void onCreate() {
        model = new ColorModel(0,0,0);
        super.onCreate();
    }

    public ColorModel getColor() {
        return this.model;
    }
}
