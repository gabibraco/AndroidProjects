package com.example.arturo.splashimage;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    //Definimos la duración del tiempo de carga
    private static final long SPLASH_SCREEN_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Forzamos la orientación de la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Ocultamos la barra de título
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Introducimos el layout
        setContentView(R.layout.activity_splash);

        //Creamos el método que lanza el activity principal
        TimerTask task = new TimerTask() {
            public void run() {

                //Lanzamos el activity principal
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                /*Cerramos el activity para que el usuario no pueda volver
                a esta pantalla*/
                finish();
            }
        };

        //Simulamos el tiempo de carga lanzando el task con un timer
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
