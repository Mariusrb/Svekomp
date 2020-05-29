package com.example.svekomp.project.ui.HomeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.svekomp.R
import com.example.svekomp.project.ui.Tasks.*
import com.example.svekomp.project.ui.UtilityScreens.History
import com.example.svekomp.project.ui.UtilityScreens.UserProfile
import com.example.svekomp.project.ui.LoginAndRegistration.LoginScreenActivity
import com.example.svekomp.project.ui.UtilityScreens.Information
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        verifyUserIsLoggedIn()
        buttonClicks()
    }

        private fun verifyUserIsLoggedIn() {
            val uid = FirebaseAuth.getInstance().uid
            if (uid == null) {
                val intent = Intent(this, LoginScreenActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_sign_out -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, LoginScreenActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun buttonClicks(){
        history.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }
        user_profile.setOnClickListener {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
        dokumentasjon.setOnClickListener {
            val intent = Intent(this, Documentation::class.java)
            startActivity(intent)
        }
        observasjoner.setOnClickListener {
            val intent = Intent(this, Observation::class.java)
            startActivity(intent)
        }
        prosedyrer.setOnClickListener {
            val intent = Intent(this, Procedure::class.java)
            startActivity(intent)
        }
        prover.setOnClickListener {
            val intent = Intent(this, Tests::class.java)
            startActivity(intent)
        }
        stell.setOnClickListener {
            val intent = Intent(this, Care::class.java)
            startActivity(intent)
        }
        information.setOnClickListener {
            val intent = Intent(this, Information::class.java)
            startActivity(intent)
        }
    }
}
