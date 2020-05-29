package com.example.svekomp.project.ui.UtilityScreens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.svekomp.R
import com.example.svekomp.project.Adapter.RecycleViewHistoryAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class History : AppCompatActivity() {

    lateinit var adapter: RecycleViewHistoryAdapter
    lateinit var rvhistorik: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        rvhistorik = findViewById(R.id.rvhistorik)
        rvhistorik.layoutManager = LinearLayoutManager(rvhistorik.context)
        rvhistorik.setHasFixedSize(true)

        val historyOfTasks = ArrayList<String>()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userkey = currentUser?.uid
        val ref = FirebaseDatabase.getInstance().getReference("/users").child(userkey!!).child("/tasks")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach {
                    historyOfTasks.add(it.value.toString())
                    adapter = RecycleViewHistoryAdapter(historyOfTasks)
                    rvhistorik.adapter = adapter
                }
            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
        }
}


