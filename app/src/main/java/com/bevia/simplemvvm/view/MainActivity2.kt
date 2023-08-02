package com.bevia.simplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bevia.simplemvvm.R
import com.bevia.simplemvvm.databinding.ActivityMain2Binding
import com.bevia.simplemvvm.databinding.ActivityMainBinding

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