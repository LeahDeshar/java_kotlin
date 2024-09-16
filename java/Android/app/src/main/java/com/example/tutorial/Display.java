package com.example.tutorial;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//
//        String itemData = getIntent().getStringExtra("item_data");
//
//        // Find the TextView in the layout
//        TextView textView = findViewById(R.id.textView2);
//
//        // Display the data in the TextView
//        if (itemData != null) {
//            textView.setText(itemData);
//        }


        // Retrieve the data from the Intent
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        int imageResourceId = getIntent().getIntExtra("imageResourceId", -1);

        // Find the views in the layout
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView imageView = findViewById(R.id.imageView);

        // Set the data to the views
        titleTextView.setText(title);
        descriptionTextView.setText(description);
        if (imageResourceId != -1) {
            imageView.setImageResource(imageResourceId);
        }
    }
}