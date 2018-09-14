package vizagtour.prakash.com.vizagtourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TourItemAdapter extends ArrayAdapter<TourItem> {

    public TourItemAdapter(@NonNull Context context, int resource, @NonNull List<TourItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.places_layout, parent, false);
        TourItem item = getItem(position);
        ImageView myImageView = convertView.findViewById(R.id.place_image);
        TextView myTextView1 = convertView.findViewById(R.id.location);
        TextView myTextView2 = convertView.findViewById(R.id.address);
        myImageView.setImageResource(item.getImage());
        myTextView1.setText(item.getName());
        myTextView2.setText(item.getAddress());
        return convertView;
    }
}
