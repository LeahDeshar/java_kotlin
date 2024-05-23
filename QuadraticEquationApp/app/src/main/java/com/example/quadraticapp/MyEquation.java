package com.example.quadraticapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticapp.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    String a;
    String b;
    String c;

    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {

    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }


    public void solveEquation(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());


    }

}
