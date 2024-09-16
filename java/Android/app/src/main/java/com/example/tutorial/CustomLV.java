package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomLV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_lv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Initialize the ListView
        ListView listView = findViewById(R.id.listView);

        // Sample data
        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        // Create an Custom Adapter
        CustomAdapter adapter = new CustomAdapter(this, data);
        // Set the adapter to the ListView
        listView.setAdapter(adapter);

//        handle click event on listview
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the item that was clicked
            String item = (String) parent.getItemAtPosition(position);
            // Show a toast with the item
            Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CustomLV.this, Display.class);
            intent.putExtra("item_data", item);
            startActivity(intent);
        });

    }
}