***Welcome to the "Compose Yourself!" AppDevCon Workshop***

What you need:
- [Android Studio Chipmunk](https://developer.android.com/studio/)
- Working knowledge of Kotlin [idioms](https://developer.android.com/jetpack/compose/kotlin) like
    high order functions, scopes & receivers, etc.

## Repository structure

Each folder is it's own project:
 - [Part01](Part01/README.md): Using composable functions to define compositions and understand 
     recompositions.
 - [Part02](Part02/README.md): Theming, navigation, managing state, state hoisting and
     unidirectional data flow.
 - [Part03](Part03/README.md): Adaptable designs for large screens, different material navigation
     components and optimal screen space usage.

## GreenThumb app

The outcome of the workshop is a sample Compose application making use of:

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [ViewModels](hhttps://developer.android.com/topic/libraries/architecture/viewmodel)
- [Room](https://developer.android.com/training/data-storage/room/)
- [Navigation](https://developer.android.com/jetpack/compose/navigation)
- [Large screen support](https://developer.android.com/jetpack/compose/layouts/adaptive)

The app allows creating an inventory of the plants you have, their description and location. For
each plant a series of care actions can be performed: watering, prunning, repotting, etc. When such
an action is performed it can be saved as an entry log with its corresponding date. The goal being
to allow an overview of all plants and their care logs (last day it was watered, given fertilizer,
etc.).
