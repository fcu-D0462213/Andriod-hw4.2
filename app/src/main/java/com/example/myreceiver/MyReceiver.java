package com.example.myreceiver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;


public class MyReceiver extends BroadcastReceiver {
 int id=7000;
    @Override
    public void onReceive(Context context, Intent intent) {
        String name=intent.getStringExtra("OName");
        Intent newintent = new Intent();
        newintent.setClass(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.
                getActivity(context, 0, newintent,PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notify = null;
        if (Build.VERSION.SDK_INT >= 16) {
            notify = newNotification(context, pendingIntent,
                    "(New) Broadcast is received.", name);
        }

        NotificationManager notificationManager =
                (NotificationManager)context.
                        getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(id++, notify);
    }



    @SuppressLint("NewApi")
    private Notification newNotification(
            Context context, PendingIntent pi,
            String title, String name) {

        Notification.Builder builder =
                new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(name);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(name);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }
    //TextView toSayHello=(TextView)findViewById(R.id.output);


        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

}
