package com.example.svekomp.project.ui.Tasks

import RecyclerViewAdapter
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.svekomp.R
import kotlinx.android.synthetic.main.activity_stell.*


class Care : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var rvCare: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stell)

        rvCare = findViewById(R.id.rvCare)
        rvCare.layoutManager = LinearLayoutManager(rvCare.context)
        rvCare.setHasFixedSize(true)

        care_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        getListOfTasks()
    }

    private fun getListOfTasks() {
        val careTaskList = ArrayList<String>()
        careTaskList.add("Tannpuss")
        careTaskList.add("Spesielt munnstell")
        careTaskList.add("Stell av tannprotese")
        careTaskList.add("Nedentil hygiene til kvinner")
        careTaskList.add("Nedentil hygiene til menn")
        careTaskList.add("Vask av føtter")
        careTaskList.add("Fotstell")
        careTaskList.add("Hårvask")
        careTaskList.add("Stell av pasient")
        careTaskList.add("Stell av pasient i seng")
        careTaskList.add("Dusj av pasient")
        careTaskList.add("Bruk av hjelpemidler til trykkavlastning")
        careTaskList.add("Forflytning av pasient")
        careTaskList.add("Sengetøyskift uten pasient i seng")
        careTaskList.add("Sengetøyskift med pasient i seng")
        careTaskList.add("Bruk av kunstig skinn")
        careTaskList.add("Bruk av gelepute")
        careTaskList.add("Bruk av vannmadrass/luftmadrass")
        careTaskList.add("Pleie av døende")
        careTaskList.add("Stell av døde")
        careTaskList.add("Bruk av dekontaminator")
        careTaskList.add("Desinfeksjon av utstyr")
        careTaskList.add("Skille rent og urent")
        careTaskList.add("Behandle sterilt utstyr")
        careTaskList.add("Avfallshåndtering")

        adapter = RecyclerViewAdapter(careTaskList)
        rvCare.adapter = adapter
    }
}



