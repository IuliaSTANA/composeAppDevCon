***Welcome to the "Compose Yourself!" AppDevCon Workshop***

What you need:

- [Android Studio Chipmunk](https://developer.android.com/studio/)

## GreenThumb app

This is a sample application with the UI written in Compose. It also makes use of

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [ViewModels](hhttps://developer.android.com/topic/libraries/architecture/viewmodel)
- [Room](https://developer.android.com/training/data-storage/room/)
- [Navigation](https://developer.android.com/jetpack/compose/navigation)

The app allows creating an inventory of the plants you have, their description and location. For
each plant a series of care actions can be performed: watering, prunning, repotting, etc. When such
an action is performed it can be saved as an entry log with its corresponding date. The goal being
to allow an overview of all plants and their care logs (last day it was watered, given fertilizer,
etc...)