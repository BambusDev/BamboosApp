package com.bambusarmy.bamboosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Clicker extends AppCompatActivity {
    ImageButton clicker;
    ImageButton back;
    TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
        SharedPreferences SPR = getSharedPreferences("number",0);
        clicker = (ImageButton)findViewById(R.id.ClickerBTN);
        back = (ImageButton)findViewById(R.id.MenuBTN);
        number = (TextView)findViewById(R.id.number);
        number.setText(SPR.getString("Key","0"));

        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue = number.getText().toString();
                int counter = Integer.parseInt(countValue);
                counter++;
                number.setText(String.valueOf(counter));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Clicker.this,Menu.class));
            }
        });
    }
    protected void onStop(){
        super.onStop();
        SharedPreferences SPR = getSharedPreferences("number",0);
        SharedPreferences.Editor editor = SPR.edit();
        editor.putString("Key",number.getText().toString());
        editor.apply();

    }

}
