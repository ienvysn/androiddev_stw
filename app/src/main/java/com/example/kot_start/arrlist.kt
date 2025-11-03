package com.example.kot_start

fun main(){
    
    var a= arrayOf(1,2,3)
    println(a)
    println(a[0])

    var b= arrayOf<String>("test","wowow")
    println(b[0])


    var c= arrayListOf<String>("abc","def");
    println(c[0])
    c.add("text")
    println("${c[0]}, ${c[1]},${c[2]}")
    c.add(1,"this is no 1")
    print("${c[0]}, ${c[1]},${c[2]}")
}