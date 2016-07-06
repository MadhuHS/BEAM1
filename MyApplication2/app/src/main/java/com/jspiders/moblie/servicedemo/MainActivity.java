package com.jspiders.moblie.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startbtn,stopbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbtn = (Button) findViewById(R.id.btnstart);
        stopbtn = (Button) findViewById(R.id.btnstop);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent startintent = new Intent(MainActivity.this,MyService.class);
                startService(startintent);
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent stopintent = new Intent(MainActivity.this,MyService.class);
                stopService(stopintent);
            }
        });





    }
}
