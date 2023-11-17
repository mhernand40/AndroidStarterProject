plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.hiltAndroidGradlePlugin)
  alias(libs.plugins.jetbrainsKotlinAndroid)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.starter.message"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
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
  api(projects.modules.message.public)

  implementation(libs.hiltAndroid)

  ksp(libs.hiltCompiler)
}
