package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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


//        set the onItemClickListener for the GridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the planet at the clicked position
                Planet planet = (Planet) parent.getItemAtPosition(position);
                // Show a toast with the planet name
                Intent intent = new Intent(CustomGV.this, Display.class);

                // Attach the data to the Intent
                intent.putExtra("title", planet.getPlanetName());
                intent.putExtra("description", planet.getDesc());
                intent.putExtra("imageResourceId", planet.getPlanetImage());

                // Start the Display activity
                startActivity(intent);
                Toast.makeText(CustomGV.this, planet.getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}