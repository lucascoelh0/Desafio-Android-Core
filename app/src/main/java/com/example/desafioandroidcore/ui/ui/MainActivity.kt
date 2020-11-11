package com.example.desafioandroidcore.ui.ui

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.ui.restaurante.Restaurante
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
//    var restaurante: Restaurante = Restaurante("","","","",1,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarCredentials)

        navController = findNavController(R.id.navHostMain)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.restaurantesFragment -> { mudarCorDaToolbar(R.color.colorToolbar) }
                R.id.cardapioFragment -> { mudarCorDaToolbar(R.color.transparent)}
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun mudarCorDaToolbar(colorId: Int) {
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, colorId)))
    }
}

