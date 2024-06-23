package com.example.quizapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    String baseURL = "http://127.0.0.1/quiz/";


  /*  create and return a configured retrofit instance*/
    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /*create and return a configured QuestionAPI instance*/
//    public QuestionAPI getQuestionAPI() {
//        return getRetrofitInstance().create(QuestionAPI.class);
//    }
}
