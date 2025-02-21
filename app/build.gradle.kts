@file:Suppress("UnstableApiUsage")

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.hilt.android.gradle.plugin)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.compose.compiler)
}

android {
  buildFeatures { compose = true }

  namespace = "com.starter"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.starter"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }
  kotlinOptions {
    jvmTarget = "21"
    freeCompilerArgs += "-Xexplicit-api=strict"
  }
  testOptions {
    unitTests.all { it.useJUnitPlatform() }
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  debugImplementation(libs.androidx.compose.ui.tooling)

  implementation(projects.modules.message.impl)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.view.model.compose)
  implementation(libs.material)
  implementation(libs.hilt.android)
  implementation(platform(libs.androidx.compose.bom))

  ksp(libs.hilt.compiler)
}
