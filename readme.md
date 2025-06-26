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

### 1. Build the native library

```bash
cd native
mkdir build && cd build
cmake -G "MinGW Makefiles" ..   # Or use your platform's generator
cmake --build .
```

### 2. Run the Kotlin app

```bash
cd ../../kotlin
./gradlew run
```

**Example Output:**

```pgsql
Original: Hello JNI
Reversed: INJ olleH
```

## Testing

### Unit Test (Kotlin side)

Add a simple JUnit test in `kotlin/src/test/kotlin/com/example/ReverseLibTest.kt`:

```kotlin
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
```

Run the test:

```bash
cd kotlin
./gradlew test
```

### Manual Testing

Launch the app as above (`./gradlew run`) with different inputs in `Main.kt`.

Modify `Main.kt` to reverse other strings and confirm the console output.

### Logging

- In C++ (`reverse_lib.cpp`), add `std::cout` statements before and after reversal to trace behavior.
- Rebuild and rerun to see logs in the terminal.

These steps ensure the native library is properly built, loaded, and that JNI bridging works as expected.

## Troubleshooting

### `cmake: command not found`

If you see:

```bash
bash: cmake: command not found
```

Your terminal cannot locate the cmake executable. Try the following:

#### 1. Install CMake

- **Windows:** Download and run the installer from [cmake.org](https://cmake.org/download/) and select "Add CMake to the system PATH".
- **macOS:**
  
  ```bash
  brew install cmake
  ```

- **Linux (Ubuntu/Debian):**
  
  ```bash
  sudo apt update
  sudo apt install cmake
  ```

#### 2. Restart your terminal so that the updated PATH takes effect

#### 3. Verify installation

```bash
cmake --version
```

You should see the version details.

#### 4. Re-run the build

```bash
cd native/build
cmake --build .
```

## License

MIT License. See [LICENSE](https://github.com/theaniketraj/reverse-string-jni/blob/main/LICENSE)
