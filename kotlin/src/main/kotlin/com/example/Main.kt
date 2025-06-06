package com.example

fun main() {
    val original = "Kotlin + CMake + JNI"
    val reversed = ReverseLib().reverseString(original)
    println("Original: $original")
    println("Reversed: $reversed")
}