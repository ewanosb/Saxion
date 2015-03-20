package com.roylenferink.kevertjegooien;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.roylenferink.kevertjegooien.model.Dobbelsteen;
import com.roylenferink.kevertjegooien.model.Kevertje;

import java.util.Observer;


public class MainActivity extends Activity {

    private Button btGooi;
    private Dobbelsteen dobbelsteen1, dobbelsteen2, dobbelsteen3;
    private Kevertje kevertje;
    private int valueDice1, valueDice2, valueDice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kevertje = new Kevertje();

        dobbelsteen1 = new Dobbelsteen();
        dobbelsteen2 = new Dobbelsteen();
        dobbelsteen3 = new Dobbelsteen();

        dobbelsteen1.addObserver((Observer) findViewById(R.id.vwDobbelsteen1));
        dobbelsteen2.addObserver((Observer) findViewById(R.id.vwDobbelsteen2));
        dobbelsteen3.addObserver((Observer) findViewById(R.id.vwDobbelsteen3));

        dobbelsteen1.rollDice();
        dobbelsteen2.rollDice();
        dobbelsteen3.rollDice();

        btGooi = (Button) findViewById(R.id.btGooiDobbelsteen);
        btGooi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobbelsteen1.rollDice();
                dobbelsteen2.rollDice();
                dobbelsteen3.rollDice();

                valueDice1 = dobbelsteen1.getNumber();
                valueDice2 = dobbelsteen2.getNumber();
                valueDice3 = dobbelsteen3.getNumber();

                if ((valueDice1 == 6 && valueDice2 == 6) ||
                        (valueDice1 == 6 && valueDice3 == 6) ||
                        (valueDice2 == 6 && valueDice3 == 6)){
                    kevertje.addSpriet();
                }else if((valueDice1 == (valueDice2 - 1) && valueDice2 == (valueDice3 - 1)) ||
                        (valueDice1 == (valueDice2 + 1) && valueDice2 == (valueDice3 + 1))){
                    kevertje.addPoot();
                }

            }
        });

    }

}
