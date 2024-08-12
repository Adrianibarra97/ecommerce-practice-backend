import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.3.2"
  id("io.spring.dependency-management") version "1.1.6"
  kotlin("jvm") version "1.9.24"
  kotlin("plugin.spring") version "1.9.24"
  jacoco
  war
}

group = "ecommerce"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

val mockkVersion = "1.13.9"
val kotestVersion = "5.8.0"

dependencies {
  //implementation(kotlin("stdlib")) // Comment
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  //implementation("org.springframework.boot:spring-boot-starter-hateoas") // Comment
  implementation("org.springframework.boot:spring-boot-starter-data-rest")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  //implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Comment
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
  implementation("org.springdoc:springdoc-openapi-starter-common:2.2.0")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
  //implementation("org.uqbar-project:geodds-xtend:1.0.3") // Comment
  //implementation("com.google.code.gson:gson:2.8.9") // Comment
  
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  //developmentOnly("org.springframework.boot:spring-boot-docker-compose") // Comment
  
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.mockk:mockk:${mockkVersion}")
  testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
  testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
  
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  
  runtimeOnly("org.postgresql:postgresql")
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.test {
  finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
  dependsOn(tasks.test)
}

jacoco {
  toolVersion = "0.8.11"
}

tasks.jacocoTestReport {
  reports {
    xml.required.set(true)
    csv.required.set(true)
    html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
  }
}

tasks.register("runOnGitHub") {
  dependsOn("jacocoTestReport")
  group = "custom"
  description = "$ ./gradlew runOnGitHub # runs on GitHub Action"
}
