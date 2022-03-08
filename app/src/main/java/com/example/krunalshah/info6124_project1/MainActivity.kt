package com.example.krunalshah.info6124_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton: Button = findViewById(R.id.settingsButton)
        val addProductButton: Button = findViewById(R.id.addRecordButton)
        val pastRecordsButton: Button = findViewById(R.id.pastRecordsButton)

        settingsButton.setOnClickListener {
            val intent = Intent(this, settingsActivity::class.java)
            startActivity(intent)
        }
    }
}