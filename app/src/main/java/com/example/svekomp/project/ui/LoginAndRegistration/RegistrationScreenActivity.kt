package com.example.svekomp.project.ui.LoginAndRegistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.svekomp.R
import com.example.svekomp.project.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration_screen.*

class RegistrationScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_screen)
        registrationButton.setOnClickListener {
            performRegister()
        }
        backtologinButton.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun performRegister(){
        val phonenumber = registerPhoneNumber.text.toString()
        val email = "$phonenumber@svekomp.svekomp"

        if (email.isEmpty() || phonenumber.isEmpty()) {
            Toast.makeText(this, "Vennligst fyll ut Mobilnummeret", Toast.LENGTH_LONG).show()
            return
        }
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, phonenumber)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener
                saveUserToFirebaseDatabase()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Registrering feilet: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun saveUserToFirebaseDatabase(){
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
        val user = User(uid, registerPhoneNumber.text.toString())
        ref.setValue(user)
            .addOnSuccessListener {
                val intent = Intent(this, LoginScreenActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Registrering feilet: ${it.message}", Toast.LENGTH_SHORT).show()
                //Logging
            }
    }
}

