package com.roylenferink.contactlist;

import android.app.Application;

import com.roylenferink.contactlist.model.Model;

/**
 * Created by Roy on 8-3-2015.
 */
public class ContactApplication extends Application {

    private Model model;

    @Override
    public void onCreate() {
        model = new Model();
        super.onCreate();
    }

    public Model getModel(){
        return this.model;
    }

}
