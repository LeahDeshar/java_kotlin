package com.example.binding2

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(): BaseObservable() {
    @get:Bindable
    val name:String = ""

    @get:Bindable
    val age:Int = 0

    
    val ageString: String
        get() = age.toString()
}
