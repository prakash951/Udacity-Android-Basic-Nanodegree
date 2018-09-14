package vizagtour.prakash.com.vizagtourapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    ArrayList<TourItem> myRestaurant;

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myRestaurantView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new RestaurantViewHolder(myRestaurantView);
    }

    public RestaurantAdapter(ArrayList<TourItem> myRestaurant) {
        this.myRestaurant = myRestaurant;
    }

    @Override
    public int getItemCount() {
        return myRestaurant.size();
    }


    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        TourItem myTourItem = myRestaurant.get(i);
        restaurantViewHolder.restaurantName.setText(myTourItem.getName());
        restaurantViewHolder.restaurantAddress.setText(myTourItem.getAddress());
        restaurantViewHolder.restaurantImage.setImageResource(myTourItem.getImage());
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView restaurantName, restaurantAddress;
        ImageView restaurantImage;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurant_text);
            restaurantAddress = itemView.findViewById(R.id.restaurant_address);
            restaurantImage = itemView.findViewById(R.id.restaurant_image);
        }
    }
}
