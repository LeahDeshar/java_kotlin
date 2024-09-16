package com.example.tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Planet> planets;

    public CustomGridViewAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int i) {
        return planets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context)
                    .inflate( R.layout.custom_grid_items, viewGroup ,false);

            holder.PlanetName = view.findViewById(R.id.PlanetName);
            holder.Desc = view.findViewById(R.id.Desc);
            holder.PlanetImage = view.findViewById(R.id.PlanetImage);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the data to the views here
        holder.PlanetName.setText(planets.get(i).getPlanetName());
        holder.Desc.setText(planets.get(i).getDesc());
        holder.PlanetImage.setImageResource(planets.get(i).getPlanetImage());





        return view;
    }

    static class ViewHolder {
        // Declare the views in the layout
        TextView PlanetName;
        TextView Desc;
        ImageView PlanetImage;
    }
}
