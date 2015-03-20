package com.roylenferink.kevertjegooien.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.roylenferink.kevertjegooien.model.Dobbelsteen;
import com.roylenferink.kevertjegooien.model.Kevertje;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 20-3-2015.
 */
public class KevertjeView extends View implements Observer{

    private int poten;
    private int sprieten;

    public KevertjeView(Context context) {
        super(context);
        init();
    }

    public KevertjeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KevertjeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.WHITE);
    }

    @Override
    public void update(Observable observable, Object data) {
        poten = ((Kevertje) observable).getPoot();
        sprieten = ((Kevertje) observable).getSprieten();
        invalidate();
    }
}
