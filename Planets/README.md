Sugandhi Kalansooriya
Application For the Mobile App Developer Position
16.10.2024

1. Project Setup Instructions
download the zip file and exracte it
open planet folder using Android studio
open build.gradle file
click sync button
click run 

   
2. Libraries Used: A list of all libraries 
 First-Party Libraries
   androidx.lifecycle:lifecycle-viewmodel-ktx:  it allows  to use ViewModels with lifecycle awareness. This helps manage UI-related data in a lifecycle-conscious way, making it easier to handle configuration changes and data preservation.
 Third-Party Libraries
   com.squareup.retrofit2:retrofit: Retrofit is a type-safe HTTP client for making API requests. It simplifies network communication in Android by converting HTTP API endpoints into a usable interface, making it easier to handle data retrieval and API calls.
   com.squareup.retrofit2:converter-gson: This library works with Retrofit to convert JSON responses from the server into Kotlin or Java objects using Gson. It automates the serialization and deserialization of data, making it easier to handle data from APIs.

3. Architecture Overview:
   Used the MVVM architecture 
   
   influences the design of the application by:
   Separation of Concerns: Dividing the logic between Model, ViewModel, and View ensures that each layer has a specific role, making the code easier to read and maintain.
   Reactivity: The use of LiveData in the ViewModel makes the UI reactive, automatically updating when the data changes without needing to manually refresh the view.
   Testability: With the business logic separated into the ViewModel and Model layers, it becomes much easier to write unit tests for these components without needing to involve the UI.
   Scalability: The clear separation between layers ensures that the app can be scaled up easily by adding new features or making changes without impacting other parts of the codebase.


4. Key Design Decisions: Explain your thought process regarding major design decisions, including the
   use of modern reactive programming with Kotlin Coroutines, Flow, Jetpack Compose, and other
   Jetpack libraries.


5. Known Issues


6. Testing

7. Optional Features
      planet icons added 
      used Static Random Image url
      The image is downloaded from the URL (https://picsum.photos/200/300) using java.net.URL().openStream() in the background thread created by the Executor.
      The downloaded image data is decoded into a Bitmap using BitmapFactory.decodeStream()
      Once the image has been downloaded and converted to a Bitmap, the Handler.post() method is called to update the ImageView on the main thread.
      The setImageBitmap() method is used to set the downloaded image into the ImageView of the PlanetViewHolder
      
      Add Gif to detail View 
      blanc space was there and want to make improve the interface
      