import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins { kotlin("jvm") }

kotlin {
  explicitApi()
  compilerOptions { jvmTarget = JvmTarget.JVM_17 }
}

tasks.test {
  useJUnitPlatform()
}
