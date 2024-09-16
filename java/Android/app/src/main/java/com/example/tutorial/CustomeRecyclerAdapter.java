package com.example.tutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomeRecyclerAdapter extends RecyclerView.Adapter<CustomeRecyclerAdapter.ViewHolder> {
    private List<Planet> planet;
    private Context context;

    public CustomeRecyclerAdapter(Context context, List<Planet> items) {
        this.context = context;
        this.planet = items;
    }
    @NonNull
    @Override
    public CustomeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeRecyclerAdapter.ViewHolder holder, int position) {
        Planet item = planet.get(position);
        holder.imageView.setImageResource(item.getPlanetImage());
        holder.titleTextView.setText(item.getPlanetName());
        holder.descriptionTextView.setText(item.getDesc());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Display.class);
            intent.putExtra("title", item.getPlanetName());
            intent.putExtra("description", item.getDesc());
            intent.putExtra("imageResourceId", item.getPlanetImage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return planet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
