package nl.saxion;

import android.app.Application;

import nl.saxion.model.Model;

/**
 * Created by Roy on 31-3-2015.
 */
public class MessageApplication extends Application {

    private Model model;

    @Override
    public void onCreate() {
        this.model = new Model();
        super.onCreate();
    }

    public Model getModel(){
        return this.model;
    }
}
