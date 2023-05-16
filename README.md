Access the docs [here](https://rahuls-organization-3.gitbook.io/instasell-livestreaming-android-app-integration/)

# Integrating the Instasell Livestreaming player app to your existing Android application (overview)

The example app shown here is built using Jetpack Compose and Kotlin. The dependencies used to create this app are:

* Retrofit (data fetching library) - [https://square.github.io/retrofit/](https://square.github.io/retrofit/)&#x20;
* Coil (image library) - [https://coil-kt.github.io/coil/](https://coil-kt.github.io/coil/)
* Compose Navigation - [https://developer.android.com/jetpack/compose/navigation](https://developer.android.com/jetpack/compose/navigation)
* Hilt Navigation (for navigation in jetpack compose app) - [https://developer.android.com/jetpack/androidx/releases/hilt](https://developer.android.com/jetpack/androidx/releases/hilt)
* LiveData (observable data holder) - [https://developer.android.com/reference/androidx/lifecycle/LiveData](https://developer.android.com/reference/androidx/lifecycle/LiveData)
* ViewModel (screen level state holder) - [https://developer.android.com/topic/libraries/architecture/viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* Dagger Hilt (simplified dependency injection) - [https://dagger.dev/hilt/](https://dagger.dev/hilt/)

To add these dependencies to your project, add the following to the dependencies in your `app/build.gradle`:

```groovy
    // Retrofit2
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

    // Coil
    implementation "io.coil-kt:coil-compose:1.4.0"

    // Compose Navigation
    implementation 'androidx.navigation:navigation-compose:2.5.3'

    // Hilt Navigation
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'

    // LiveData
    implementation "androidx.compose.runtime:runtime-livedata:1.3.1"

    // ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"

    // Dagger Hilt
    implementation "com.google.dagger:hilt-android:2.43.2"
    implementation 'androidx.core:core-ktx:+'
    implementation 'androidx.core:core-ktx:+'
    kapt "com.google.dagger:hilt-android-compiler:2.43.2"
```

