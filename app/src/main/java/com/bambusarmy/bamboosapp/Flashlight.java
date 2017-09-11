package com.bambusarmy.bamboosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class Flashlight extends AppCompatActivity {
    public static Camera cam = null;
    public static boolean onOff = false;
    Button light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);
        light = (Button)findViewById(R.id.FlOnOff);
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onOff == false){
                    onOff = true;
                    flashLightOn();
                }
                else{
                    onOff = false;
                    flashLightOff();
                }
            }
        });
    }


    public void flashLightOn() {

                cam = Camera.open();
                Parameters p = cam.getParameters();
                p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                cam.setParameters(p);
                cam.startPreview();
            }

    public void flashLightOff() {
                cam.stopPreview();
                cam.release();
                cam = null;
    }
}
