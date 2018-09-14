package music.prakash.com.musicalstructureapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import music.prakash.com.musicalstructureapp.utils.Album;
import music.prakash.com.musicalstructureapp.utils.Song;


public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String albumName = getIntent().getStringExtra("album");
        getSupportActionBar().setTitle(albumName);
        final ArrayList<Song> songs = new ArrayList<Song>();
        getSupportActionBar().setTitle(albumName);
        Song s1 = new Song(getString(R.string.song1), getString(R.string.artist1), getString(R.string.album1));
        Song s2 = new Song(getString(R.string.song2), getString(R.string.artist2), getString(R.string.album1));
        Song s3 = new Song(getString(R.string.song3), getString(R.string.artist1), getString(R.string.album2));
        Song s4 = new Song(getString(R.string.song4), getString(R.string.artist2), getString(R.string.album2));
        Album album1 = new Album(getString(R.string.album1), new Song[]{s1, s2});
        Album album2 = new Album(getString(R.string.album2), new Song[]{s3, s4});
        if (albumName != null && albumName.equals(album1.getAlbumname())) {
            for (Song s : album1.getSongs()) {
                songs.add(s);
            }
        } else if (albumName != null && albumName.equals(album2.getAlbumname())) {
            for (Song s : album2.getSongs()) {
                songs.add(s);
            }
        }
        ListView myListView = (ListView) findViewById(R.id.albumListView1);
        ArrayAdapter<Song> mySongAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        myListView.setAdapter(mySongAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AlbumActivity.this, PlayingActivity.class);
                intent.putExtra("song", songs.get(i).getSongname());
                startActivity(intent);
            }
        };
        myListView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
