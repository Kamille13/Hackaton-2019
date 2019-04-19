package com.example.hackaton2019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class EggAdapteur  extends ArrayAdapter<EggsWins> {

    public EggAdapteur (Context context, List<EggsWins> menu) {
        super(context, 0, menu);
    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO 1 : Get the data item for this position
        EggsWins item = getItem(position);

        // TODO 2 : Check if an existing view is being reused, otherwise inflate the view
        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_stuff, parent, false);
        }
        // TODO 3 : Lookup view for data population
        TextView textName = convertView.findViewById(R.id.tvEggWins);
        ImageView imageEgg = convertView.findViewById(R.id.ivEggWin);

        // TODO 4 : Populate the data into the template view using the data object
        textName.setText(item.getName());
        Glide.with(getContext()).load(item.getUrl()) .into(imageEgg);

        // Return the completed view to render on screen
        return convertView;
    }
}
