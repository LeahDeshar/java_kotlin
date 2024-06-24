package com.example.quizapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

//    String baseURL = "http://10.0.2.2/quiz/";


    String baseURL = "http://127.0.0.1:3000/quiz/";
  /*  create and return a configured retrofit instance*/
    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
