@file:Suppress("UnstableApiUsage")

plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt.android.gradle.plugin)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.ksp)
}

android {
  buildFeatures { compose = true }

  composeOptions { kotlinCompilerExtensionVersion = libs.androidx.compose.compiler.get().version }

  namespace = "com.starter.message.impl"
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
  testOptions {
    unitTests.all { it.useJUnitPlatform() }
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  api(projects.modules.message.public)

  debugImplementation(libs.androidx.compose.ui.tooling)

  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.hilt.android)
  implementation(platform(libs.androidx.compose.bom))

  ksp(libs.hilt.compiler)
}
