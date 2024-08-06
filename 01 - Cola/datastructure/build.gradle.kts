plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

val groupLibrary = "cl.tiocomegfas.lib"
val nameLibrary = "datastructure"
val versionLibrary = "1.0.0"

android {
    namespace = "${groupLibrary}.${nameLibrary}"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.version.get().toString())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.version.get().toString())
    }

    kotlinOptions {
        jvmTarget = libs.versions.java.version.get().toString()
    }
}

dependencies {
    implementation(libs.bundles.kotlin)

    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.android.test)
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            this.groupId = groupLibrary.toString()
            this.artifactId = nameLibrary.toString()
            this.version = versionLibrary.toString()
            afterEvaluate {
                artifact(tasks["bundleReleaseAar"])
                //artifact(sourcesJar).apply { classifier = "sources" }
            }
        }
    }
}