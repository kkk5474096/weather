plugins {
    id("java-library")
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    KotlinDependencies.run {
        implementation(kotlin)
        implementation(coroutines)
    }
    ThirdPartyDependencies.run {
        implementation(hiltCore)
    }
    KaptDependencies.run {
        kapt(hiltCompiler)
    }
}