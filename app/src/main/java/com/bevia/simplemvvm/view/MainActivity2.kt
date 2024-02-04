package com.bevia.simplemvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bevia.simplemvvm.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnToCallingActivity.setOnClickListener {
          finish()
        }
    }
}