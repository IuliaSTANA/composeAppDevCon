package org.green.thumb

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.1"
    const val firebaseDistributionPlugin = "com.google.firebase:firebase-appdistribution-gradle:3.0.1"
    const val timberLog = "com.jakewharton.timber:timber:5.0.1"
    const val desugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

    object Accompanist {
        private const val version = "0.24.5-alpha"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.8.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"

        object Compose {
            const val snapshot = ""
            const val version = "1.2.0-beta03"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val ui = "androidx.compose.ui:ui:$version"

            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExt = "androidx.compose.material:material-icons-extended:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val testManifest = "androidx.compose.ui:ui-test-manifest:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
            const val windowSizeClass = "androidx.compose.material3:material3-window-size-class:1.0.0-alpha13"

            object Material3 {
                private const val version = "1.0.0-alpha13"
                const val designMaterial3 = "androidx.compose.material3:material3:$version"
            }

            object Navigation {
                private const val version = "2.4.2"
                const val nav = "androidx.navigation:navigation-compose:$version"
                const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            }
        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Startup {
            private const val version = "1.1.0"
            const val startupRuntime = "androidx.startup:startup-runtime:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object Coil {
        private const val version = "1.3.2"
        const val coilCompose = "io.coil-kt:coil-compose:$version"
    }

    object Firebase {
        private const val version = "29.1.0"
        const val billOfMaterials = "com.google.firebase:firebase-bom:$version"

        //When using BOM do not specify the versions in Firebase library dependencies
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
    }

    object Hilt {
        private const val version = "2.41"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object Kotlin {
        private const val version = "1.6.21"

        const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Material {
        private const val version = "1.5.0"
        const val materialDesign = "com.google.android.material:material:$version"
    }

    object Room {
        private const val version = "2.4.2"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
    }
}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo = "https://androidx.dev/snapshots/builds/" +
            "${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}
