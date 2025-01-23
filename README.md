**Overview**
AnimeHaven is a simple yet elegant Android application that allows users to browse top-rated anime, view detailed information about each anime, and watch trailers. The app leverages the Jikan API to fetch real-time data from MyAnimeList and follows the MVVM architecture for clean and maintainable code.
**Features**
Anime List Page:
Displays a list of top-rated anime with:
Title
Number of episodes
MyAnimeList (MAL) rating
Poster image
Anime Detail Page:
Provides detailed information about the selected anime:
Trailer (if available) or Poster
Title
Plot/Synopsis
Genres
Number of episodes
MAL rating
Responsive UI:
Material Design-based layout for a smooth user experience.
Supports dynamic content loading and scrolling.
**Architecture**
The app is built using the MVVM (Model-View-ViewModel) architecture for better separation of concerns:
Model:
Manages data sources (Retrofit, API responses).
ViewModel:
Handles data processing and business logic using LiveData and Coroutines.
View:
Displays data and listens for user interactions.
**Technologies and Libraries**
Languages
Kotlin
Libraries
Retrofit: For API calls and JSON parsing.
Glide: For image loading and caching.
Material Design Components: For a polished and modern UI.
Lifecycle Components:
ViewModel and LiveData for data binding and state management.
Coroutines: For efficient and asynchronous operations.
**Setup and Installation**
Prerequisites
Install Android Studio (Arctic Fox or later).
Use a device or emulator with Android API level 21 or higher.
Steps
Clone the repository:
git clone  https://github.com/Tanujain0811/Anime-Verse-App-Seekho.git
Open the project in Android Studio.
Sync the Gradle files to download dependencies.
Build and run the app on an emulator or physical device.
**Future Enhancements**
Implement search functionality to find specific anime.
Add offline caching of anime details.
Introduce pagination for smoother loading of large datasets.
Display reviews and user comments for each anime.


