object Kotlin {

    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31"
}

object AndroidX {
    private const val appcompat_version = "1.4.0"

    val appcompat = "androidx.appcompat:appcompat:$appcompat_version"
}

object Material {
    private const val material_version = "1.4.0"

    val materialComponents = "com.google.android.material:material:$material_version"
}

object Compose {
    private const val compose_version = "1.0.5"

    val runtime = "androidx.compose.runtime:runtime:$compose_version"
    val ui = "androidx.compose.ui:ui:$compose_version"
    val tooling = "androidx.compose.ui:ui-tooling:$compose_version"
    val foundation = "androidx.compose.foundation:foundation:$compose_version"
    val material = "androidx.compose.material:material:$compose_version"
    val icons = "androidx.compose.material:material-icons-core:$compose_version"
    val iconsExtra = "androidx.compose.material:material-icons-extended:$compose_version"
    val activity = "androidx.activity:activity-compose:$compose_version"
}

object DI {
    private const val koin_version = "3.1.4"

    val core = "io.insert-koin:koin-core:$koin_version"
    val android = "io.insert-koin:koin-android:$koin_version"
    val navigationGraph = "io.insert-koin:koin-androidx-navigation:$koin_version"
    val compose = "io.insert-koin:koin-androidx-compose:$koin_version"
}

object Navigation {
    private val navigation_version = "2.4.0-rc01"

    val navigation = "androidx.navigation:navigation-compose:$navigation_version"
}

object Log {
    private const val timber_version = "5.0.1"

    val timber = "com.jakewharton.timber:timber:$timber_version"
}

object Concurrency {
    private val coroutines_version = "1.6.0"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
}
