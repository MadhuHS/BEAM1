package com.jspiders.moblie.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dialbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialbtn = (Button) findViewById(R.id.btndial);

        dialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                /*Intent dialintent = new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse("tel:"+"8455112221"));
                startActivity(dialintent);*/

                Intent webintent = new Intent(Intent.ACTION_VIEW);
                webintent.setData(Uri.parse("www.github.com/"));
                startActivity(webintent);


            }
        });


    }
}
