package com.example

// 1. Tell Kotlin there’s a native method implemented in a shared library:
class ReverseLib {
    init {
        // 2. Load the shared library. Name “reverse_jni” → OS finds libreverse_jni.so / reverse_jni.dll
        System.loadLibrary("reverse_jni")
    }

    // 3. Declare the native method signature. The “external” tells Kotlin to lookup a JNI function:
    external fun reverseString(input: String): String
}