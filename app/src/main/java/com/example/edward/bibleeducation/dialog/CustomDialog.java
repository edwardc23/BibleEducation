package com.example.edward.bibleeducation.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;


import com.example.edward.bibleeducation.R;

import butterknife.ButterKnife;

public class CustomDialog extends Dialog {
    private CustomDialogEventListener listener;

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
    }
}