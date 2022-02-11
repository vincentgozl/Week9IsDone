package com.example.nativenathan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // Perlu bikin fitur login
    var login:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Nathan Hendry", Toast.LENGTH_SHORT).show()
    }
}