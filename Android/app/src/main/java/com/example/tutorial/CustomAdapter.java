package com.example.tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] data;

    public CustomAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View ConvertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (ConvertView == null) {
            viewHolder = new ViewHolder();
            // Inflate the layout here
            ConvertView = LayoutInflater.from(context)
                    .inflate( R.layout.custom_list_items, parent ,false);
            // Initialize the views here
            viewHolder.textView = ConvertView.findViewById(R.id.textView);
            ConvertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) ConvertView.getTag();
        }

        // Set the data to the views here
        viewHolder.textView.setText(data[i]);

        return ConvertView;
    }

    static class ViewHolder {
        // Declare the views here
        TextView textView;
    }
}
