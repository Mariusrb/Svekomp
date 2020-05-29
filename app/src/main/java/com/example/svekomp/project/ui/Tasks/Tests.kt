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
import kotlinx.android.synthetic.main.activity_prosedyrer.*
import kotlinx.android.synthetic.main.activity_prover.*
import kotlinx.android.synthetic.main.activity_stell.*


class Tests : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var rvTests: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prover)

        rvTests = findViewById(R.id.rvTests)
        rvTests.layoutManager = LinearLayoutManager(rvTests.context)
        rvTests.setHasFixedSize(true)

        tests_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        val testsTaskList = ArrayList<String>()
        testsTaskList.add("Blodprøver")
        testsTaskList.add("Mikrobiologiske prøver")
        testsTaskList.add("Røntgen undersøkelser")
        testsTaskList.add("Blodbestilling")
        testsTaskList.add("TBC-prøver")
        testsTaskList.add("Larynx-prøver")
        testsTaskList.add("Bakteriologiske  prøver")
        testsTaskList.add("Virus")
        testsTaskList.add("Mikrologisk")
        testsTaskList.add("Bakteriologisk")
        testsTaskList.add("Uricult")
        testsTaskList.add("Samling av urin")
        testsTaskList.add("Hemofec")
        testsTaskList.add("Bakteriologisk undersøkelse")
        testsTaskList.add("Observasjon av avføring")
        testsTaskList.add("Røntgen")
        testsTaskList.add("Ultralyd")
        testsTaskList.add("Computertomografi (CT)")
        testsTaskList.add("Magnetresonans (MR)")
        testsTaskList.add("Gastroscopi")
        testsTaskList.add("Recto/colonoscopi")
        testsTaskList.add("Cystoscopi")
        testsTaskList.add("Punksjoner (spinal, sternal, pleura)")
        testsTaskList.add("Ascitestapping")
        testsTaskList.add("Leverbiopsi")
        testsTaskList.add("Angiografi/venografi")
        testsTaskList.add("Elektroencefalografi (EEG)")

        adapter = RecyclerViewAdapter(testsTaskList)
        rvTests.adapter = adapter
    }
}



