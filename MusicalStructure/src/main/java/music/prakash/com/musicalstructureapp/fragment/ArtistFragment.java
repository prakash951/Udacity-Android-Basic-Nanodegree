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
import music.prakash.com.musicalstructureapp.utils.Album;
import music.prakash.com.musicalstructureapp.utils.Artist;
import music.prakash.com.musicalstructureapp.utils.Song;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArtistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArtistFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ArtistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArtistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArtistFragment newInstance(String param1, String param2) {
        ArtistFragment fragment = new ArtistFragment();
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
        View myArtistView = inflater.inflate(R.layout.fragment_artist, container, false);
        Song s1 = new Song(getString(R.string.song1), getString(R.string.artist1), getString(R.string.album1));
        Song s2 = new Song(getString(R.string.song2), getString(R.string.artist1), getString(R.string.album1));
        Song s3 = new Song(getString(R.string.song3), getString(R.string.artist2), getString(R.string.album2));
        Song s4 = new Song(getString(R.string.song4), getString(R.string.artist2), getString(R.string.album2));
        Album album1 = new Album(getString(R.string.album1), new Song[]{s1, s2});
        Album album2 = new Album(getString(R.string.album2), new Song[]{s3, s4});
        Artist artist1 = new Artist(getString(R.string.artist1), new Song[]{s1, s2}, new Album[]{album1});
        Artist artist2 = new Artist(getString(R.string.artist2), new Song[]{s3, s4}, new Album[]{album2});
        final ArrayList<Artist> myArtistList = new ArrayList<>();
        myArtistList.add(artist1);
        myArtistList.add(artist2);
        ListView myArtistListView = (ListView) myArtistView.findViewById(R.id.artistListView);
        ArrayAdapter<Artist> myArtistAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, myArtistList);
        myArtistListView.setAdapter(myArtistAdapter);
        AdapterView.OnItemClickListener myItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ViewerActivity.class);

                ArrayList<String> albumNames = new ArrayList<String>();
                for (Album album : myArtistList.get(i).getAlbums()) {
                    albumNames.add(album.getAlbumname());
                }
                intent.putExtra("artist", myArtistList.get(i).getArtistname());
                intent.putExtra("albums", albumNames.toArray(new String[albumNames.size()]));
                intent.putExtra("fragment", "Artist");
                startActivity(intent);
            }
        };
        myArtistListView.setOnItemClickListener(myItemClickListener);
        return myArtistView;
    }

}
