package com.jspiders.moblie.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService()
    {

    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Toast.makeText(MyService.this,"inside onCreate()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(MyService.this,"inside onStartCommand()",Toast.LENGTH_SHORT).show();

       /* for (int i = 0; i <100 ; i++)
        {
            try
            {
                Thread.sleep(500);
                Log.d("[DEBUG SERVICE]","Value of i is "+i);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }*/


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(MyService.this,"inside onDestroy()",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
