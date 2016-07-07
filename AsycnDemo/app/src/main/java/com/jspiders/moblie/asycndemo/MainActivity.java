package com.jspiders.moblie.asycndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button downloadbtn;
    TextView statustv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadbtn = (Button) findViewById(R.id.btndownload);
        statustv = (TextView) findViewById(R.id.tvstatus);

        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NetworkJob networkJob = new NetworkJob(downloadbtn,statustv,MainActivity.this);
                networkJob.execute();
            }
        });

    }
}
