package vizagtour.prakash.com.vizagtourapp;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FestivalAdapter extends RecyclerView.Adapter<FestivalAdapter.FestivalViewHolder> {

    ArrayList<TourItem> myFestivals;

    public FestivalAdapter(ArrayList<TourItem> myFestivals) {
        this.myFestivals = myFestivals;
    }

    @NonNull
    @Override
    public FestivalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myFestivalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.festival_layout, viewGroup, false);
        return new FestivalViewHolder(myFestivalView);
    }

    @Override
    public void onBindViewHolder(@NonNull FestivalViewHolder festivalViewHolder, int i) {
        TourItem myFestivalItem = myFestivals.get(i);
        festivalViewHolder.festivalName.setText(myFestivalItem.getName());
        festivalViewHolder.festivalDescription.setText(myFestivalItem.getAddress());
    }

    @Override
    public int getItemCount() {
        return myFestivals.size();
    }

    public class FestivalViewHolder extends RecyclerView.ViewHolder
    {
        TextView festivalName, festivalDescription;
        public FestivalViewHolder(@NonNull View itemView) {
            super(itemView);
            festivalName = itemView.findViewById(R.id.festival_name);
            festivalDescription = itemView.findViewById(R.id.festival_desc);
        }
    }

}
