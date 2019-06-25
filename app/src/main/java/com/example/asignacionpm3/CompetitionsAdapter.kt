package com.example.asignacionpm3

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView



class CompetitionsAdapter : BaseAdapter{

    var inflater : LayoutInflater? = null
    var competitions :List<Competition>? = null

    constructor(context : Context, competitions : List<Competition>){
        this.competitions = competitions
        this.inflater = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View? = null
        var viewHolder : ViewHolder? = null
        if(convertView == null){
            view = this.inflater!!.inflate(R.layout.item_competition, null)
            viewHolder = ViewHolder()
            viewHolder.tviCompetitionName = view.findViewById(R.id.tviCompetitionName)
            viewHolder.ivChampionshipLogo = view.findViewById(R.id.ivChampionshipLogo)
            view.tag =viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder?
        }

        viewHolder!!.tviCompetitionName!!.text = this.competitions!![position].name
        var myUri : Uri = Uri.parse(this.competitions!![position].emblemUrl)
        viewHolder!!.ivChampionshipLogo!!.setImageURI(myUri)
        viewHolder!!.ivChampionshipLogo!!.animate().scaleX(1F).scaleY(1F).start()
        return view!!
    }

    override fun getItem(position: Int): Any {
        return competitions!![position]
    }

    override fun getItemId(position: Int): Long {
        return competitions!![position].id
    }

    override fun getCount(): Int {
        return this.competitions!!.size
    }


    class ViewHolder{
        var tviCompetitionName : TextView? = null
        var ivChampionshipLogo : ImageView? = null
        var tviNumberOfTeams : TextView? = null
    }


}