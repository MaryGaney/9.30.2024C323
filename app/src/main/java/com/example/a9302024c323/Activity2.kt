package com.example.a9302024c323

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val courseID = intent.getStringExtra("COURSEID")
        val txtViewObject: TextView = findViewById(R.id.secondTextView)
        txtViewObject.setText(courseID)

        val btn2 : Button = findViewById(R.id.sendFeedbackButton)
        btn2.setOnClickListener{
            val resultIntent = Intent()
            val editTextObject : EditText = findViewById(R.id.opinionEditText)
            resultIntent.putExtra("RESULT", editTextObject.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}