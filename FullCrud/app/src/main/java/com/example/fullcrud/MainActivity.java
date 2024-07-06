package com.example.fullcrud;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fullcrud.model.Passenger;
import com.example.fullcrud.service.ApiService;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
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
        textView = findViewById(R.id.textView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.4:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<Passenger>> call = apiService.getPassengers();
        call.enqueue(new Callback<List<Passenger>>() {
            @Override
            public void onResponse(Call<List<Passenger>> call, Response<List<Passenger>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                List<Passenger> passengers = response.body();
                StringBuilder formattedResult = new StringBuilder();
                for (Passenger passenger : passengers) {
                    formattedResult.append("ID: ").append(passenger.getPassenger_id())
                            .append(", Name: ").append(passenger.getPassenger_name())
                            .append(", Info: ").append(passenger.getContact_info())
                            .append("\n");
                }
                textView.setText(formattedResult.toString());
            }

            @Override
            public void onFailure(Call<List<Passenger>> call, Throwable t) {
                textView.setText(t.getMessage());
                Log.e("RetrofitError", t.getMessage(), t);
            }
        });
    }

}