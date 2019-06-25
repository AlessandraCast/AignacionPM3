package com.example.asignacionpm3.fragments

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asignacionpm3.R

class PosicionesFragment : Fragment() {

    private lateinit var toolbar: Toolbar

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Toolbar Setting
        toolbar = view!!.findViewById(R.id.toolbar)
        toolbar.title = "Tabla Posiciones"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        //Compatibility checking
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) toolbar.elevation = 10.0f



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posiciones, null)
    }

}