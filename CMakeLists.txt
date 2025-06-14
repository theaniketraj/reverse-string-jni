# reverse-string-jni/CMakeLists.txt
cmake_minimum_required(VERSION 3.10)
project(ReverseStringJNI)

cmake -G "Visual Studio 16 2019" -A x64 -DCMAKE_BUILD_TYPE=Debug -SD:/ceie/reverse-string-jni -Bd:/ceie/reverse-string-jni/build

# Build the native library in the `native/` subdirectory:
add_subdirectory(native)