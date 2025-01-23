**Overview**
AnimeHaven is a simple yet elegant Android application that allows users to browse top-rated anime, view detailed information about each anime, and watch trailers. The app leverages the Jikan API to fetch real-time data from MyAnimeList and follows the MVVM architecture for clean and maintainable code.
**Features**

1.Anime List Page:
 .Displays a list of top-rated anime with:
 .Title
 .Number of episodes
 .Poster image
2.Anime Detail Page:
 .Provides detailed information about the selected anime:
 .Trailer (if available) or Poster
 .Title
 .Plot/Synopsis
 .Genres
 .Number of episodes
 .MAL rating
3.Responsive UI:
 .Material Design-based layout for a smooth user experience.
 .Supports dynamic content loading and scrolling.

**Architecture**

The app is built using the MVVM (Model-View-ViewModel) architecture for better separation of concerns:
Model:
Manages data sources (Retrofit, API responses).
ViewModel:
Handles data processing and business logic using LiveData and Coroutines.
View:
Displays data and listens for user interactions.

**Technologies and Libraries**

Languages :Kotlin

Libraries:
Retrofit: For API calls and JSON parsing.

Glide: For image loading and caching.

Material Design Components: For a polished and modern UI.

Lifecycle Components:
ViewModel and LiveData for data binding and state management.

Coroutines: For efficient and asynchronous operations.

**Setup and Installation**

Prerequisites:
1.Install Android Studio (Arctic Fox or later).
2.Use a device or emulator with Android API level 21 or higher.

Steps:
1.Clone the repository:
2.git clone  https://github.com/Tanujain0811/Anime-Verse-App-Seekho.git
3.Open the project in Android Studio.
4.Sync the Gradle files to download dependencies.
5.Build and run the app on an emulator or physical device.

**Future Enhancements**

1.Implement search functionality to find specific anime.
2.Add offline caching of anime details.
3.Introduce pagination for smoother loading of large datasets.
4.Display reviews and user comments for each anime.


