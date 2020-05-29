package com.example.svekomp.project.ui.Tasks

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.example.svekomp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_details.*
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TaskDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        button_abort.setOnClickListener {
            finish()
        }
        sendDataToDatabase()
    }

    private fun sendDataToDatabase(){
        val sentdata = intent.getStringExtra("passselectedtask")
        recievedDataTextView.text = sentdata

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val correctMonth = month + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        var date = "$day/$correctMonth/$year"

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)){
                view, year, month, day ->
                val month = month + 1
                date = "$day/$month/$year"
            }

        var completed = ""
        val picker = spinner
        val doTask = resources.getStringArray(R.array.grad)
        if (picker != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, doTask)
            picker.adapter = adapter
        }
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                completed = doTask[position]
            }
        }

        button_save.setOnClickListener {
            val firebaseuser = FirebaseAuth.getInstance().currentUser
            val uid = firebaseuser?.uid
            val firebasadata = FirebaseDatabase.getInstance().getReference("/users").child(uid.toString())

            val connectivityManager = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null && networkInfo.isConnected) {
                if (networkInfo.type == ConnectivityManager.TYPE_WIFI || networkInfo.type == ConnectivityManager.TYPE_MOBILE){
                    val key = firebasadata.child("tasks").push().key
                    firebasadata.child("tasks").child(key.toString())
                        .setValue("$sentdata\n$completed\n$date")
                        .addOnSuccessListener {
                            Toast.makeText(this, "Aktivitet lagret", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Noe gikk galt", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                }
            }
            else{
                Toast.makeText(baseContext, "Ingen internettilkobling, data vil ikke bli lagret", Toast.LENGTH_LONG).show()
                this.finish()
            }
        }
    }
}

