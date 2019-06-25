package com.example.asignacionpm3.fragments

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.asignacionpm3.Competition
import com.example.asignacionpm3.CompetitionsManager
import com.example.asignacionpm3.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EquiposFragment : Fragment(){

    private lateinit var toolbar: Toolbar
    private lateinit var lviTeamList: ListView
    private lateinit var currentCompetition : Competition

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Toolbar Setting
        toolbar = view!!.findViewById(R.id.toolbar)
        toolbar.title = "Lista de Equipos"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        //Compatibility checking
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) toolbar.elevation = 10.0f








    }

//    private fun deployTeams(){
//        CompetitionsManager().getTeamsOfCompetition(currentCompetition.id,lviTeamList,this)
//    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_equipos, null)
    }


}