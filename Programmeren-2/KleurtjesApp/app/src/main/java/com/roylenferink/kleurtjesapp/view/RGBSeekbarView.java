package com.roylenferink.kleurtjesapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.roylenferink.kleurtjesapp.R;
import com.roylenferink.kleurtjesapp.RGBApplication;
import com.roylenferink.kleurtjesapp.model.ColorModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 23-2-2015.
 */
public class RGBSeekbarView extends LinearLayout implements Observer{
    protected ColorModel model;
    private SeekBar r, g, b;

    public RGBSeekbarView(Context context) {
        super(context);
        init(context);
    }

    public RGBSeekbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RGBSeekbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rgbsliderview, this);

        r = (SeekBar) findViewById(R.id.sbRed);
        g = (SeekBar) findViewById(R.id.sbGreen);
        b = (SeekBar) findViewById(R.id.sbBlue);

        SeekBarChangeListener listener = new SeekBarChangeListener();

        r.setOnSeekBarChangeListener(listener);
        g.setOnSeekBarChangeListener(listener);
        b.setOnSeekBarChangeListener(listener);

        RGBApplication app = (RGBApplication) getContext().getApplicationContext();
        model = app.getColor();
        model.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        r.setProgress(model.getRed());
        g.setProgress(model.getGreen());
        b.setProgress(model.getBlue());
    }

    private class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (!fromUser){
                return;
            }

            if (seekBar == r){
                model.setRed(progress);
            }else if (seekBar == g){
                model.setGreen(progress);
            }else{
                model.setBlue(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
