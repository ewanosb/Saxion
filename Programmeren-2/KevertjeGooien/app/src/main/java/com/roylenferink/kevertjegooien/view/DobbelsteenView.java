package com.roylenferink.kevertjegooien.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.roylenferink.kevertjegooien.model.Dobbelsteen;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 20-3-2015.
 */
public class DobbelsteenView extends View implements Observer {

    private int number;

    private Paint black;

    public DobbelsteenView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DobbelsteenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DobbelsteenView(Context context) {
        super(context);
        init();
    }

    private void init(){
        black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(Color.WHITE);

        final float CANVAS_WIDTH = canvas.getWidth();
        final float CANVAS_HEIGHT = canvas.getHeight();

        switch(number){
            case 5:
                canvas.drawCircle(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.09f, black);
                canvas.drawCircle(CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.75f, CANVAS_WIDTH * 0.09f, black);
            case 3:
                canvas.drawCircle(CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.09f, black);
                canvas.drawCircle(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.75f, CANVAS_WIDTH * 0.09f, black);
            case 1:
                canvas.drawCircle(CANVAS_WIDTH * 0.5f, CANVAS_HEIGHT * 0.5f, CANVAS_WIDTH * 0.09f, black);
                break;
            case 6:
                canvas.drawCircle(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.5f, CANVAS_WIDTH * 0.09f, black);
                canvas.drawCircle(CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.5f, CANVAS_WIDTH * 0.09f, black);
            case 4:
                canvas.drawCircle(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.09f, black);
                canvas.drawCircle(CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.75f, CANVAS_WIDTH * 0.09f, black);
            case 2:
                canvas.drawCircle(CANVAS_WIDTH * 0.75f, CANVAS_HEIGHT * 0.25f, CANVAS_WIDTH * 0.09f, black);
                canvas.drawCircle(CANVAS_WIDTH * 0.25f, CANVAS_HEIGHT * 0.75f, CANVAS_WIDTH * 0.09f, black);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        number = ((Dobbelsteen) observable).getNumber();
        invalidate();
    }

}
