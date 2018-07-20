package com.example.edward.bibleeducation.Classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gesture.Gesture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edward.bibleeducation.Adapter.QuizPagerAdapter;
import com.example.edward.bibleeducation.QuizQuestions.Question1;
import com.example.edward.bibleeducation.QuizQuestions.Question2;
import com.example.edward.bibleeducation.QuizQuestions.Question3;
import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.service.LogUtil;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class QuizActivity extends BaseActivity  {

    private Button homeButton;
    private ViewPager viewPager;
    private Grades grades=new Grades();
    static int score =0;

    TextView tv;
    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;
    private Gesture gesture;

    private String TAG;
    EditText editText;
    String s = "-1";
    int num =1;
    int page=1;
    public QuizActivity(){

    }
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        gesture=new Gesture();

gestureDetector = new GestureDetector(this,new simpleGestureListener());

        viewPager= (ViewPager) findViewById(R.id.viewpager_vp);






        fragmentList.add(new Question1());
        fragmentList.add(new Question2());
        fragmentList.add(new Question3());
       QuizPagerAdapter adapter =
                new QuizPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        adapter.updateList(fragmentList);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return gestureDetector.onTouchEvent(event);
            }

        });
        viewPager.setFocusable(true);
        viewPager.setClickable(true);
        viewPager.setLongClickable(true);
        handler.post(runnableCode);

if(s=="0"){
    Toast.makeText(QuizActivity.this,s,Toast.LENGTH_SHORT).show();

    startActivity(MainActivity.class);
}
        homeButton= (Button) findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grades.getGrades(score);

                startActivity(MainActivity.class);

            }
        });

    }

    public static void addScore(int num){
        score=score+num;


    }
    public static String getScore()
    {
        return String.valueOf(score);
    }

    // Create the Handler object (on the main thread by default)
    Handler handler = new Handler();
    // Define the code block to be executed
    public Runnable runnableCode = new Runnable() {


        @Override
        public void run() {
            editText= (EditText)findViewById(R.id.handler_et);

            if(s=="-1")
            {
                s="30";
            }
            else if(s!=null)
            {
                s = editText.getText().toString();
            }


            int number =Integer.valueOf(s);
            if(number > 0){
                number-=1;
                editText.setText(String.valueOf(number));
            }
           else if(number==0)
            {
                while(num>0){

                editText.setText(String.valueOf(number));
                handler.removeCallbacks(this);
                startActivity(MainActivity.class);
                num=0;}
            }
              if(s!="0")
            {
                handler.postDelayed(runnableCode, 1000);
            }

        }
    };
// Start the initial runnable task by posting through the handler
public class simpleGestureListener extends
        GestureDetector.SimpleOnGestureListener{

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        LogUtil.LogD("Gesture","oSingleTapUp");
        return super.onSingleTapUp(e);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        LogUtil.LogD("Gesture","onLongPress");
        super.onLongPress(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        LogUtil.LogD("Gesture","ononScroll");
        LogUtil.LogD("Gesture","distanceX: "+distanceX);
        LogUtil.LogD("Gesture","distanceY: "+distanceY);
        sumX+=distanceX;
        sumY+=distanceY;
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        LogUtil.LogD("Gesture","onFling");
        if(sumX<0){
            if(Math.abs(sumX)>600) {

                if(page>1) {page--;
                    showToast(" Page " + page);
                }
                sumX = 0;
                sumY = 0;
            }
        }
        if(sumX>0){
            if(Math.abs(sumX)>600) {
                if(page<3) {page++;
                    showToast(" Page " + page);
                }

                sumY=0;
                sumX = 0;
            }
        }


        return super.onFling(e1, e2, velocityX, velocityY);
    }


}

    }








