package music.prakash.com.musicalstructureapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String fragment = getIntent().getExtras().getString("fragment");
        TextView myViewerTextView = findViewById(R.id.textView7);
        if ("Artist".equals(fragment)) {
            getSupportActionBar().setTitle(fragment);
            String artist = getIntent().getStringExtra("artist");
            getSupportActionBar().setTitle(artist);
            myViewerTextView.setText(getString(R.string.action_frag_album));
            final String[] albumNames = getIntent().getStringArrayExtra("albums");
            ListView listView = findViewById(R.id.viewersListView);
            ArrayAdapter<String> myAlbumAdapter = new ArrayAdapter<String>(ViewerActivity.this, android.R.layout.simple_list_item_1, albumNames);
            listView.setAdapter(myAlbumAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int i, long arg) {
                                                    Intent intent = new Intent(ViewerActivity.this, AlbumActivity.class);
                                                    intent.putExtra("album", albumNames[i]);
                                                    startActivity(intent);
                                                }
                                            }
            );

        } else if ("Album".equals(fragment)) {

            String album = getIntent().getStringExtra("album");
            getSupportActionBar().setTitle(album);
            myViewerTextView.setText(getString(R.string.action_frag_song));
            final String[] songNames = getIntent().getStringArrayExtra("songs");
            ListView listView = findViewById(R.id.viewersListView);
            ArrayAdapter<String> albumAdapter = new ArrayAdapter<>(ViewerActivity.this, android.R.layout.simple_list_item_1, songNames);
            listView.setAdapter(albumAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int i, long arg) {
                                                    Intent intent = new Intent(ViewerActivity.this, PlayingActivity.class);
                                                    intent.putExtra("song", songNames[i]);
                                                    startActivity(intent);
                                                }
                                            }
            );

        } else if (fragment.equals("Playlist")) {
            String playlist = getIntent().getStringExtra("playlist");
            getSupportActionBar().setTitle(playlist);
            final String[] songNames = getIntent().getStringArrayExtra("songs");
            myViewerTextView.setText(getString(R.string.action_frag_song));
            ListView listView = findViewById(R.id.viewersListView);
            ArrayAdapter<String> myPlayListAdapter = new ArrayAdapter<>(ViewerActivity.this, android.R.layout.simple_list_item_1, songNames);
            listView.setAdapter(myPlayListAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                                                    Intent intent = new Intent(ViewerActivity.this, PlayingActivity.class);
                                                    intent.putExtra("song", songNames[i]);
                                                    startActivity(intent);
                                                }
                                            }
            );
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
