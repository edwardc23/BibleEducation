package com.example.edward.bibleeducation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.edward.bibleeducation.R;

import java.util.List;

public class MainListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflator;
    //The system creates the items we see one by one faster than the human eye can notice
    //the system will call getView() several times updating the position (of the list we are in)
    //and draw the next item
    private List<String> list;
    //TextView textView;

    public MainListAdapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
        inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        //This tells us how mayn items are currently in the listview
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflator.inflate(R.layout.item_listview_main, parent, false);
            TextView textView = convertView.findViewById(R.id.main_adapter_tv);
            convertView.setTag(textView);
        }

        TextView textView = (TextView) convertView.getTag();
        textView.setText(list.get(position));
        return convertView;
    }
}
