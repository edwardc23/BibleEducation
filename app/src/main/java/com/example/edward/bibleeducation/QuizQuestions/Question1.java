package com.example.edward.bibleeducation.QuizQuestions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edward.bibleeducation.Classes.BaseActivity;
import com.example.edward.bibleeducation.Classes.QuizActivity;
import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.dialog.CustomDialog;
import com.example.edward.bibleeducation.service.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 */
public class Question1 extends Fragment {

private Button submit;

    private RadioGroup radioGroup;
    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;

    @BindView(R.id.handler_et)
    EditText editText;

    private View myView;
    private QuizActivity qA= new QuizActivity();

public Question1(){}

    public QuizActivity getqA() {
        return qA;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_question1, container, false);
       submit = (Button) myView.findViewById(R.id.q1_submit);
       runHandler.postDelayed(runnable, 1000);
         radioGroup = (RadioGroup) myView .findViewById(R.id.rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.q1_choice1:
                        if(qA.getScore().equals("0")){
                        qA.addScore(10);
                        }
                       Toast.makeText(getActivity(),"Correct",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_choice2:
                        Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_choice3:
                        Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),qA.getScore(), Toast.LENGTH_SHORT).show();
            }
        });

        return myView;
    }


    @OnClick(R.id.handler_countdown)
    public void countDown(View view){

    }

    Handler downloadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    editText.setText("Started");

                    Toast.makeText(getActivity(),String.valueOf(msg.arg1),Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    editText.setText("Downloading");
                    break;
                case 3:
                    editText.setText("Finished");
                    break;
            }
        }
    };


    Handler runHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String s = "10";
            int number =Integer.valueOf(s);
            if(number > 0){
                number-=1;
            }
            //editText.setText(String.valueOf(number));
            runHandler.postDelayed(runnable, 1000);
        }
    };


    /*@Override
    public void handleMessage(Message msg){
        super handleMessage(msg);
    }*/










    }
