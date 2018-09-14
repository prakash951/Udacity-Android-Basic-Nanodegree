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

import music.prakash.com.musicalstructureapp.activity.R;
import music.prakash.com.musicalstructureapp.activity.ViewerActivity;
import music.prakash.com.musicalstructureapp.utils.PlayList;
import music.prakash.com.musicalstructureapp.utils.Song;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaylistFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PlaylistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlaylistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaylistFragment newInstance(String param1, String param2) {
        PlaylistFragment fragment = new PlaylistFragment();
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
        View myPlayListView = inflater.inflate(R.layout.fragment_playlist, container, false);
        Song s1 = new Song(getString(R.string.song1), getString(R.string.artist1), getString(R.string.album1));
        Song s2 = new Song(getString(R.string.song2), getString(R.string.artist2), getString(R.string.album1));
        Song s3 = new Song(getString(R.string.song3), getString(R.string.artist1), getString(R.string.album2));
        Song s4 = new Song(getString(R.string.song4), getString(R.string.artist2), getString(R.string.album2));
        PlayList p1 = new PlayList(getString(R.string.playlist1), new Song[]{s1, s2});
        PlayList p2 = new PlayList(getString(R.string.playlist2), new Song[]{s3, s4});
        final ArrayList<PlayList> myPlayList = new ArrayList<>();
        myPlayList.add(p1);
        myPlayList.add(p2);
        ArrayAdapter<PlayList> myPlayListArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, myPlayList);
        ListView playListView = (ListView) myPlayListView.findViewById(R.id.playListView);
        playListView.setAdapter(myPlayListArrayAdapter);
        AdapterView.OnItemClickListener myItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ViewerActivity.class);
                intent.putExtra("playlist", myPlayList.get(i).getPlaylistname());
                ArrayList<String> songNames = new ArrayList<String>();
                for (Song s : myPlayList.get(i).getSongs()) {
                    songNames.add(s.getSongname());
                }
                intent.putExtra("songs", songNames.toArray(new String[songNames.size()]));
                intent.putExtra("fragment", "Playlist");
                startActivity(intent);
            }
        };
        playListView.setOnItemClickListener(myItemClickListener);
        return myPlayListView;
    }

}
