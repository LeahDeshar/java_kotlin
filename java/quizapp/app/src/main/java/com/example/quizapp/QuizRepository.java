package com.example.quizapp;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quizapp.model.QuestionList;
import com.example.quizapp.retrofit.QuestionAPI;
import com.example.quizapp.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {

    private QuestionAPI questionAPI;

    public QuizRepository() {
        this.questionAPI = new RetrofitInstance().getRetrofitInstance().create(QuestionAPI.class);
    }

    public LiveData<QuestionList> getQuestionsFromAPI() {
        MutableLiveData<QuestionList> data = new MutableLiveData<>();


        Call<QuestionList> response = questionAPI.getQuestions();
        response.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();
                data.setValue(list);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable throwable) {

            }
        });

        return data;
    }

}
