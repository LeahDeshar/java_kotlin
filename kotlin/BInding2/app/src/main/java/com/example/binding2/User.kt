package com.example.binding2

data class User(val name:String ,val age:Int  ){
    val ageString: String
        get() = age.toString()
}