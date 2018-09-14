package music.prakash.com.musicalstructureapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import music.prakash.com.musicalstructureapp.activity.PlayingActivity;
import music.prakash.com.musicalstructureapp.activity.R;
import music.prakash.com.musicalstructureapp.utils.Song;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SongFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SongFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SongFragment newInstance(String param1, String param2) {
        SongFragment fragment = new SongFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View songView = inflater.inflate(R.layout.fragment_song, container, false);
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(getString(R.string.song1), getString(R.string.artist1), getString(R.string.album1)));
        songs.add(new Song(getString(R.string.song2), getString(R.string.artist2), getString(R.string.album1)));
        songs.add(new Song(getString(R.string.song3), getString(R.string.artist1), getString(R.string.album2)));
        songs.add(new Song(getString(R.string.song4), getString(R.string.artist2), getString(R.string.album2)));
        ListView myListView = (ListView) songView.findViewById(R.id.songsListView);
        ArrayAdapter<Song> mySongAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, songs);
        myListView.setAdapter(mySongAdapter);
        AdapterView.OnItemClickListener myItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), PlayingActivity.class);
                intent.putExtra("song", songs.get(i).getSongname());
                startActivity(intent);
            }
        };
        myListView.setOnItemClickListener(myItemClickListener);
        return songView;
    }

}
