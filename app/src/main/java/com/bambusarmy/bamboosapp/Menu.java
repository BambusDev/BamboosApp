package com.bambusarmy.bamboosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button playClicker;
    Button openFlashlight;
    Button playTickTack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        playClicker = (Button)findViewById(R.id.PandaClicker);
        playClicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Clicker.class));
            }
        });

        openFlashlight = (Button)findViewById(R.id.FlashlightBTN);
        openFlashlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Flashlight.class));
            }
        });
        playTickTack = (Button)findViewById(R.id.TickTackBTN);
        playTickTack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,TickTack.class));
            }
        });
    }
}
