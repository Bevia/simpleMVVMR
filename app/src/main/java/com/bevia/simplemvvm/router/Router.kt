package com.bevia.simplemvvm.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bevia.simplemvvm.view.MainActivity2
import com.bevia.simplemvvm.viewmodel.UserViewModel

class Router(private val activity: AppCompatActivity) {

    private lateinit var userViewModel: UserViewModel

    fun routerInit(){

        // Initialize the ViewModel
        userViewModel = ViewModelProvider(activity)[UserViewModel::class.java]
        userViewModel.navigateToSecondActivity()

    }

    fun callMainActivity2(){
        // Observe the LiveData from the ViewModel
        userViewModel.navigateToSecondActivity.observe(activity) { shouldNavigate ->
            if (shouldNavigate) {
                activity.startActivity(Intent(activity, MainActivity2::class.java))
            }
        }
    }
}