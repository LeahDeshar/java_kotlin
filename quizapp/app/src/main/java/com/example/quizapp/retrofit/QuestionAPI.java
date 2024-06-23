package com.example.quizapp.retrofit;

import com.example.quizapp.model.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionAPI {

    @GET("quiz")
    Call<QuestionList> getQuestions();
}
