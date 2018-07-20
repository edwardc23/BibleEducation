package com.example.edward.bibleeducation.Classes;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.service.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class BaseActivity extends AppCompatActivity {
        @BindView(R.id.bible)
        public TextView bible;
        private Animation setAnimation;
        private int sumX =0;
        private int sumY =0;
        GestureDetector gestureDetector;
        

        public BaseActivity(){

}


//        public void set(){
//                bible.startAnimation(setAnimation);
//        }

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
        public void initialAnim(){
                setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                bible.startAnimation(setAnimation);
        }
        public void showToast(String msg){
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        public void toastShort(String msg){
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}
        public void toastLong(String msg){Toast.makeText(this,msg,Toast.LENGTH_LONG).show();}

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                LogUtil.LogD("Gesture","onFling");
                if(sumX<0){
                        if(Math.abs(sumX)>600) {

                                showToast("You scroll from left to right");
                                sumX = 0;
                                sumY = 0;
                        }
                }
                if(sumX>0){
                        if(Math.abs(sumX)>600) {
                                showToast("You scroll from  right to left");
                                sumY=0;
                                sumX = 0;
                        }
                }

                if(sumY<0){
                        if(Math.abs(sumY)>100) {
                                showToast("You scroll from top to bottom");
                                sumX = 0;
                                sumY = 0;
                        }
                }
                if(sumY>0){
                        if(Math.abs(sumY)>100) {
                                showToast("You scroll from  bottom to top");
                                sumX = 0;
                                sumY = 0;
                        }
                }
                
                return true;
        }

        

}

