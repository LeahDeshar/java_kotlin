package com.example.volumecalculator;

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

public class MyCustomAdapter extends ArrayAdapter<Shape> {
     private ArrayList<Shape> shapeArrayList;
     Context context;

    public MyCustomAdapter(ArrayList<Shape> shapeArrayList, Context context1) {
        super(context1,R.layout.grid_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context1;
    }

//    view holder
    private static class ViewHolder {
    ImageView  shapeImg;
    TextView shapeName;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shapes = getItem(position);
        ViewHolder myViewHolder;

        if (convertView == null) {
            myViewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_layout, parent, false);
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ViewHolder) convertView.getTag();
        }

        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());
        return convertView;
    }
}
