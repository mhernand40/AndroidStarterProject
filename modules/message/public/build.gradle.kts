import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins { kotlin("jvm") }

kotlin {
  explicitApi()
  compilerOptions { jvmTarget = JvmTarget.JVM_21 }
}

tasks.test {
  useJUnitPlatform()
}
