plugins {
    id("com.android.application")
    kotlin("android")

    //kapt
    kotlin("kapt")

    //Navigation Safe Args
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.rickandmorty"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    //Core
    implementation("androidx.core:core-ktx:1.7.0")

    //AddCompact
    implementation("androidx.appcompat:appcompat:1.4.1")

    //MaterialDesign
    implementation("com.google.android.material:material:1.5.0")

    //Ui Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Retrofit
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:4.9.3")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    //Lifecycle
    val lifecycle_version = "2.5.0-alpha04"
    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    //Navigation Component
    val nav_version = "2.4.1"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.13.0")

    //ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3")

    //Room
    val roomVersion = "2.4.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // Koin for Android
    val koin_version = "3.2.0-beta-1"
    implementation("io.insert-koin:koin-android:$koin_version")
}


