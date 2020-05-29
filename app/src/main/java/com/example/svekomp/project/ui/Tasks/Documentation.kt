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
import kotlinx.android.synthetic.main.activity_stell.*


class Documentation : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var rvDocumentation: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokumentasjonssystem)

        rvDocumentation = findViewById(R.id.rvDocumentation)
        rvDocumentation.layoutManager = LinearLayoutManager(rvDocumentation.context)
        rvDocumentation.setHasFixedSize(true)

        documentation_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        val documentationTaskList = ArrayList<String>()
        documentationTaskList.add("Innskriving av pasient")
        documentationTaskList.add("Utskriving av pasient")
        documentationTaskList.add("Kartleggingsnotat")
        documentationTaskList.add("Meldeskjema")
        documentationTaskList.add("Bestilt tekniske hjelpemidler")
        documentationTaskList.add("Kontakt med tverrfaglige aktører")

        adapter = RecyclerViewAdapter(documentationTaskList)
        rvDocumentation.adapter = adapter
    }
}



