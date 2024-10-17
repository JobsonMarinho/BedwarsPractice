plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.kaydeesea.bwp"
version = "1.9"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://libraries.minecraft.net")
    maven("https://maven.enginehub.org/repo/")
    maven("https://maven.citizensnpcs.co/repo")
    maven("https://repo.andrei1058.dev/releases/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.glaremasters.me/repository/concuncan/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    implementation("commons-codec:commons-codec:1.15")
    implementation("commons-io:commons-io:2.11.0")
    implementation("com.intellij:annotations:12.0")
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("com.mojang:brigadier:1.0.18")
    implementation(files("lib/BambooLib-1.0-SNAPSHOT.jar"))

    compileOnly("net.citizensnpcs:citizens-main:2.0.35-SNAPSHOT")
    compileOnly("com.sk89q.worldedit:worldedit-core:6.1.4-SNAPSHOT")
    compileOnly("com.sk89q.worldedit:worldedit-bukkit:6.1.4")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("org.github.paperspigot:paperspigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly("com.grinderwolf:slimeworldmanager-api:2.2.1")

    compileOnly(files("lib/BedWars1058.jar"))
    compileOnly(files("lib/Bedwars-2023.jar"))
}

tasks {


    processResources {
        from("src/main/resources") {
            exclude("fonts/**")
        }
        filesMatching("**/*.otf") {
            filteringCharset = "UTF-8"
        }
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    shadowJar {
        archiveBaseName.set("BedWarsPractice")
        archiveClassifier.set("")
        archiveVersion.set("")
    }
    build {
        dependsOn(shadowJar)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
