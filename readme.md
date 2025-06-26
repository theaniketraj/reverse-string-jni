# Reverse-String-JNI

A demonstration of using Kotlin/JVM with a native C++ library via JNI and CMake to **reverse strings**. This project showcases how to build and integrate a shared native library in a Kotlin application.

## Purpose

- Illustrate setting up a CMake-based native build for JNI.
- Show seamless integration of C++ and Kotlin using `System.loadLibrary`.
- Provide a template for Kotlin Multiplatform-native interop.

## Project Structure

```pgsql
reverse-string-jni/
├── native/                    # Native library module
│   ├── CMakeLists.txt         # CMake configuration
│   └── src/
│       ├── reverse_lib.h      # JNI function declaration
│       └── reverse_lib.cpp    # JNI implementation (string reversal)
├── kotlin/                    # Kotlin/JVM application
│   ├── build.gradle.kts       # Gradle build file
│   └── src/main/kotlin/com/example/
│       ├── ReverseLib.kt      # External JNI interface
│       └── Main.kt            # Entry point demonstrating reversal
├── settings.gradle.kts        # Project settings
├── README.md                  # This file
└── .gitignore                 # Ignored files
```

## Prerequisites

- **CMake** (≥3.10) and a C++ compiler (e.g., MinGW on Windows, gcc/clang on Linux/Mac).
- **JDK 11+** for Kotlin/JVM.
- **Gradle** (wrapper included).

## Build & Run

1. **Build native library**

   ```bash
   cd native
   mkdir build && cd build
   cmake -G "MinGW Makefiles" ..   # Or use your platform's generator
   cmake --build .
   ```

2. **Run Kotlin app**

   ```bash
   cd ../../kotlin
   ./gradlew run
   ```

Output:

```pgsql
Original: Hello JNI
Reversed: INJ olleH
```

## License

MIT License. See [LICENSE](LICENSE) for details.
