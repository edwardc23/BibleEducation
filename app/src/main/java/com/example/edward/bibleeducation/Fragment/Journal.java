package com.example.edward.bibleeducation.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.edward.bibleeducation.Adapter.MainListAdapter;
import com.example.edward.bibleeducation.Classes.Grades;
import com.example.edward.bibleeducation.Classes.QuizActivity;
import com.example.edward.bibleeducation.Journals.Journal1;
import com.example.edward.bibleeducation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class Journal extends Fragment {
    private MainListAdapter adapter;
    public List<String> list = new ArrayList<String>();
    private ListView listView;

    private View view;

    public Journal() {
       list.add("Journal #1");
        list.add("Journal #2");
        list.add("Journal #3");
        list.add("Journal #4");
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_journal, container, false);
        listView = view.findViewById(R.id.main_demo_lv);
        adapter = new MainListAdapter(getContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent =  new Intent();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent.setClass(getActivity(), Journal1.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent.setClass(getActivity(), QuizActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;

    }


}
