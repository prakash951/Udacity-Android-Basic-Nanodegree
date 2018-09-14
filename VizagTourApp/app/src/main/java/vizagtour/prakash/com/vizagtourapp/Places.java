package vizagtour.prakash.com.vizagtourapp;

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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Places.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Places#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Places extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Places() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Places.
     */
    // TODO: Rename and change types and number of parameters
    public static Places newInstance(String param1, String param2) {
        Places fragment = new Places();
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
        // Inflate the layout for this fragment
        View myPlacesView = inflater.inflate(R.layout.fragment_places, container, false);
        final ArrayList<TourItem> myPlacesList = new ArrayList<>();
        final ArrayList<Location> myLocationList = new ArrayList<>();
        myPlacesList.add(new TourItem(R.drawable.kailasagiri, R.string.kailash, R.string.kaddress));
        myLocationList.add(new Location(17.7487645, 83.3368776));
        myPlacesList.add(new TourItem(R.drawable.simhachalam, R.string.narasimhatemple, R.string.narasimhatempleaddress));
        myLocationList.add(new Location(17.7664188, 83.2486442));
        myPlacesList.add(new TourItem(R.drawable.tennatipark1, R.string.park, R.string.parkaddress));
        myLocationList.add(new Location(17.7503218, 83.3471124));
        myPlacesList.add(new TourItem(R.drawable.beach, R.string.beach, R.string.beachaddress));
        myLocationList.add(new Location(17.7178791, 83.3294085));
        myPlacesList.add(new TourItem(R.drawable.zoopark, R.string.zoo, R.string.zooaddress));
        myLocationList.add(new Location(17.7678758, 83.3432348));
        TourItemAdapter myTourItemAdapter = new TourItemAdapter(getActivity(), 0, myPlacesList);
        ListView myPlacesListView = myPlacesView.findViewById(R.id.places_list);
        myPlacesListView.setAdapter(myTourItemAdapter);
        myPlacesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String keyword = getString(myPlacesList.get(i).getName());
                Uri uri = Uri.parse("geo:" + myLocationList.get(i).getLatitude() + "," + myLocationList.get(i).getLongitude() + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        return myPlacesView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
