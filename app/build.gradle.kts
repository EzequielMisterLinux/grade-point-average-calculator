plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.tarea1"
    compileSdk = 34  // Cambiado de 35 a 34

    defaultConfig {
        applicationId = "com.example.tarea1"
        minSdk = 29
        targetSdk = 34  // Cambiado de 35 a 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17  // Actualizado a Java 17
        targetCompatibility = JavaVersion.VERSION_17  // Actualizado a Java 17
    }
    kotlinOptions {
        jvmTarget = "17"  // Actualizado a Java 17
    }

    buildFeatures {
        viewBinding = true  // Añadido para mejor manejo de vistas
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)  // Añadido si usas ConstraintLayout
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}