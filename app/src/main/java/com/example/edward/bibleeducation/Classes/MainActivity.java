package com.example.edward.bibleeducation.Classes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.edward.bibleeducation.Classes.BaseActivity;
import com.example.edward.bibleeducation.Classes.QuizActivity;
import com.example.edward.bibleeducation.Fragment.Journal;
import com.example.edward.bibleeducation.R;

public class MainActivity extends BaseActivity {


    private Button quizButton;
    private Button journalButton;
    private Button versesButton;
    private Button gradesButton;
    private Journal journal;
    private RadioGroup rg;
    private Button notificationButton;
    private NotificationManager notifManager;
    private NotificationManager mNotificationManager;
    private int notifyId = 100;
    private final String channelId = "Example";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        journal=new Journal();
        notificationButton= findViewById(R.id.main_grades1);
        quizButton= findViewById(R.id.main_quiz);
        journalButton= findViewById(R.id.main_journal);
        versesButton= findViewById(R.id.main_verses);
        gradesButton= findViewById(R.id.main_grades);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizButton.setTextColor(Color.BLUE);
                journalButton.setTextColor(Color.BLACK);
                versesButton.setTextColor(Color.BLACK);
                gradesButton.setTextColor(Color.BLACK);
                startActivity(QuizActivity.class);
            }
        });
        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrag, journal).commit();
            }
        });
        gradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizButton.setTextColor(Color.BLACK);
                journalButton.setTextColor(Color.BLACK);
                versesButton.setTextColor(Color.BLACK);
                gradesButton.setTextColor(Color.BLUE);
                startActivity(Grades.class);
            }
        });
        notificationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(NotificationActivity.class);
            }
        });

    }
    public void notifiCall(View view){


//
    }
    public void createNotification(String aMessage) {

    }
    private void addNotification() {

    }



}
