package com.bevia.simplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bevia.simplemvvm.model.User
import com.bevia.simplemvvm.router.Router

class UserViewModel : ViewModel() {

    private val users: MutableList<User> = mutableListOf()
    private val _navigateToSecondActivity = MutableLiveData<Boolean>()

    /*
    View observes ViewModel: The View observes the LiveData or observable properties exposed by
    the ViewModel. When these properties change, the View reacts accordingly and updates the UI.
     */
    val navigateToSecondActivity: LiveData<Boolean> get() = _navigateToSecondActivity

    //this is where you would make calls to API
    init {
        // Add some sample users for demonstration purposes
        users.add(User(1, "John Doe", "john@example.com"))
        users.add(User(2, "Jane Smith", "jane@example.com"))
        users.add(User(3, "Vincent Bevia", "john@example.com"))
        users.add(User(4, "William Bevia", "jane@example.com"))
        users.add(User(5, "Piojo Lopez", "john@example.com"))
        users.add(User(6, "Tom Cruise", "jane@example.com"))
    }

    fun getUsers(): List<User> {
        return users
    }

    //In the MVVM pattern, the Router should be called by the View (Activity or Fragment) to
    // handle navigation and any other routing logic. The ViewModel should not be directly
    // aware of the Router or have any dependency on it.
    /*
    ViewModel should expose LiveData or other observable properties to the View, and the
    View observes these properties to react to changes and update the UI accordingly.
     */

    fun navigateToSecondActivity() {
        // Trigger observable for the navigation event
        _navigateToSecondActivity.value = true
    }
}

/**

In the MVVM pattern, the concept of a "router" is not a core component like
the Model, View, and ViewModel. However, in some variations of the MVVM pattern, especially
in the context of mobile or web applications, developers might use a router or a
navigation controller to handle navigation between different views (screens) within the application.

The router is responsible for managing the navigation flow and coordinating the transition between
views/screens. It helps in decoupling the navigation logic from the ViewModel and the View.
This separation allows for better maintainability and testability of the codebase.

When using a router in MVVM, the ViewModel should not directly handle navigation actions like
presenting or dismissing views. Instead, the ViewModel raises navigation events or commands,
and the router (or navigation controller) listens for these events and handles the actual navigation.

In the MVVM architecture, API calls typically reside in the ViewModel layer.
The ViewModel is responsible for interacting with the Model (data layer) and
preparing the data to be displayed by the View. API calls fall under the data
retrieval and data processing responsibilities of the ViewModel.

Here's how API calls are integrated into the MVVM architecture:

Model (Data Layer):
The Model layer represents the data and business logic of the application.
It can include data sources like APIs, databases, or repositories.
In the context of API calls, the Model layer would consist of classes or interfaces
responsible for making network requests, parsing responses, and handling the API data.

ViewModel (Presentation Layer):
The ViewModel acts as an intermediary between the View and the Model.
It fetches data from the Model and exposes it to the View.
The ViewModel contains methods for data retrieval and other business logic required for the UI.
When API calls are needed, the ViewModel initiates the network request and processes the API responses.
The ViewModel then updates the LiveData or other observable properties that the View observes to display the data.

View (UI Layer):
The View is responsible for displaying the UI to the user.
It observes the data exposed by the ViewModel using LiveData or other observable mechanisms.
When the data changes in the ViewModel (e.g., due to API response), the View is automatically updated to reflect the changes.

 example:

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

private val _userList = MutableLiveData<List<User>>()
val userList: LiveData<List<User>> get() = _userList

    fun fetchUsers() {
        // You can show a loading indicator here if needed
        GlobalScope.launch(Dispatchers.IO) {
                try {
                // Make API call and parse response
                val response = YourApiService.getUsers()
                val users = response.body()

                // Update the LiveData on the main thread
                withContext(Dispatchers.Main) {
                _userList.value = users
                }
            } catch (e: Exception) {
        // Handle API call error, show error message, etc.
        }
    }
}
}
 */
