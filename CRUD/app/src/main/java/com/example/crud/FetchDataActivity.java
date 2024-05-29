package com.example.crud;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FetchDataActivity extends AppCompatActivity {
    TextView tvData;

    Database database;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fetch_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        tvData = findViewById(R.id.tvData);
//        database = new Database(FetchDataActivity.this);
//        tvData.setText("");
//
//        Cursor cursor = database.getAllData();
//        while(cursor.moveToNext()){
//            tvData.append("ID: "+cursor.getString(0)+"\n");
//            tvData.append("Name: "+cursor.getString(1)+"\n");
//            tvData.append("Email: "+cursor.getString(2)+"\n");
//            tvData.append("Password: "+cursor.getString(3)+"\n\n");
//        }


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = new Database(FetchDataActivity.this);
        userList = new ArrayList<>();

        Cursor cursor = database.getAllData();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            userList.add(new User(id, name, email, password));
        }
        cursor.close();

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}