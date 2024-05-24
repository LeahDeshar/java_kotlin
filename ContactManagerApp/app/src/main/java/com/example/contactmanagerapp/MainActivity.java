package com.example.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contacts = new ArrayList<>();

    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler clickHandler;

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


        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clickHandler = new MainActivityClickHandler(this);
        mainBinding.setClickHandler(clickHandler);


        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        myAdapter = new MyAdapter(contacts);
        contactDatabase = ContactDatabase.getDatabaseInstance(this);


        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        Contacts c1 = new Contacts(1, "John Doe", "john@gmail.com");
        myViewModel.addContact(c1);


        myViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {

                for (Contacts c : contacts) {
                    Log.v("TAGY ",c.getName());
                }
//                myAdapter.setContacts((ArrayList<Contacts>) contacts);
            }
        });

        recyclerView.setAdapter(myAdapter);
    }
}