package com.bevia.simplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bevia.simplemvvm.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var btnToCallingActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnToCallingActivity = findViewById(R.id.btnToCallingActivity)
        btnToCallingActivity.setOnClickListener {
          finish()
        }
    }
}