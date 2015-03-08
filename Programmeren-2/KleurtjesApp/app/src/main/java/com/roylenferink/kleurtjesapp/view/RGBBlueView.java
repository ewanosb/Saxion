package com.roylenferink.kleurtjesapp.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.roylenferink.kleurtjesapp.RGBApplication;
import com.roylenferink.kleurtjesapp.model.ColorModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 23-2-2015.
 */
public class RGBBlueView extends View implements Observer {
    private ColorModel model;

    public RGBBlueView(Context context) {
        super(context);
        init();
    }

    public RGBBlueView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RGBBlueView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        RGBApplication app = (RGBApplication) getContext().getApplicationContext();
        model = app.getColor();
        model.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        setBackgroundColor(Color.rgb(0, 0, model.getBlue()));
    }
}
