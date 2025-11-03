package com.example.kot_start

fun main(){



    //----------- Set and map
    var a= setOf<Int>(1,3,3,4,5,6,4,5,9,2)
    println(a)

    for(num in a ){
        println(num)
    }
    var b= setOf<Int>(1, 4, 5, 6, 2, 9)
    print(a==b)


    var c= listOf<Int>(1,2,3)
    var d= mutableListOf(1,2,3)
    d.add(2);
    print(d)


    var e= mapOf("Nepal" to "katjmandu", "India" to "Delhi")

    println(e["Nepal"])

//    Create a Dictionary app using mapOf() function where user will type a word and your program should return the meaning of that word.

    var dict= mapOf("Complete" to "To finish a task","colleague" to "one of a group of people who work together", "skibidi" to "a word that can have different meanings such as \"cool\" or \"bad\", or can be used with no real meaning as a joke")
println("Enter Word")
    var input= readLine()
    println(dict[input])

var num1= 100
var num2= 200
var num3= 300
    println(num1+num2)
    num3+=num1
    println(num3)
    print(-num3)
    print(num2++)
    print(num2)

    var result:Int = 10+2*4
    println(result)


    var myCharRange= 'a'..'z'
//println(myCharRange)
    for(char in myCharRange){
        println(char)
    }

var rangechar= "a".rangeTo("f");
    print(rangechar)
}
