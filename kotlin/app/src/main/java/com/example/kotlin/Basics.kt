package com.example.kotlin

import java.util.Scanner

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


//fun objectOperation(){
//
//}
    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    fun taskOne(){
//    user input
    val a = Scanner(System.`in`);
    val b = Scanner(System.`in`);
    println("Enter two numbers");
    val x =a.nextInt()
    val y=b.nextInt()
    println(x / y)
    print(x % y)

}
    fun taskTwo(){
//        area and perimeter of circle
        val r = Scanner(System.`in`);
        println("Enter radius");
        val radius =r.nextInt()
        val area = 3.14 * radius * radius
        val perimeter = 2 * 3.14 * radius
        println("Area is $area")
        println("Perimeter is $perimeter")

    }
    fun taskThree(){}


}

