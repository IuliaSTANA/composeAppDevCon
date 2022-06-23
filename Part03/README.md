***Welcome to the "Compose Yourself!" AppDevCon Workshop***

What you need:

- [Android Studio Chipmunk](https://developer.android.com/studio/)
- Working knowledge of Kotlin [idioms](https://developer.android.com/jetpack/compose/kotlin) like
  high order functions, scopes & receivers, etc.

## Part 3

After completing part 3 of the workshop you should be able to:

- Expand the UI implementations using best practices for adaptable designs
- Integrate with different material navigation components
- Optimize for optimal screen space on large screens

1. **Q:** Explore the `begin` module in the `Part03` project by launching the app on a [resizable
   emulator](https://developer.android.com/about/versions/12/12L/get#resizable-emulator).
2. **Q:** Explore using `calculateWindowSizeClass()` and passing along a `WindowWidthSizeClass`
   reference into Composables.
3. **Q:** Now, see how you can leverage these size classes to offer better whitespace on larger screens,
   for instance by adding padding to `WelcomeScreen`.
4. **Q:** Review how the app looks on large screens with a taskbar. Can you accommodate for both top
   and bottom insets by using `systemBarsPadding()`?
5. **Q:** Can you also update the `@Preview`s for `WelcomeScreen` to show a phone and tablet preview?
