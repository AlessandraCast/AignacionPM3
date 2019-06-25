package com.example.asignacionpm3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import com.example.asignacionpm3.fragments.EquiposFragment
import com.example.asignacionpm3.fragments.PosicionesFragment

class CompetitionDetailData : AppCompatActivity() {

    private var mDrawerLayout : DrawerLayout? = null
    private var mFragmentEquipos : EquiposFragment? = null
    private var mFragmentPosiciones : PosicionesFragment? = null



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.action_exit){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition_detail_data)

        val navView : NavigationView = findViewById(R.id.nav_view)
        mDrawerLayout = findViewById(R.id.drawer_layout)

        // Crear Fragment e insertarlo en FLA
        val ft = supportFragmentManager.beginTransaction()
        this.mFragmentEquipos = EquiposFragment()
        ft.add(R.id.flaContenido, this.mFragmentEquipos!!)
        // ..
        ft.commit()


        navView.setNavigationItemSelectedListener(fun (mi : MenuItem) : Boolean{
            mi.isChecked = true


            if (mi.itemId == R.id.menu_posiciones){
                val ft = supportFragmentManager.beginTransaction()
                if (this.mFragmentPosiciones == null){
                    this.mFragmentPosiciones = PosicionesFragment()
                }
                ft.replace(R.id.flaContenido, this.mFragmentPosiciones!!)
                // ..
                ft.commit()
            }else if (mi.itemId == R.id.menu_equipos){
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.flaContenido, this.mFragmentEquipos!!)
                // ..
                ft.commit()
            }

            mDrawerLayout!!.closeDrawers()

            return true
        })


    }
}
