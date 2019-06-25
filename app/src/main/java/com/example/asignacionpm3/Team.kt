package com.example.asignacionpm3

data class Team (
    val id : Long,
//    val actualCompetition : Competition,
    val teamUrl : String,
    val name : String,
    val teamsValue : Float){
    constructor():this(-1,"","",-1F)}