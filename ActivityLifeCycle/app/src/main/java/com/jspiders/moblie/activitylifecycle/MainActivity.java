package com.jspiders.moblie.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView messagetv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagetv = (TextView) findViewById(R.id.textView);
        messagetv.setText("onCreate");

        Toast.makeText(MainActivity.this,"inside onCreate()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"inside onStart()",Toast.LENGTH_SHORT).show();
        messagetv.setText("onStart");



    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"inside onResume()",Toast.LENGTH_SHORT).show();
        messagetv.setText("onResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"inside onPause()",Toast.LENGTH_SHORT).show();
        messagetv.setText("onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"inside onStop()",Toast.LENGTH_SHORT).show();
        messagetv.setText("onStop");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"inside onDestroy()",Toast.LENGTH_SHORT).show();
        messagetv.setText("onDestroy");


    }
}
