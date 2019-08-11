import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

androidExtensions {
    isExperimental = true
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.1")


    defaultConfig {
        applicationId = "com.example.simpleapp"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    kapt.correctErrorTypes = true
    lintOptions.isAbortOnError = false
    dataBinding.isEnabled = true
    dataBinding.isEnabledForTests = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.41")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.41")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.recyclerview:recyclerview:1.0.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.lifecycle:lifecycle-reactivestreams:2.0.0")
    kapt("androidx.lifecycle:lifecycle-compiler:2.0.0")

    implementation("androidx.fragment:fragment-testing:1.1.0-rc01")
    implementation("androidx.fragment:fragment:1.1.0-rc01")
    implementation("androidx.fragment:fragment-ktx:1.1.0-rc01")

    // Epoxy
    implementation("com.airbnb.android:epoxy:3.7.0")
    implementation("com.airbnb.android:epoxy-paging:3.7.0")
    implementation("com.airbnb.android:epoxy-databinding:3.7.0")
    kapt("com.airbnb.android:epoxy-processor:3.7.0")

    // MvRx
    implementation("com.airbnb.android:mvrx:1.0.2")
    implementation("com.airbnb.android:mvrx-testing:1.0.2")

    // AssistedInject
    implementation("com.squareup.inject:assisted-inject-annotations-dagger2:0.4.0")
    kapt("com.squareup.inject:assisted-inject-processor-dagger2:0.4.0")

    // Moshi
    implementation("com.squareup.moshi:moshi:1.8.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.8.0")

    // Okhttp
    implementation("com.squareup.okhttp3:okhttp:4.0.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.0.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.0")

    // Rx
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.0")
    implementation("com.afollestad:rxkprefs:1.2.5")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-rx2:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.2.1")


    // Navigation
    implementation("androidx.navigation:navigation-ui-ktx:2.1.0-beta02")
    implementation("androidx.navigation:navigation-fragment-ktx:2.1.0-beta02")

    // Room
    implementation ("androidx.room:room-runtime:2.1.0")
    implementation ("androidx.room:room-runtime:2.1.0")
    kapt ("androidx.room:room-compiler:2.1.0")
    implementation ("androidx.room:room-ktx:2.1.0")

    // Dagger
    implementation ("com.google.dagger:dagger:2.24")
    kapt ("com.google.dagger:dagger-compiler:2.24")
    implementation ("com.google.dagger:dagger-android-support:2.24")
    kapt ("com.google.dagger:dagger-android-processor:2.24")

    // Using Dagger in androidTest and Robolectric too
    kaptAndroidTest("com.google.dagger:dagger-compiler:2.24")
    kaptTest ("com.google.dagger:dagger-compiler:2.24")


    testImplementation("junit:junit:4.12")

    // Core library
    testImplementation ("androidx.test:core:1.2.0")

    // AndroidJUnitRunner and JUnit Rules
    testImplementation ("androidx.test:runner:1.2.0")
    testImplementation ("androidx.test:rules:1.2.0")

    // Assertions
    testImplementation ("androidx.test.ext:junit:1.1.1")
    testImplementation ("androidx.test.ext:truth:1.2.0")
    testImplementation ("com.google.truth:truth:0.46")

    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

}
