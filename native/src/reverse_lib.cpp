#include "reverse_lib.h"
#include <algorithm>

// Helper to convert jstring to std::string
static std::string jstringToStdString(JNIEnv* env, jstring jstr) {
    if (!jstr) return "";

    const char* utfChars = env->GetStringUTFChars(jstr, nullptr);
    std::string result(utfChars);
    env->ReleaseStringUTFChars(jstr, utfChars);
    return result;
}

// Helper to convert std::string back to jstring
static jstring stdStringToJString(JNIEnv* env, const std::string& str) {
    return env->NewStringUTF(str.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ReverseLib_reverseString(JNIEnv* env, jobject /* this */, jstring input) {
    std::string original = jstringToStdString(env, input);
    std::reverse(original.begin(), original.end());
    return stdStringToJString(env, original);
}