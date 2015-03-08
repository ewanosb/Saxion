package com.roylenferink.kleurtjesapp.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.roylenferink.kleurtjesapp.R;
import com.roylenferink.kleurtjesapp.RGBApplication;
import com.roylenferink.kleurtjesapp.model.ColorModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Roy on 23-2-2015.
 */
public class RGBTextView extends LinearLayout implements Observer {

    protected ColorModel model;
    private EditText r, g, b;

    public RGBTextView(Context context) {
        super(context);
        init(context);
    }

    public RGBTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RGBTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rgbtextview, this);

        RGBApplication app = (RGBApplication) getContext().getApplicationContext();
        model = app.getColor();
        model.addObserver(this);

        r = (EditText) findViewById(R.id.etRed);
        g = (EditText) findViewById(R.id.etGreen);
        b = (EditText) findViewById(R.id.etBlue);

        r.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!r.getText().toString().isEmpty() && model.getRed() != Integer.parseInt(r.getText().toString())){
                    model.setRed(Integer.parseInt(r.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        g.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!g.getText().toString().isEmpty() && model.getGreen() != Integer.parseInt(g.getText().toString())){
                    model.setGreen(Integer.parseInt(g.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!b.getText().toString().isEmpty() && model.getBlue() != Integer.parseInt(b.getText().toString())){
                    model.setBlue(Integer.parseInt(b.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void update(Observable observable, Object data) {
        r.setText(model.getRed() + "");
        r.setSelection(String.valueOf(model.getRed()).length());
        g.setText(model.getGreen() + "");
        g.setSelection(String.valueOf(model.getGreen()).length());
        b.setText(model.getBlue() + "");
        b.setSelection(String.valueOf(model.getBlue()).length());
    }
}
