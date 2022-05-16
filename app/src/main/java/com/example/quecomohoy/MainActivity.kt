package com.example.quecomohoy

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.recomendationsFragment, R.id.searchFragment, R.id.favouritesFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.white)))
        notShowBottomNavBarAndActionBarInFragments(navController, bottomNavigationView)
    }

    private fun notShowBottomNavBarAndActionBarInFragments(navController:NavController, bottomNavigationView:BottomNavigationView){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if( destination.id == R.id.loginFragment ||
                destination.id == R.id.registrationFragment ||
                destination.id == R.id.cameraFragment) {
                bottomNavigationView.visibility=View.GONE
                supportActionBar!!.hide()
            } else {
                bottomNavigationView.visibility=View.VISIBLE
                supportActionBar!!.show()
            }
        }
    }
}