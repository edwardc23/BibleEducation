package com.example.edward.bibleeducation.Classes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.edward.bibleeducation.R;

public class NotificationActivity extends AppCompatActivity {

    private Button small;
    private Button big;
    private Button pic;
    private NotificationManager mNotificationManager;
    private int notifyId=100;
    private final String channelId="Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        small = findViewById(R.id.notifi_small);
        big = findViewById(R.id.notifi_big);
        pic = findViewById(R.id.notifi_pic);
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        small.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationActivity.this,channelId);
                    mBuilder.setContentTitle("Title")
                            .setContentText("Text")
                            .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                            .setNumber(10)
                            .setTicker("Ticker")
                            .setWhen(System.currentTimeMillis())
                            .setPriority(Notification.PRIORITY_DEFAULT)
                            .setAutoCancel(true)
                            .setOngoing(false)
                            .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)
                            .setSmallIcon(R.mipmap.ic_launcher);
                    mNotificationManager.notify(notifyId, mBuilder.build());
                }
            });

        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public PendingIntent getDefaultIntent(int flags){
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(),flags );
        return  pendingIntent;
    }
}
