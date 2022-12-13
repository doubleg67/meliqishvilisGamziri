package com.example.meliqishvilisgamziri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mail:EditText
    private lateinit var password:EditText
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         button = findViewById(R.id.button)
         mail = findViewById(R.id.email)
         password = findViewById(R.id.password)


        button.setOnClickListener {
            var gmail = mail.text.toString()
            var pass = password.text.toString()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(gmail,pass)
                .addOnCompleteListener {
                        task -> if(task.isSuccessful){
                    Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_SHORT).show()
                        }
            }
        }
    }
}


