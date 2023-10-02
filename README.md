# iPizza for Android
The ultimate app for ordering the most delicious pizza in your town

# Technical requirements

- Programming language: Kotlin
- Tool for working with the network: Retrofit
- Tool for working with multithreading: RxJava3
- Database: Room
- UI layer architecture:
    - Single Activity. Transitions between screens should be done using the FragmentManager. When using Android Navigation and tamimattafi.android-navigation-manager is prohibited, only self-written ones.
    - MVVM (but the interaction between the fragment and the ViewModel must be through Rx)
- Dependency Injection Tool: Dagger2
- Architecture of the entire application: Clean Architecture built on multi-modularity.
