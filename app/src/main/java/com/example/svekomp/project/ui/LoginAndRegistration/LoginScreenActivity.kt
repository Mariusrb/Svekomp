package com.example.svekomp.project.ui.LoginAndRegistration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.svekomp.R
import com.example.svekomp.project.ui.HomeScreen.HomePage
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_screen.*


class LoginScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        backToRegistrationText.setOnClickListener {
            val intent = Intent(this, RegistrationScreenActivity::class.java)
            startActivity(intent)
        }
        performLogin()
    }

    private fun performLogin(){
        loginButton.setOnClickListener {
            val phonenumber = loginPhoneNumber.text.toString()
            val email = "$phonenumber@svekomp.svekomp"

            if (email.isEmpty() || phonenumber.isEmpty()) {
                Toast.makeText(this, "Vennligst fyll ut Mobilnummeret", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, phonenumber)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Innlogging vellykket", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Noe gikk galt", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}


