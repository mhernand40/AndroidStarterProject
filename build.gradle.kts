// .top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.hilt.android.gradle.plugin) apply false
  alias(libs.plugins.jetbrains.kotlin.android) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.spotless)
}

spotless {
  kotlin {
    target("**/src/**/kotlin/**/*.kt")
    ktfmt()
  }
  kotlinGradle { ktfmt() }
}
