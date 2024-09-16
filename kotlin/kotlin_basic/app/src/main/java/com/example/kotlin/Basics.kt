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
    fun taskThree(){
//        swap two numbers
        val a = Scanner(System.`in`);
        val b = Scanner(System.`in`);
        println("Enter two numbers");
        var x =a.nextInt()
        var y=b.nextInt()
        var temp = x
        x = y
        y = temp
        println("After swapping x is $x and y is $y")
    }
    fun taskFour(){
//        count the letter,spaces and digits and other characters in a sentence
        val s = Scanner(System.`in`);
        println("Enter a sentence");
        val sentence =s.nextLine()
        var letter = 0
        var space = 0
        var digit = 0
        var other = 0
        for (i in sentence){
            if(i.isLetter()){
                letter++
            }else if(i.isDigit()){
                digit++
            }else if(i.isWhitespace()){
                space++
            }else{
                other++
            }
        }
        println("Letters: $letter")
        println("Digits: $digit")
        println("Spaces: $space")
        println("Other characters: $other")

    }
    fun taskFive(){
//        program to reverse the string
        val s = Scanner(System.`in`);
        println("Enter a sentence");
        val sentence =s.nextLine()
        var reverse = ""
        for (i in sentence.length-1 downTo 0){
            reverse += sentence[i]
        }
        println("Reversed sentence: $reverse")
    }
    fun taskSix(){
//        program to multiply corresponding elements from two arrays
        val a = Scanner(System.`in`);
        val b = Scanner(System.`in`);
        println("Enter the size of the arrays");
        val size =a.nextInt()
        val arr1 = IntArray(size)
        val arr2 = IntArray(size)
        println("Enter the elements of the first array");
        for (i in 0 until size){
            arr1[i] = b.nextInt()
        }
        println("Enter the elements of the second array");
        for (i in 0 until size){
            arr2[i] = b.nextInt()
        }
        val result = IntArray(size)
        for (i in 0 until size){
            result[i] = arr1[i] * arr2[i]
        }
        println("Resultant array is: ")
        for (i in 0 until size){
            print("${result[i]} ")
        }
    }
    fun taskSeven(){
//        program to count the numbers of even and odd in the array
        val a = Scanner(System.`in`);
        println("Enter the size of the array");
        val size =a.nextInt()
        val arr = IntArray(size)
        println("Enter the elements of the array");
        for (i in 0 until size){
            arr[i] = a.nextInt()
        }
        var even = 0
        var odd = 0
        for (i in 0 until size){
            if(arr[i] % 2 == 0){
                even++
            }else{
                odd++
            }
        }
        println("Number of even numbers: $even")
        println("Number of odd numbers: $odd")
    }
    fun taskEight(){
//        program that takes 3 numbers from user and find  the greatest among them
        val a = Scanner(System.`in`);
        println("Enter three numbers");
        val x =a.nextInt()
        val y =a.nextInt()
        val z =a.nextInt()
        if(x > y && x > z){
            println("$x is the greatest")
        }else if(y > x && y > z){
            println("$y is the greatest")
        }else{
            println("$z is the greatest")
        }
    }
}

