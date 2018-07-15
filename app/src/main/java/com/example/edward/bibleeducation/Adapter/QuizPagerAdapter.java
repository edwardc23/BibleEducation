package com.example.edward.bibleeducation.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class QuizPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;

    public QuizPagerAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Fragment> fragmentList)
    {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position){

        return fragmentList.get(position);
    }
    @Override
    public int getCount(){
        return fragmentList.size();

    }

    public  void updateList(ArrayList<Fragment> fragmentList)
    {
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
