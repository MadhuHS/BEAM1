package com.jspiders.moblie.imdbratingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView responsetv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responsetv =(TextView) findViewById(R.id.tvresponse);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://www.omdbapi.com/?s=Batman&page=2", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
            {
                String s1 = new String(responseBody);
                responsetv.setText(s1);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error)
            {

            }
        });

    }
}
