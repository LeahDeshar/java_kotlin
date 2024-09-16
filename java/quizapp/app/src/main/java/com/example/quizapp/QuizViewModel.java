package com.example.quizapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.model.QuestionList;

public class QuizViewModel extends ViewModel {

    QuizRepository repository = new QuizRepository();
    LiveData<QuestionList> questionListLiveData;

    public QuizViewModel(){
        questionListLiveData = repository.getQuestionsFromAPI();
    }



    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
