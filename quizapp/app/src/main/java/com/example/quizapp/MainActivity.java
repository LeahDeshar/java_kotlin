package com.example.quizapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    QuizViewModel quizViewModel;
    List<Question> questionList;



    static int result = 0;
    static int totalQuestions = 0;
    int i =0 ;


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


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        result =0;
        totalQuestions = 0;


        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);

        DisplayFirstQuestion();
    }
    public void DisplayFirstQuestion(){
        quizViewModel.getQuestionListLiveData().observe(this, new Observer<QuestionList>() {
            @Override
            public void onChanged(QuestionList questions) {
                questionList = questions;
                binding.txtQuestion.setText("Question 1: " +questions.get(0).getQuestion());
                binding.radioButton1.setText(questions.get(0).getOption1());
                binding.radioButton2.setText(questions.get(0).getOption2());
                binding.radioButton3.setText(questions.get(0).getOption3());
                binding.radioButton4.setText(questions.get(0).getOption4());
//                binding.setMainActivity(MainActivity.this);
            }
        });
    }
}