package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeArrayList;

    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape shape1 = new Shape(R.drawable.cube, "Cube");
        Shape shape2 = new Shape(R.drawable.prism, "Prism");
        Shape shape3 = new Shape(R.drawable.sphere, "Sphere");
        Shape shape4 = new Shape(R.drawable.cylinder, "Cylinder");


        shapeArrayList.add(shape1);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);
        shapeArrayList.add(shape4);

        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), Sphere.class);

                if(position == 0){
                    i = new Intent(getApplicationContext(), Cube.class);
                }
                if(position == 1){
                    i = new Intent(getApplicationContext(), Prism.class);
                }
                if(position == 2){
                    i = new Intent(getApplicationContext(), Sphere.class);
                }
                if(position == 3){
                    i = new Intent(getApplicationContext(), Cylinder.class);
                }

                startActivity(i);
            }
        });

    }
}