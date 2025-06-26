package com.example

import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseLibTest {
    @Test
    fun testReverseString() {
        System.loadLibrary("reverse_jni")
        val lib = ReverseLib()
        assertEquals("olleh", lib.reverseString("hello"))
    }
}