package com.roylenferink.kevertjegooien.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.roylenferink.kevertjegooien.model.Kevertje;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 20-3-2015.
 */
public class KevertjeView extends View implements Observer{

    private int body;
    private int sprieten;

    private Paint bodyGrey;
    private Paint pootBlue;
    private Paint sprietRed;

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
        bodyGrey = new Paint();
        bodyGrey.setColor(Color.DKGRAY);
        bodyGrey.setStyle(Paint.Style.FILL);

        pootBlue = new Paint();
        pootBlue.setColor(Color.BLUE);
        pootBlue.setStrokeWidth(50);

        sprietRed = new Paint();
        sprietRed.setColor(Color.RED);
        sprietRed.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.WHITE);

        final float CANVAS_WIDTH = canvas.getWidth();
        final float CANVAS_HEIGHT = canvas.getHeight();

        switch (sprieten){
            case 2:
                canvas.drawLine(CANVAS_WIDTH * 0.6f, CANVAS_HEIGHT * 0.03f, CANVAS_WIDTH * 0.58f, CANVAS_HEIGHT * 0.2f, sprietRed);
            case 1:
                canvas.drawLine(CANVAS_WIDTH * 0.4f, CANVAS_HEIGHT * 0.03f, CANVAS_WIDTH * 0.42f, CANVAS_HEIGHT * 0.2f, sprietRed);
                break;
        }

        switch (body){
            case 8:
                canvas.drawLine(CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.7f, CANVAS_WIDTH * 0.875f, CANVAS_HEIGHT * 0.9f, pootBlue);
            case 7:
                canvas.drawLine(CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.55f, CANVAS_WIDTH * 0.92f, CANVAS_HEIGHT * 0.55f, pootBlue);
            case 6:
                canvas.drawLine(CANVAS_WIDTH * 0.55f, CANVAS_HEIGHT * 0.45f, CANVAS_WIDTH * 0.875f, CANVAS_HEIGHT * 0.25f, pootBlue);
            case 5:
                canvas.drawLine(CANVAS_WIDTH * 0.125f, CANVAS_HEIGHT * 0.9f, CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.7f, pootBlue);
            case 4:
                canvas.drawLine(CANVAS_WIDTH * 0.08f, CANVAS_HEIGHT * 0.55f, CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.55f, pootBlue);
            case 3:
                canvas.drawLine(CANVAS_WIDTH * 0.125f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.45f, CANVAS_HEIGHT * 0.45f, pootBlue);
            case 2:
                canvas.drawCircle(CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.20f, CANVAS_WIDTH * 0.12f, bodyGrey);
            case 1:
                canvas.drawOval(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.9f, bodyGrey);
                break;
        }

    }

    @Override
    public void update(Observable observable, Object data) {
        body = ((Kevertje) observable).getBody();
        sprieten = ((Kevertje) observable).getSprieten();
        invalidate();
    }
}
