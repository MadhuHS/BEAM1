package com.jspiders.moblie.asycndemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 07/07/2016.
 */
public class NetworkJob extends AsyncTask {

    Button downloadbtn;
    TextView statustv;
    Context ctx;
    NotificationCompat.Builder builder;
    Notification notification;
    NotificationManager manager;

    NetworkJob(Button downloadbtn, TextView statustv,Context ctx)
    {
        this.downloadbtn = downloadbtn;
        this.statustv = statustv;
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();

         builder = new NotificationCompat.Builder(ctx);
         builder.setContentTitle("Download started...");
         builder.setContentText("0%");
         builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setProgress(100,0,false);
         notification = builder.build();

         manager = (NotificationManager) ctx.getSystemService(ctx.NOTIFICATION_SERVICE);
         manager.notify(1,notification);
        statustv.setText("download started....");
        downloadbtn.setEnabled(false);
        Log.d("[JSPIDERS]","inside onPreExecute()");

    }

    @Override
    protected Object doInBackground(Object[] objects)
    {
        for (int i = 0; i <=100 ; i++)
        {
            try
            {
                Thread.sleep(300);
                Integer updatevalue = i;
                publishProgress(updatevalue);
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Object[] values)
    {
        super.onProgressUpdate(values);

        Integer update = (Integer) values[0];
        statustv.setText(update.toString()+"% completed");
        Log.d("[JSPIDERS]",update.toString());


    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        statustv.setText("download completed....");
        downloadbtn.setEnabled(true);
        Log.d("[JSPIDERS]","inside onPostExecute()");


    }
}
