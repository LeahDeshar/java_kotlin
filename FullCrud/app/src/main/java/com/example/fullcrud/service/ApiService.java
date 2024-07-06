package com.example.fullcrud.service;

import com.example.fullcrud.model.Passenger;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/passenger")
    Call<List<Passenger>> getPassengers();
}
