package com.example.edward.bibleeducation.Classes;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.edward.bibleeducation.R;

import java.util.ArrayList;

public class Grades extends Activity {
static int grades=0;
static ArrayList <Integer> Scores = new ArrayList<>();
    private Object notificationBuilder;
    private Button gradeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
//        gradeBtn=(Button) findViewById(R.id.grades);
//        gradeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
    public void getGrades(int grade)
    {
        grades=grades+grade;
        Scores.add(grades);
//Toast.makeText(this,Scores.get(0),Toast.LENGTH_LONG).show();
        grades=0;
    }
}
