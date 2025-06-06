#ifndef REVERSE_LIB_H
#define REVERSE_LIB_H

#include <jni.h>
#include <string>

// This must match the fully-qualified Kotlin/Java package & class name.
// Suppose our Kotlin class will be: `package com.example; class ReverseLib`
// JNI naming convention: Java_<package>_<class>_<methodName>
// Underscores in package or class names are encoded as `_1`.
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ReverseLib_reverseString(JNIEnv* env, jobject /* this */, jstring input);

#endif // REVERSE_LIB_H