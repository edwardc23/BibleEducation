package com.example.edward.bibleeducation.Music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.example.edward.bibleeducation.R;

import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;
    boolean mp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("I Do Worship(Remix)", "John P. Kee", R.raw.idoworshipremix));
        arrayList.add(new Music("For Every Mountain", "Kurt Carr", R.raw.foreverymountain));


        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arrayList);

        songList.setAdapter(adapter);

}

}
