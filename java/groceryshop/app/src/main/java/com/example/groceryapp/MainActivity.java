package com.example.groceryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    RecyclerView recyclerView;
    List<Item> itemlist;
    MyAdapter myAdapter;

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
        recyclerView = findViewById(R.id.recyclerView);
        itemlist = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruits, "Fruits", "Fresh Fruits from the garden");
        Item item2 = new Item(R.drawable.vegetable, "Vegetables", "Delicious Vegetables");
        Item item3 = new Item(R.drawable.milk, "Milk", "Milk and Dairy Products");
        Item item4 = new Item(R.drawable.bread, "Bakery", "Bread,Wheat and Beans");
        Item item5 = new Item(R.drawable.beverage, "Beverages", "Juice,Tea,Coffee and Soda");
        Item item6= new Item(R.drawable.popcorn, "Snacks", "Chips,Popcorn and Snacks");

        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);
        itemlist.add(item5);
        itemlist.add(item6);

        //linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(itemlist);
        recyclerView.setAdapter(myAdapter);


        myAdapter.setItemClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Choose: " + itemlist.get(pos), Toast.LENGTH_SHORT).show();
    }
}