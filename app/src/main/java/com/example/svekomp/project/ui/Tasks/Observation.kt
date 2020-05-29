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
import kotlinx.android.synthetic.main.activity_dokumentasjonssystem.*
import kotlinx.android.synthetic.main.activity_observasjoner.*
import kotlinx.android.synthetic.main.activity_stell.*


class Observation : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var rvObservation: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observasjoner)

        rvObservation = findViewById(R.id.rvObservation)
        rvObservation.layoutManager = LinearLayoutManager(rvObservation.context)
        rvObservation.setHasFixedSize(true)

        observation_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        val observationTaskList = ArrayList<String>()
        observationTaskList.add("Puls")
        observationTaskList.add("BT (blodtrykk)")
        observationTaskList.add("Temperatur")
        observationTaskList.add("EKG (Elektrokardiografi)")
        observationTaskList.add("Timediurese")
        observationTaskList.add("Døgndiurese")
        observationTaskList.add("Respirasjon/dybde/frekvens")
        observationTaskList.add("Cheyne-Stokes")
        observationTaskList.add("Kussmauls")
        observationTaskList.add("Apnoe")
        observationTaskList.add("Cyanose")
        observationTaskList.add("Puls/BT/temperatur")
        observationTaskList.add("Respirasjon")
        observationTaskList.add("Bevissthetsnivå")
        observationTaskList.add("Væskebalanse")
        observationTaskList.add("Operasjonssår")
        observationTaskList.add("Infeksjonstegn")
        observationTaskList.add("Dren")
        observationTaskList.add("Blødning")
        observationTaskList.add("Sårruptur")
        observationTaskList.add("Hematom")
        observationTaskList.add("Flebitt")
        observationTaskList.add("Ødemer")
        observationTaskList.add("Sårblødning")
        observationTaskList.add("Vaginalblødning")
        observationTaskList.add("Sjokksymptomer")

        adapter = RecyclerViewAdapter(observationTaskList)
        rvObservation.adapter = adapter
    }
}



