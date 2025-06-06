plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // No additional dependencies needed for basic JNI usage
}

application {
    // The Kotlin entry point:
    mainClass.set("com.example.MainKt")
}

// Make sure Kotlin/Gradle knows where to find the native library at runtime.
// On Linux/Mac, this is LD_LIBRARY_PATH; on Windows, PATH.
tasks.run {
    // Suppose CMake is configured to put the compiled .so / .dll in:
    // ../native/build/reverse_jni (modify as needed)
    doFirst {
        // Adjust “nativeLibDir” to match where CMake places the shared object
        val nativeLibDir = file("../native/build").absolutePath
        if (System.getProperty("os.name").lowercase().contains("win")) {
            // Windows: set PATH so .dll can be found
            environment("PATH", "$nativeLibDir;${System.getenv("PATH")}")
        } else {
            // Linux/macOS: set LD_LIBRARY_PATH so .so / .dylib can be found
            environment("LD_LIBRARY_PATH", nativeLibDir)
        }
    }
}