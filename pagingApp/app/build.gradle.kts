plugins {
    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.hilt)
//    alias(libs.plugins.hiltAndroid)
//    id 'com.google.dagger.hilt.android' version '2.51.1'
}
//apply("com.android.application")
//apply("com.google.dagger.hilt.android")

android {
    namespace = "com.example.pagingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pagingapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.google.code.gson:gson:2.11.0")


    val paging_version = "3.3.0"

    implementation("androidx.paging:paging-runtime:$paging_version")
// optional - RxJava3 support
    implementation("androidx.paging:paging-rxjava3:$paging_version")


    implementation("com.google.dagger:hilt-android:2.51.1")
    annotationProcessor("com.google.dagger:hilt-compiler:2.51.1")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}