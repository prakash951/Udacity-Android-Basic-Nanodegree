package vizagtour.prakash.com.vizagtourapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpensiveRestaurantsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExpensiveRestaurantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpensiveRestaurantsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExpensiveRestaurantsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpensiveRestaurantsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpensiveRestaurantsFragment newInstance(String param1, String param2) {
        ExpensiveRestaurantsFragment fragment = new ExpensiveRestaurantsFragment();
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
        View myRestaurantView = inflater.inflate(R.layout.fragment_restaurants, container, false);
        RecyclerView myRestaurantRecyclerView = myRestaurantView.findViewById(R.id.recycler);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
        myRestaurantRecyclerView.setLayoutManager(myLayoutManager);
        ArrayList<TourItem> myTourItemList = new ArrayList<>();
        myTourItemList.add(new TourItem(R.drawable.restaurant6, R.string.restaurant6, R.string.restaurant6address));
        myTourItemList.add(new TourItem(R.drawable.restaurant7, R.string.restaurant7, R.string.restaurant7address));
        myTourItemList.add(new TourItem(R.drawable.restauran8, R.string.restaurant8, R.string.restaurant8address));
        myTourItemList.add(new TourItem(R.drawable.restaurant9, R.string.restaurant9, R.string.restaurant9address));
        myTourItemList.add(new TourItem(R.drawable.restaurant10, R.string.restaurant10, R.string.restaurant10address));
        RestaurantAdapter myRestaurantAdapter = new RestaurantAdapter(myTourItemList);
        myRestaurantRecyclerView.setAdapter(myRestaurantAdapter);
        return myRestaurantView;
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
