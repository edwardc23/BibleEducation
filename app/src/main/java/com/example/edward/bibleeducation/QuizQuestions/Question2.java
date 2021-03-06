package com.example.edward.bibleeducation.QuizQuestions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.edward.bibleeducation.Classes.QuizActivity;
import com.example.edward.bibleeducation.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class Question2 extends Fragment {
    private Button submit;

    private RadioGroup radioGroup;



    private View myView;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_question2, container, false);
        submit = (Button) myView.findViewById(R.id.q2_submit);
        radioGroup = (RadioGroup) myView .findViewById(R.id.q2_rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.q2_choice1:
                        Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.q2_choice2:
                        Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q2_choice3:

                    if(QuizActivity.getScore().equals("10")){
                        QuizActivity.addScore(10);
                    }
                    Toast.makeText(getActivity(),"Correct",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),QuizActivity.getScore(), Toast.LENGTH_SHORT).show();
            }
        });

        return myView;
    }



}
