package com.example.simpelindes.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.simpelindes.R

class LoginActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        shared = this.getSharedPreferences("com.example.simpelindes", Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor = shared.edit()

        var nik = findViewById<EditText>(R.id.editTextNIK)
        var password = findViewById<EditText>(R.id.editTextPassword)
        var buttonLogin = findViewById<Button>(R.id.buttonUpdate)

        buttonLogin.setOnClickListener{
            editor.putInt("UID", 1)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}