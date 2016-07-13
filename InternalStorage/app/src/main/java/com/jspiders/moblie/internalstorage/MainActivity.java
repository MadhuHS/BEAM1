package com.jspiders.moblie.internalstorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    EditText inputmessageet;
    Button savebtn,readbtn;
    TextView outputtv;
    FileOutputStream fos;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputmessageet =(EditText) findViewById(R.id.etmessage);
        savebtn = (Button) findViewById(R.id.btnsave);
        readbtn = (Button) findViewById(R.id.btnread);
        outputtv =(TextView) findViewById(R.id.tvoutput);

        savebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               String data = inputmessageet.getText().toString();

                try
                {
                    fos = openFileOutput("MyFile", Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    Toast.makeText(MainActivity.this,"File saved",Toast.LENGTH_SHORT).show();

                }

                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                finally
                {
                    try
                    {
                        fos.close();
                    }

                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        });


        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try
                {
                    fis =openFileInput("MyFile");

                    InputStreamReader inputStreamReader = new InputStreamReader(fis);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String line ="";
                    StringBuffer buffer = new StringBuffer();

                    while ((line=bufferedReader.readLine())!=null)
                    {
                        buffer.append(line+"\n"+"\r");
                    }
                    outputtv.setText(buffer.toString());
                }

                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


    }
}
