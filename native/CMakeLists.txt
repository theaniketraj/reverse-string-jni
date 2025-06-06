# reverse-string-jni/native/CMakeLists.txt

cmake_minimum_required(VERSION 3.10)
project(ReverseLib CXX)

# 1. Find the JNI package (so we can locate jni.h / link against it)
find_package(JNI REQUIRED)

# 2. Specify where our source files live:
set(NATIVE_SRC
    src/reverse_lib.cpp
)

# 3. Create a library target named "reverse_jni"
#    SHARED means build a .so/.dll/.dylib (platform-specific)
add_library(reverse_jni SHARED ${NATIVE_SRC})

# 4. Instruct CMake to include the JNI headers for compilation:
target_include_directories(reverse_jni PRIVATE ${JNI_INCLUDE_DIRS})

# 5. Link the JVM’s native library (this is usually only needed on Windows; 
#    on Linux/macOS the loader finds libjvm.so/libjvm.dylib at runtime)
target_link_libraries(reverse_jni PRIVATE ${JNI_LIBRARIES})

# 6. (Optional) Set a version number or a library output name if you like:
#    set_target_properties(reverse_jni PROPERTIES
#        VERSION 1.0
#        OUTPUT_NAME "reverse"
#    )
