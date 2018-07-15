package com.example.edward.bibleeducation.QuizQuestions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edward.bibleeducation.Classes.BaseActivity;
import com.example.edward.bibleeducation.Classes.QuizActivity;
import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.dialog.CustomDialog;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 */
public class Question1 extends Fragment {

private Button submit;

    private RadioGroup radioGroup;



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
       submit = myView.findViewById(R.id.q1_submit);
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



    }
