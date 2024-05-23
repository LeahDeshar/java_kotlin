package com.example.tutorial;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.tutorial.databinding.ActivityLayoutBindingBinding;

public class LayoutBindingActivity extends AppCompatActivity {
    private ActivityLayoutBindingBinding activityLayoutBindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_layout_binding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Person p1 = new Person("John Doe", "john@gmail.com");
        activityLayoutBindingBinding = DataBindingUtil.setContentView(
                this,R.layout.activity_layout_binding);
        activityLayoutBindingBinding.setPerson(p1);
    }
}