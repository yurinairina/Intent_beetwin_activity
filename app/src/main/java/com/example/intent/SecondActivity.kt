package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var nameET: EditText
    private lateinit var emailET: EditText
    private lateinit var submitBTN: Button

   // private lateinit var textInfoTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//textInfoTV = findViewById(R.id.textInfoTV)
        nameET = findViewById(R.id.nameET)
        emailET = findViewById(R.id.emailET)
        submitBTN = findViewById(R.id.submitBTN)

        submitBTN.setOnClickListener{
            val name = nameET.text.toString().trim()
            val email = emailET.text.toString().trim()
            val intent = Intent()
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            setResult(RESULT_OK, intent)
            finish()
        }


        val result = intent.getStringExtra("key")
        //textInfoTV.text = "$result"
    }
}