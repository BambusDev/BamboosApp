package com.bambusarmy.bamboosapp;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TickTack extends AppCompatActivity {
    ImageButton nullnull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_tack);
        nullnull = (ImageButton)findViewById(R.id.nullnull);
        nullnull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nullnull.setBackgroundResource(R.drawable.bambus);
            }
        });
    }
}
