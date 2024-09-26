package com.example.binding2

import android.content.Context
import android.view.View
import android.widget.Toast

class ViewClickHandler(var context: Context,var user: User) {

    fun btnClick(view: View){
        Toast.makeText(context, "Button Clicked" + user.name + " " + user.ageString, Toast.LENGTH_SHORT).show()
    }
}