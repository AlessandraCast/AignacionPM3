package com.example.asignacionpm3

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import kotlinx.android.synthetic.main.activity_competition_selection.*
import kotlinx.android.synthetic.main.fragment_equipos.*

class CompetitionSelection : AppCompatActivity(), AdapterView.OnItemClickListener {


    private lateinit var lviCompetitionList: ListView
//    private lateinit var adapter: CompetitionsAdapter
    private lateinit var pullToRefresh_empty: SwipeRefreshLayout
    private lateinit var pullToRefresh_list: SwipeRefreshLayout
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition_selection)
        FirebaseApp.initializeApp(applicationContext)


        //Toolbar Setting
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Elija la Competición"
        setSupportActionBar(toolbar)

        //Compatibility checking
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) toolbar.elevation = 10.0f


        pullToRefresh_list = findViewById(R.id.swipeToRefresh_listView)
        pullToRefresh_empty = findViewById(R.id.swipeToRefresh_emptyView)
        lviCompetitionList = findViewById(R.id.lviCompetitionsList)

        swipeToRefresh_listView.setOnRefreshListener {
            deploy()
        }

        swipeToRefresh_emptyView.setOnRefreshListener {
            deploy()
        }

//        val emptyText = findViewById<TextView>(R.id.emptyResults)
        lviCompetitionsList.emptyView = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh_emptyView)


        lviCompetitionList!!.onItemClickListener = this



    }

    private fun deploy(){
        CompetitionsManager().getCompetitions(lviCompetitionList,this)
        pullToRefresh_list.isRefreshing = false
        pullToRefresh_empty.isRefreshing = false
    }




    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this,CompetitionDetailData::class.java)
        startActivity(intent)
//        val competition : Competition = parent!!.getItemAtPosition(position) as Competition
//        Toast.makeText(this, "Hola:${competition.name}", Toast.LENGTH_SHORT).show()
    }

}



