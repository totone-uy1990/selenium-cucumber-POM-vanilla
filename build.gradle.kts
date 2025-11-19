plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    // 🔑 Dependencias Centrales de TestNG
    testImplementation("org.testng:testng:7.9.0") // ¡Framework de TestNG!

    // 🥒 Dependencias de Cucumber (Versiones iguales y la más reciente)

    // Necesario para tus Step Definitions
    testImplementation("io.cucumber:cucumber-java:7.14.0")

    // NECESARIO: El bridge (puente) de Cucumber para TestNG
    testImplementation("io.cucumber:cucumber-testng:7.14.0")

    // testImplementation("io.cucumber:cucumber-junit:7.14.0")
    // 🌐 Dependencia de Selenium
    testImplementation("org.seleniumhq.selenium:selenium-java:4.15.0")

    // ❌ Puedes eliminar la dependencia duplicada/antigua que tenías
    // testImplementation("io.cucumber:cucumber-java:7.9.0")
    // testImplementation("io.cucumber:cucumber-testng:7.9.0")

    implementation("com.aventstack:extentreports:5.1.1")
// Usa la versión estable más reciente

    implementation("tech.grasshopper:extentreports-cucumber7-adapter:1.10.1")
// El número 7 es para Cucumber 7+
}




tasks.named<Test>("test") {
    useTestNG()
    systemProperty("cucumber.options", System.getProperty("cucumber.options") ?: "")
}

