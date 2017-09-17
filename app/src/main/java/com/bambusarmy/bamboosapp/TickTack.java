package com.bambusarmy.bamboosapp;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TickTack extends AppCompatActivity {
    ImageButton nullnull;
    ImageButton nullone;
    ImageButton nulltwo;
    ImageButton onenull;
    ImageButton oneone;
    ImageButton onetwo;
    ImageButton twonull;
    ImageButton twoone;
    ImageButton twotwo;
    private static TextView winText;
    private static int player = 1;
    private static int[][] playField = new int[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_tack);

        winText = (TextView)findViewById(R.id.winText);

        nullnull = (ImageButton)findViewById(R.id.nullnull);
        nullnull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(nullnull,0,0);
            }
        });

        nullone = (ImageButton)findViewById(R.id.nullone);
        nullone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(nullone,0,1);
            }
        });

        nulltwo = (ImageButton)findViewById(R.id.nulltwo);
        nulltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(nulltwo,0,2);
            }
        });

        onenull = (ImageButton)findViewById(R.id.onenull);
        onenull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(onenull,1,0);
            }
        });

        oneone = (ImageButton)findViewById(R.id.oneone);
        oneone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(oneone,1,1);
            }
        });

        onetwo = (ImageButton)findViewById(R.id.onetwo);
        onetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(onetwo,1,2);
            }
        });

        twonull = (ImageButton)findViewById(R.id.twonull);
        twonull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(twonull,2,0);
            }
        });

        twoone = (ImageButton)findViewById(R.id.twoone);
        twoone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(twoone,2,1);
            }
        });

        twotwo = (ImageButton)findViewById(R.id.twotwo);
        twotwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FillPlayField(twotwo,2,2);
            }
        });
    }
    protected void onStop(){
        super.onStop();
        playField = new int[3][3];
        player = 1;
    }
    private static void FillPlayField(ImageButton setPic,int row,int col){
        if(playField[row][col] == 0){
            playField[row][col] = player;
            if(player == 1){
                setPic.setBackgroundResource(R.drawable.icon);
                player = 2;
            }
            else{
                setPic.setBackgroundResource(R.drawable.bambus);
                player = 1;
            }
            int win = CheckWin();
            if(win == 1){
                winText.setText("Panda wins!!!");
            }
            else if(win == 2){
                winText.setText("Bambus wins!!!");
            }
            else if(PlayFieldFull() == true){
                winText.setText("Draw");
            }

        }
    }
    private static boolean PlayFieldFull(){
        int counter = 0;
        for(int i = 0;i < playField[0].length;i++){
            for(int j = 0; j < playField[1].length;j++){
                if(playField[i][j] == 0){
                    counter++;
                }
            }
        }
        if (counter == 0){
            return true;
        }
        else{
            return false;
        }
    }
    private static int CheckWin(){
        int win = CheckWinHorizontal();
        if(win == 0){
            win = CheckWinVertikal();
            if(win == 0){
                win = CheckWinDiagonal();
                return win;
            }
            else {
                return win;
            }
        }
        else {
            return win;
        }

    }
    private static int CheckWinHorizontal(){
        int counterBambsu = 0;
        int counterPanda = 0;
        for(int i = 0; i < playField[0].length;i++){
            for(int j = 0; j < playField[1].length;j++){
                if(playField[i][j] == 1){
                    counterPanda++;
                }
                else if(playField[i][j] == 2){
                    counterBambsu++;
                }
            }
            if(counterBambsu == 3){
                return 2;
            }
            if (counterPanda == 3){
                return 1;
            }
            counterBambsu = 0;
            counterPanda = 0;
        }
        return 0;
    }
    private static int CheckWinVertikal(){
        int counterBambsu = 0;
        int counterPanda = 0;
        for(int i = 0; i < playField[0].length;i++){
            for(int j = 0; j < playField[1].length;j++){
                if(playField[j][i] == 1){
                    counterPanda++;
                }
                else if(playField[j][i] == 2){
                    counterBambsu++;
                }
            }
            if(counterBambsu == 3){
                return 2;
            }
            if(counterPanda == 3){
                return 1;
            }
            counterBambsu = 0;
            counterPanda = 0;
        }
        return 0;
    }
    private static int CheckWinDiagonal(){
        int counterBambsu = 0;
        int counterPanda = 0;
        for(int i = 0; i < playField[0].length;i++){
            if(playField[i][i] == 1){
                counterPanda++;
            }
            else if(playField[i][i] == 2){
                counterBambsu++;
            }
        }
        if(counterBambsu == 3){
            return 2;
        }
        if (counterPanda == 3){
            return 1;
        }

        counterBambsu = 0;
        counterPanda = 0;
        int j = 0;
        for(int i = playField[1].length - 1;i >= 0;i--){
            if(playField[j][i] == 1){
                counterPanda++;
            }
            else if(playField[j][i] == 2){
                counterBambsu++;
            }
            j++;
        }
        if(counterBambsu == 3){
            return 2;
        }
        if (counterPanda == 3){
            return 1;
        }
        return 0;
    }
}
