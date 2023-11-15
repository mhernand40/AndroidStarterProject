plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.hiltAndroidGradlePlugin)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.androidxComposeCompiler.get().version
    }

    namespace = "com.starter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.starter"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += "-Xexplicit-api=strict"
    }
}

dependencies {
    implementation(libs.androidxActivityCompose)
    implementation(libs.androidxCoreKtx)
    implementation(libs.material)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.hiltAndroid)
    implementation(platform(libs.androidxComposeBom))

    ksp(libs.hiltCompiler)
}