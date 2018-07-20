package com.example.edward.bibleeducation.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;


import com.example.edward.bibleeducation.Adapter.MainListAdapter;
import com.example.edward.bibleeducation.Classes.Grades;
import com.example.edward.bibleeducation.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {
    private CustomDialogEventListener listener;
    private Grades myGrade=new Grades();
    private double grades;
    private List<String> list = new ArrayList<String>();
    static ListView listView;
    private MainListAdapter adapter;
    public interface CustomDialogEventListener{
        public void onClickListener(String msg);
    }

    public CustomDialog(@NonNull Context context, CustomDialogEventListener listener) {
        super(context);
        this.listener = listener;
    }



    //@SuppressLint("ResourceType")
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.id.dialog_custom);
//     ButterKnife.bind(this);
        setContentView(R.layout.activity_custom_dialog);
        ButterKnife.bind(this);
     grades= (double) myGrade.needGrade()/30;
        DecimalFormat formatter = new DecimalFormat("#.##");
        String avg = formatter.format(grades);
        list.add("Your grade is "+ avg+"%");
        listView = (ListView) findViewById(R.id.grades_list);
        adapter = new MainListAdapter(getContext(),list);
        listView.setAdapter(adapter);

    }
    @OnClick(R.id.dialog_ok)
    public void ok(View view){

        dismiss();
    }
}