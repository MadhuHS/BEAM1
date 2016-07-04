package com.jspiders.moblie.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startbtn;
    EditText messageet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbtn = (Button) findViewById(R.id.btnstart);
        messageet = (EditText) findViewById(R.id.etmessage);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String data = messageet.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("msg",data);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        {
            Toast.makeText(MainActivity.this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(MainActivity.this,"ERROR in getting data",Toast.LENGTH_LONG).show();

        }
    }
}
