plugins {
    id("java")
    id("application")
}

group = "org.learn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Replace with your main class package and name
    mainClass.set("org.learn.Main") // Update with the correct package and class name
}