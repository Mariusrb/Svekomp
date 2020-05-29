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
import kotlinx.android.synthetic.main.activity_stell.*


class Procedure : AppCompatActivity() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var rvProcedure: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prosedyrer)

        rvProcedure = findViewById(R.id.rvProcedure)
        rvProcedure.layoutManager = LinearLayoutManager(rvProcedure.context)
        rvProcedure.setHasFixedSize(true)

        procedure_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        val procedureTaskList = ArrayList<String>()
        procedureTaskList.add("Administrering av legemidler ")
        procedureTaskList.add("Kontroll av medisiner (andre dosert)")
        procedureTaskList.add("Drypping av øye ")
        procedureTaskList.add("Bruk av forstøver")
        procedureTaskList.add("Subcutane injeksjoner")
        procedureTaskList.add("Intramuskulære injeksjoner")
        procedureTaskList.add("Intravenøse infusjoner")
        procedureTaskList.add("Hjelp til toalettbesøk")
        procedureTaskList.add("Bekken i seng")
        procedureTaskList.add("Hjelpemidler ved inkontinens")
        procedureTaskList.add("Klyster")
        procedureTaskList.add("Klyx")
        procedureTaskList.add("Microlax")
        procedureTaskList.add("Lagt inn kateter på kvinner\n" +
                "- engangskateter")
        procedureTaskList.add("Lagt inn kateter på kvinner\n" +
                "- permanent kateter")
        procedureTaskList.add("Lagt inn kateter på menn\n" +
                "- engangskateter")
        procedureTaskList.add("Lagt inn kateter på menn\n" +
                "- permanent kateter")
        procedureTaskList.add("Stell av permanent kateter")
        procedureTaskList.add("Stell av pig-tail kateter")
        procedureTaskList.add("Gjennomskylling via 3-veiskateter")
        procedureTaskList.add("Blæreskylling")
        procedureTaskList.add("Siling av urin")
        procedureTaskList.add("Puste og hosteøvelser")
        procedureTaskList.add("Stillingsendring")
        procedureTaskList.add("Drenasjeleie")
        procedureTaskList.add("Bruk av Pepfløyte/maske")
        procedureTaskList.add("O2-behandling")
        procedureTaskList.add("Bruk av sug")
        procedureTaskList.add("Bruk av respirator (blitt kjent med)")
        procedureTaskList.add("Nedleggelse av ventrikkelsonde")
        procedureTaskList.add("Innleggelse av peg-sonde")
        procedureTaskList.add("Aspirering via sonde")
        procedureTaskList.add("Ventrikkelskylling via sonde")
        procedureTaskList.add("Sondeernæring")
        procedureTaskList.add("Lagt inn perifer venekanyle")
        procedureTaskList.add("Stell av perifer venekanyle ")
        procedureTaskList.add("Stell av sentralt venekateter ")
        procedureTaskList.add("Infusjoner")
        procedureTaskList.add("Transfusjoner")
        procedureTaskList.add("Stell av nasogastrisk sonde")
        procedureTaskList.add("Stell av peg-sonde/port")
        procedureTaskList.add("Bruk av infusjonspumpe")
        procedureTaskList.add("Bruk av ernæringspumpe")
        procedureTaskList.add("Bruk av blodvarmer")
        procedureTaskList.add("Bruk av smertepumpe\n" +
                "- ved epidural analgesi (EDA)")
        procedureTaskList.add("Bruk av smertepumpe\n" +
                "- ved pasientkontrollert analgesi (PCA)")
        procedureTaskList.add("Bruk av smertepumpe\n" +
                "- ved sprøytepumpe")
        procedureTaskList.add("Bruk av vap-nål")
        procedureTaskList.add("Bruk av hickmanns kateter")
        procedureTaskList.add("Bruk av pulsoksymeter")
        procedureTaskList.add("Tatt blodprøve")
        procedureTaskList.add("Ileostomi")
        procedureTaskList.add("Colostomi")
        procedureTaskList.add("Urostomi")
        procedureTaskList.add("Suturer/agraffer")
        procedureTaskList.add("Bølgedren")
        procedureTaskList.add("Vakumdren")
        procedureTaskList.add("Rørdren")
        procedureTaskList.add("T-dren")
        procedureTaskList.add("Thoraxdren, stell og behandling av")
        procedureTaskList.add("Stell av dialysedren")
        procedureTaskList.add("Ren sår prosedyre")
        procedureTaskList.add("Steril sår prosedyre")
        procedureTaskList.add("Stell av trykksår")
        procedureTaskList.add("Stell av leggsår")
        procedureTaskList.add("Stell av brannsår")
        procedureTaskList.add("Stell av hudtransplantat")
        procedureTaskList.add("Stell av kirurgisk sår")
        procedureTaskList.add("Stell av tracheostomi")
        procedureTaskList.add("Øreskylling")
        procedureTaskList.add("Vekt")
        procedureTaskList.add("Høyde")
        procedureTaskList.add("Måle KMI (BMI)")
        procedureTaskList.add("Måle drikke/diurese")
        procedureTaskList.add("Servert mat")
        procedureTaskList.add("Gitt spisehjelp")
        procedureTaskList.add("Observert og vurdert kosttyper/diett")
        procedureTaskList.add("Observert og vurdert væskebalanse")
        procedureTaskList.add("Lagt komprimerende strømpe")
        procedureTaskList.add("Lagt komprimerende bandasje")
        procedureTaskList.add("Lagt støttebandasje")
        procedureTaskList.add("Blodsmitte")
        procedureTaskList.add("Kontaktsmitte")
        procedureTaskList.add("Dråpesmitte")
        procedureTaskList.add("Streng isolasjon")
        procedureTaskList.add("Beskyttende isolasjon")

        adapter = RecyclerViewAdapter(procedureTaskList)
        rvProcedure.adapter = adapter
    }
}



