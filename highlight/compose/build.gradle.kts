import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mavenPublish)
}

android {
    namespace = "com.neoutils.highlight.compose"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api(project(":highlight:core"))

    // necessary compose dependencies
    api(libs.androidx.runtime) {
        because("obviously")
    }

    api(libs.androidx.ui.text) {
        because("AnnotatedString, SpanStyle, TextFieldValue")
    }

    api(libs.androidx.ui.graphics) {
        because("Color")
    }
}

mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = false,
        )
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(
        groupId = "com.neoutils.highlight",
        artifactId = "highlight-compose",
        version = "2.0.0"
    )

    pom {
        name.set("Highlight for Compose")
        description.set("Pattern highlighter for compose.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")

        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("irineu333")
                name.set("Irineu A. Silva")
                url.set("https://github.com/Irineu333")
            }
        }

        scm {
            url.set("https://github.com/NeoUtils/Highlight")
            connection.set("scm:git:git://github.com/NeoUtils/Highlight.git")
            developerConnection.set("scm:git:ssh://git@github.com/NeoUtils/Highlight.git")
        }
    }

    signAllPublications()
}