package com.roylenferink.fragmentapp;

import android.app.Application;

import com.roylenferink.fragmentapp.model.Model;

/**
 * Created by Roy on 27-3-2015.
 */
public class FragmentApplication extends Application {

    private Model model;

    @Override
    public void onCreate() {
        super.onCreate();
        this.model = new Model();
    }

    public Model getModel(){
        return this.model;
    }
}
