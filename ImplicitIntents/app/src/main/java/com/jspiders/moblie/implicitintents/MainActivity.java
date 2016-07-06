package com.jspiders.moblie.implicitintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dialbtn;
    ImageView outputiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialbtn = (Button) findViewById(R.id.btndial);
        outputiv = (ImageView) findViewById(R.id.ivoutput);

        dialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                /*Intent dialintent = new Intent(Intent.ACTION_DIAL);
                dialintent.setData(Uri.parse("tel:"+"8455112221"));
                startActivity(dialintent);*/

               /* Intent webintent = new Intent(Intent.ACTION_VIEW);
                webintent.setData(Uri.parse("www.github.com/"));
                startActivity(webintent);*/

                Intent camintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camintent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle b1 = data.getExtras();

        if(b1!=null)
        {
            Bitmap bitmap = (Bitmap) b1.get("data");
            outputiv.setImageBitmap(bitmap);
        }

        else
        {
            Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
        }
    }
}
