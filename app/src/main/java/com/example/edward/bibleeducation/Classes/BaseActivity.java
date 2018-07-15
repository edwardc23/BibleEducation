package com.example.edward.bibleeducation.Classes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {


    public BaseActivity(){

}
        public void startActivity(@NonNull Class<?> cls)
        {
                //this.cls = cls;
                Intent intent = new Intent();
                intent.setClass(this,cls);
                startActivity(intent);
        }
        public void startActivity(@NonNull Class<?> cls,String key, String s)
        {
                //this.cls = cls;
                Intent intent = new Intent();
                intent.setClass(this,cls);
                intent.putExtra(key,s);
                startActivity(intent);
        }
        public void toastShort(String msg){
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}
        public void toastLong(String msg){Toast.makeText(this,msg,Toast.LENGTH_LONG).show();}
}
