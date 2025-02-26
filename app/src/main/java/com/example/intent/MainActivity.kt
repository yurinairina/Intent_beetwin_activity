package com.example.intent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    private lateinit var addUserBTN: Button
    private lateinit var nameTV: TextView
    private lateinit var emailTV: TextView

   // private lateinit var textET: EditText
    //private lateinit var buttonTransferDataBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUserBTN = findViewById(R.id.addUserBTN)
        nameTV = findViewById(R.id.nameTV)
        emailTV = findViewById(R.id.emailTV)

        //textET = findViewById(R.id.textET)
        //buttonTransferDataBTN = findViewById(R.id.buttonTransferDataBTN)

//        buttonTransferDataBTN.setOnClickListener{
//            if (textET.text.isEmpty()) return@setOnClickListener
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("key",textET.text.toString())
//            startActivity(intent)

        addUserBTN.setOnClickListener {
            val intent = Intent (this, SecondActivity::class.java)
           // startActivity(intent)
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
           launchSomeActivity.launch(intent)

        }
    }
    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val name = data!!.getStringExtra("name")
                val email = data!!.getStringExtra("email")
                nameTV.text = name
                emailTV.text = email
                Toast.makeText(this, "$name \n $email", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()

            }

    }
}