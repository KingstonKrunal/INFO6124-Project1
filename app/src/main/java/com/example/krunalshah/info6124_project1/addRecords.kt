package com.example.krunalshah.info6124_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class addRecords : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_records)

        val recordText: EditText = findViewById(R.id.recordText)

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            val activityData: String = recordText.text.toString()
//            val currentDateAndTime: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()

            intent.putExtra("activity", activityData)
//            intent.putExtra("dateAndTime", currentDateAndTime)

            startActivity(intent)

            Toast.makeText(applicationContext, "Activity Recorded", Toast.LENGTH_LONG).show()
        }
    }
}