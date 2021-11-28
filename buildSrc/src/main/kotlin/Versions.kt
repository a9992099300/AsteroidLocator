object Versions {
    const val compileSdkVersion = 31
    const val targetSdkVersion = 31
    const val minSdkVersion = 21
    const val buildToolsVersion = "30.0.2"

    const val kotlin = "1.6.0"
}

object GradlePlugins {
    private const val androidBuildToolsVersion = "7.0.3"

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val navigationComponentSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Libs.jetpack.navigationComponentVersion}"
}

object Libs {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    val ui = UI
    val androidX = AndroidX
    val jetpack = Jetpack
    val test = Test
    val di = DI
    val network = Network


    object UI {
        private const val materialComponentsVersion = "1.5.0-beta01"
        private const val adapterDelegateVersion = "4.3.0"

        const val materialComponents = "com.google.android.material:material:$materialComponentsVersion"
        const val adapterDelegateKotlinDsl = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapterDelegateVersion"
        const val adapterDelegateKotlinDslLayoutContainer = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:$adapterDelegateVersion"
    }

    object AndroidX {
        private const val constraintLayoutVersion = "2.1.2"
        private const val appCompatVersion = "1.4.0"
        private const val coreKtxVersion = "1.7.0"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    }

    object Jetpack {
        const val navigationComponentVersion = "2.4.0-alpha02"

        const val navigationComponentFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationComponentVersion"
        const val navigationComponentUiKtx = "androidx.navigation:navigation-ui-ktx:$navigationComponentVersion"
    }

    object Test {
        private const val junitVersion = "4.13"
        private const val junitExtVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

    object DI {
        private const val daggerVersion = "2.40.1"

        const val dagger = "com.google.dagger:dagger:$daggerVersion"
        const val daggerKapt = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Network{
        private const val retrofitVersion = "2.9.0"
        private const val jsonVersion = "2.8.7"
        private const val moshiVersion = "1.12.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitConvertorJson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val json =  "com.google.code.gson:gson:$jsonVersion"
        const val moshi ="com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val retrofitConvertorMoshi ="com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }

}