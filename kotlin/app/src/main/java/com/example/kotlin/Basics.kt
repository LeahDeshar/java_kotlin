package com.example.kotlin

class Basics {
    fun BasicOperation(){
        val message = "print message"
        println(message)

        var num:Int;
        num = 3

        num = 4
        val day = when (num){
            1-> "Monday"
            2-> "Tuesday"
            3-> "Wednesday"
            else-> "No day"
        }
        print(day)



        val isValid:Boolean = true

        val name = "Leah"
        if(isValid){
            println("\n $name, It is valid")
        }else{
            println("not valid")
        }


        for(i in 0..5 step 2)
        {
            println(i)
        }

        for(i in 10 downTo 1 step 2)
        {
            println(i)
        }



        repeat(3){
            println("Repeat 3 times")
        }

    }


fun objectOperation(){
    
}

}