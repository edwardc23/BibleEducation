package com.example.edward.bibleeducation.Classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.edward.bibleeducation.Adapter.QuizPagerAdapter;
import com.example.edward.bibleeducation.QuizQuestions.Question1;
import com.example.edward.bibleeducation.QuizQuestions.Question2;
import com.example.edward.bibleeducation.R;

import java.util.ArrayList;

public class QuizActivity extends BaseActivity {

    private Button homeButton;
    private ViewPager viewPager;
    private Grades grades=new Grades();
    static int score =0;
    public QuizActivity(){

    }
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        viewPager= findViewById(R.id.viewpager_vp);
        fragmentList.add(new Question1());
        fragmentList.add(new Question2());

       QuizPagerAdapter adapter =
                new QuizPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        adapter.updateList(fragmentList);
        homeButton=findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grades.getGrades(score);
                score=0;
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
}
