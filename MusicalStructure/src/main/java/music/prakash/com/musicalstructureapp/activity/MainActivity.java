package music.prakash.com.musicalstructureapp.activity;


import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import music.prakash.com.musicalstructureapp.activity.R;
import music.prakash.com.musicalstructureapp.adapter.MusicAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager myViewPager;
    MusicAdapter myMusicAdapter;
    TabLayout myTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMusicAdapter = new MusicAdapter(getSupportFragmentManager());
        myViewPager = (ViewPager) findViewById(R.id.pager);
        myTabLayout = findViewById(R.id.tab);
        myViewPager.setAdapter(myMusicAdapter);
        myTabLayout.setupWithViewPager(myViewPager);
    }
}
