package com.jspiders.moblie.intentsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView resulttv;
    EditText messageetsec;
    Button senddatabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resulttv = (TextView) findViewById(R.id.tvresult);
        messageetsec = (EditText) findViewById(R.id.etsecmessage);
        senddatabtn = (Button) findViewById(R.id.btnsendata);
        String result = getIntent().getStringExtra("msg");

        if (!result.isEmpty())
        {
            resulttv.setText(result);
        }

        senddatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               String data = messageetsec.getText().toString();
                setResult(RESULT_CANCELED,getIntent().putExtra("result",data));
                finish();
            }
        });
    }
}
