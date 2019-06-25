package com.example.asignacionpm3

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamsAdapter : BaseAdapter {

    var inflater : LayoutInflater? = null
    var teams :List<Team>? = null

    constructor(context : Context, teams : List<Team>){
        this.teams = teams
        this.inflater = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null
        var viewHolder : ViewHolder? = null
        if(convertView == null){
            view = this.inflater!!.inflate(R.layout.item_team, null)
            viewHolder = ViewHolder()
            viewHolder.tviTeamName = view.findViewById(R.id.tviTeamName)
            viewHolder.tviTeamValue = view.findViewById(R.id.tviTeamValue)
            viewHolder.ivTeamLogo = view.findViewById(R.id.ivTeamLogo)
            view.tag =viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder?
        }

        viewHolder!!.tviTeamName!!.text = this.teams!![position].name
        viewHolder!!.tviTeamValue!!.text = this.teams!![position].teamsValue.toString()

        return view!!
    }

    override fun getItem(position: Int): Any {
        return teams!![position]
    }

    override fun getItemId(position: Int): Long {
        return teams!![position].id
    }

    override fun getCount(): Int {
        return this.teams!!.size
    }


    class ViewHolder{
        var tviTeamName : TextView? = null
        var ivTeamLogo : ImageView? = null
        var tviTeamValue : TextView? = null
    }

}