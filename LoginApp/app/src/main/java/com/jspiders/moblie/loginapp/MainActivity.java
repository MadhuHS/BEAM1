package com.jspiders.moblie.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


   EditText usernameet,passwordet;
    Button loginbtn;

    String username = getResources().getString(R.string.username);
    String password = getResources().getString(R.string.password);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameet =(EditText) findViewById(R.id.etusername);
        passwordet = (EditText) findViewById(R.id.etpassword);
        loginbtn = (Button) findViewById(R.id.btnlogin);

        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String entusername = usernameet.getText().toString();
                String entpassword = passwordet.getText().toString();

                if(entusername.equals(username)&&entpassword.equals(password))
                {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.log_succes),Toast.LENGTH_SHORT).show();
                }

                else if(entusername.length()==0 && entpassword.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Inavlid details",Toast.LENGTH_SHORT).show();
                    usernameet.setError("enter username");
                    passwordet.setError("enter password");
                }

                else if(entusername.length()!=0&&entpassword.length()==0)
                {
                    passwordet.setError("enter password");
                }

                else if(entusername.length()==0&&entpassword.length()!=0)
                {
                    usernameet.setError("enter username");

                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Inavlid details",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}
