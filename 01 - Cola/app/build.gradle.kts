plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
}

val packageApp: String = "cl.tiocomegfas.app.example.cola"
val codeApp: Int = 1
val versionApp: String = "1.0.0.${codeApp}"

android {
    namespace = packageApp
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = packageApp
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = codeApp
        versionName = versionApp
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.extension.version.get()
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".dev"
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            testProguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguardTest-rules.pro")
        }
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            testProguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguardTest-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.version.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.version.get())
    }

    kotlinOptions {
        jvmTarget = libs.versions.java.version.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(files("libs/architecture-1.0.0.aar"))
    implementation(project(":datastructure"))
    // Libraries core
    implementation(libs.bundles.kotlin)
    // Compose
    implementation(libs.bundles.compose)
    implementation(libs.bundles.composeIcons)
    implementation(libs.bundles.composeNavigation)

    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.android.test)
}