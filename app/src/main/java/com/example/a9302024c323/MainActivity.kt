package com.example.a9302024c323

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val activity2Launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            var received_result = result.data?.getStringExtra("RESULT")

            val txtView : TextView = findViewById(R.id.mainActivityTextView)
            txtView.setText(received_result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn: Button = findViewById(R.id.launcherButton)
        btn.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            //got the user text
            val editTextObject: EditText = findViewById(R.id.courseIDEditText)
            //put the edit text content into the courseID identifier to pass to the next activity
            intent.putExtra("COURSEID", editTextObject.text.toString())
            // Start activity
            activity2Launcher.launch(intent)
        }
//
//        val btn: Button = findViewById(R.id.launcherButton)
//        btn.setOnClickListener{
//            //start a new activity
//            val intent = Intent(this, Activity2::class.java)
//            //instead of startActivity (you can use startActivityForResult if you want to pass information back and forth between the activities)
//            startActivity(intent)
//            //want second activity to run and afterwards close the first activity
//            finish()
//        }
//        try {
//            var a = 2
//            var b = 0
//            var c = a / b
//            Log.i("MYTAG", "Rest of program code")
//        }
//        catch (e: ArithmeticException) {
//            Log.e("MYTAG", "Division by zero " + e )
//        }
//        finally {
//            Log.i("MYTAG", "Finally blocks always runs")
//        }
    }
}