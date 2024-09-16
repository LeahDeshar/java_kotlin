package com.example.tutorial;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Default is vertical

        // Use this line for horizontal orientation
        // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Create an ArrayList and add sample data
        List<Planet> items = new ArrayList<>();
        items.add(new Planet("Mercury", "Mercury is the smallest planet in our solar system.", R.drawable.mercury));
items.add(new Planet("Venus", "Venus is the second planet from the Sun.", R.drawable.venus));
items.add(new Planet("Earth", "Earth is the third planet from the Sun.", R.drawable.earth));
items.add(new Planet("Mars", "Mars is the fourth planet from the Sun.", R.drawable.mars));
items.add(new Planet("Jupiter", "Jupiter is the fifth planet from the Sun.", R.drawable.jupiter));
items.add(new Planet("Saturn", "Saturn is the sixth planet from the Sun.", R.drawable.saturn));
items.add(new Planet("Uranus", "Uranus is the seventh planet from the Sun.", R.drawable.uranus));

        // Create a CustomAdapter
        CustomeRecyclerAdapter adapter = new CustomeRecyclerAdapter(this, items);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }
}