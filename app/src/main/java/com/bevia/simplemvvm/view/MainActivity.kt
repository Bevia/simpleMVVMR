package com.bevia.simplemvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bevia.simplemvvm.R
import com.bevia.simplemvvm.databinding.ActivityMainBinding
import com.bevia.simplemvvm.router.Router
import com.bevia.simplemvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var btnToSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the activity_main layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize the ViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Create the UserAdapter and pass the list of users from the ViewModel
        userAdapter = UserAdapter(userViewModel.getUsers())

        // Initialize the RecyclerView adapter and layout manager
        val layoutManager = LinearLayoutManager(this)

        // Set the adapter and layout manager for userRecyclerView
        binding.userRecyclerView.layoutManager = layoutManager
        binding.userRecyclerView.adapter = userAdapter

        /*
        The ViewModel remains isolated and focused on its primary responsibility, which is
        providing data and presentation logic to the View. The Router handles the navigation
        and is responsible for managing the flow between different screens or destinations
        in the application.
         */

        val router = Router(this)
        router.routerInit()

        btnToSecondActivity = findViewById(R.id.btnToSecondActivity)
        btnToSecondActivity.setOnClickListener {
            router.callMainActivity2()
        }

    }
}

/**
The MVVM pattern doesn't have a Presenter component. Instead,
it uses a ViewModel to fulfill a similar role by providing a bridge between the View and the Model.

Both MVVM and VIPER are popular design patterns used in app development, and each has its
strengths and weaknesses. The choice of pattern often depends on the specific requirements,
team expertise, and project complexity.

MVVM has gained popularity in the Android community due to its compatibility with Android's
architecture components, such as ViewModel and LiveData, which simplify the implementation
and data handling. Additionally, MVVM allows for easier testing and separation of concerns
between the layers, making it a suitable choice for many Android projects.

VIPER, on the other hand, is widely used in iOS development and aims to divide the application
into smaller, independent components (modules) with well-defined responsibilities. While VIPER
can offer better separation of concerns and maintainability, it might introduce more complexity,
especially for smaller projects.

Ultimately, the most suitable design pattern depends on the specific requirements of your project,
the team's expertise, and the overall complexity of the application. Whichever pattern you choose,
focusing on clean code, modularity, and maintainability will contribute to a successful
app development process.

 */
