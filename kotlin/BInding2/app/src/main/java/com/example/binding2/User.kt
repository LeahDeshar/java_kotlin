package com.example.binding2

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User: BaseObservable() {
    @Bindable
    var name:String = ""
        set(value){
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var age:Int = 0
        set(value){
            field = value
            notifyPropertyChanged(BR.age)
        }

//    val ageString: String
//        get() = age.toString()
}
