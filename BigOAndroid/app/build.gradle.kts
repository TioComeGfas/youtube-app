plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
}

val packageApp: String = "cl.fredy.moncada.app.bigo"
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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.versions.compose.extension.version.get().toString()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.toVersion(libs.versions.java.version.get().toString())
            targetCompatibility = JavaVersion.toVersion(libs.versions.java.version.get().toString())
        }

        kotlinOptions {
            jvmTarget = libs.versions.java.version.get().toString()
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

dependencies {

    implementation(libs.bundles.kotlin)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.composeIcons)
    implementation(libs.bundles.composeNavigation)

    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.android.test)
}