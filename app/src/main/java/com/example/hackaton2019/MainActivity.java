package com.example.hackaton2019;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message = new Intent(MainActivity.this, MapsActivity.class);
                MediaPlayer mpMario = MediaPlayer.create(MainActivity.this,R.raw.mario);

                startActivity(message);
                mpMario.start();

            }
        });
    }

}
