package com.jspiders.moblie.restapi;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    static NetworkInfo netInfo;
    public MyReceiver()
    {
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo  = cm.getActiveNetworkInfo();
    }

    public static NetworkInfo isOnline()
    {
        return netInfo;
    }
}
