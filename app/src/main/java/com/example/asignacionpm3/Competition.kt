package com.example.asignacionpm3

data class Competition(
    val id : Long,
    val name : String,
    val code : String?,
    val emblemUrl : String?,
    val plan : String){
    constructor():this(-1,"","", "", "")
}