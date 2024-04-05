package com.example.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

   private ArrayList<Planet> planetArrayList;
   Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList,
                           Context context1) {
        super(context1, R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context1;
    }


    private static class MyViewHolder {
        private TextView planetName;
        private TextView moonCount;
        private ImageView planetImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Planet planet = getItem(position);
         MyViewHolder myViewHolder;
         final View result;
            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_list_layout,
                        parent, false);
                myViewHolder.planetName =(TextView) convertView.findViewById(R.id.planetName);
                myViewHolder.moonCount =(TextView) convertView.findViewById(R.id.moonCount);
                myViewHolder.planetImage =(ImageView) convertView.findViewById(R.id.planetImage);
            result = convertView;
            convertView.setTag(myViewHolder);

            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
                result = convertView;
            }

            myViewHolder.planetName.setText(planet.getPlanetName());
            myViewHolder.moonCount.setText(planet.getMoonCount());
            myViewHolder.planetImage.setImageResource(planet.getPlanetImage());



            return result;

    }
}
