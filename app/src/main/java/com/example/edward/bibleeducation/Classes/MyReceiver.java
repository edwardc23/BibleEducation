package com.example.edward.bibleeducation.Classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.edward.bibleeducation.R;

import static android.widget.Toast.*;

public class MyReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"ed",Toast.LENGTH_SHORT).show();
        Bundle bundle = intent.getExtras();

        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.floydchapelbaptistchurch.com")));
    }
}
