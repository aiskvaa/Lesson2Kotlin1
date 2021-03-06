plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("androidx.navigation.safeargs") version "2.4.1" apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}