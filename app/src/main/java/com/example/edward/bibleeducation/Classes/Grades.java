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
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.edward.bibleeducation.Adapter.MainListAdapter;
import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;

public class Grades extends BaseActivity {
static int grades=0;
static ArrayList <Integer> Scores = new ArrayList<>();
    private List<String> list = new ArrayList<String>();
    static ListView listView;
    private MainListAdapter adapter;
    private Button gradeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        gradeBtn=(Button) findViewById(R.id.grades);

        gradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.CustomDialogEventListener listener
                        = new CustomDialog.CustomDialogEventListener() {
                    @Override
                    public void onClickListener(String msg) {

                    }
                };
                CustomDialog dialog =
                        new CustomDialog(Grades.this, listener);
                dialog.show();
            }
        });
    }



    public void getGrades(int grade)
    {
        grades=grades+grade;


//Toast.makeText(this,Scores.get(0),Toast.LENGTH_LONG).show();

    }
    public Integer needGrade(){
        return grades;
    }
}
