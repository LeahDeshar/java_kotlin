package com.example.tutorial;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomGV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_gv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        GridView gridView = findViewById(R.id.gridView);

        // Create an ArrayList and add sample data
        ArrayList<Planet> planet = new ArrayList<>();
        planet.add(new Planet("Mercury", "The smallest planet in our solar system", R.drawable.mercury));
        planet.add(new Planet("Venus", "The second planet from the Sun", R.drawable.venus));
        planet.add(new Planet("Earth", "Our home planet", R.drawable.earth));
        planet.add(new Planet("Jupiter", "Jupiter", R.drawable.jupiter));
        planet.add(new Planet("Saturn", "Saturn", R.drawable.saturn));
        planet.add(new Planet("Uranus", "Uranus", R.drawable.uranus));


        // Create a CustomGridViewAdapter
        CustomGridViewAdapter adapter = new CustomGridViewAdapter(this, planet);

        // Set the adapter to the GridView
        gridView.setAdapter(adapter);


    }
}