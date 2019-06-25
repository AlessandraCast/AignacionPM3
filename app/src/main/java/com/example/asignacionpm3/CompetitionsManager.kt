package com.example.asignacionpm3

import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.widget.ListView
import android.widget.Switch
import com.google.firebase.database.*


class CompetitionsManager {

    val competitionsList: ArrayList<Competition> = ArrayList()
    val teamsList: ArrayList<Team> = ArrayList()
    private lateinit var firebaseDB: DatabaseReference


    fun getCompetitions(lvComp : ListView, actContext : Context) {


        firebaseDB = FirebaseDatabase.getInstance().reference

        val competitionRef = firebaseDB.child("competitions")

        val competitionsListener = object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                competitionsList.clear()
                for (alSnapshot in data.children) {
                    Log.i("MainActivity", alSnapshot.child("name").value as String)
                    val competition = alSnapshot.getValue(Competition::class.java)
                    competitionsList.add(competition!!)

                }

//                getTeamsOfCompetition(competitionsList)

                val adapter : CompetitionsAdapter = CompetitionsAdapter(actContext,competitionsList)
                lvComp.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        competitionRef.addValueEventListener(competitionsListener)

    }

//    fun getTeamsOfCompetition(
//        idOfCompetition : Long,
//        lvTeams : ArrayList<Team>,
//        actContext : Context){
//
//        firebaseDB = FirebaseDatabase.getInstance().reference
//
//        val teamsRef = firebaseDB.child("teams")
//
//
//     for (comp : Competition in listOfCompetition){
//         var teamsOfCompRef = teamsRef.child("/competitions/${comp.id}")
//
//
//         val teamsListener = object : ValueEventListener {
//             override fun onDataChange(data: DataSnapshot) {
//                 teamsList.clear()
//                 for (alSnapshot in data.children) {
//                     val team = alSnapshot.getValue(Team::class.java)
//                     teamsList.add(team!!)
//
//                 }
//
//                 val adapter : CompetitionsAdapter = CompetitionsAdapter(actContext,competitionsList)
//                 lvTeams.adapter = adapter
//             }
//
//             override fun onCancelled(error: DatabaseError) {
//                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//             }
//         }
//
//
//
//
//         teamsOfCompRef.addValueEventListener(teamsListener)
//
//
//
//     }
//
//
//
//
////
////        val teamsListener = object : ValueEventListener {
////            override fun onDataChange(data: DataSnapshot) {
////                teamsList.clear()
////                for (alSnapshot in data.children) {
////                    Log.i("MainActivity", alSnapshot.child("name").value as String)
////                    val team = alSnapshot.getValue(Team::class.java)
////                    teamsList.add(team!!)
////
////                }
////
//////                val adapter : TeamsAdapter = TeamsAdapter(actContext,teamsList)
//////                lvTeam.adapter = adapter
////            }
////
////            override fun onCancelled(error: DatabaseError) {
////                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
////            }
////        }
////        teamsRef.addValueEventListener(teamsListener)
//
//
//    }

//    fun getPositions(lvComp : ListView, actContext : Context) {
//
//
//        firebaseDB = FirebaseDatabase.getInstance().reference
//
//        val competitionRef = firebaseDB.child("competitions")
//
//        val competitionsListener = object : ValueEventListener {
//            override fun onDataChange(data: DataSnapshot) {
//                competitionsList.clear()
//                for (alSnapshot in data.children) {
//                    Log.i("MainActivity", alSnapshot.child("name").value as String)
//                    val competition = alSnapshot.getValue(Competition::class.java)
//                    competitionsList.add(competition!!)
//
//                }
//
//                val adapter : CompetitionsAdapter = CompetitionsAdapter(actContext,competitionsList)
//                lvComp.adapter = adapter
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
//        competitionRef.addValueEventListener(competitionsListener)
//
//    }

}