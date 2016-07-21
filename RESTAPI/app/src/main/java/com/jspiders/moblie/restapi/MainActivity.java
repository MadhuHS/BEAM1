package com.jspiders.moblie.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    String url = "http://10.0.3.2:8085/BluekArt/rest/controller/getproducts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
            {
                  String jsonresponse = new String(responseBody);
                  Log.d("DEBUG",jsonresponse);

                Gson gson = new Gson();
                Response response = gson.fromJson(jsonresponse,Response.class);

                ArrayList<Response.Productlist> list =(ArrayList<Response.Productlist>) response.getProductlist();
                Response.Productlist productobj = list.get(0);

                for (int i = 0; i < list.size(); i++)
                {
                    Log.d("DEBUG",list.get(i).getName());
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error)
            {

            }
        });

    }
}
