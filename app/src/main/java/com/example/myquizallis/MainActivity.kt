package com.example.myquizallis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

import androidx.navigation.Navigation

import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.myquizallis.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

import java.util.ArrayList


class MainActivity :BaseActivity<ActivityMainBinding>() {

    private val quizviewModel: MainViewModel by viewModel()
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_homme,
            R.id.navigation_dashboard,
            R.id.navigation_notifications

        )
            .build()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupWithNavController(navView, navController!!)

        navController!!.addOnDestinationChangedListener { controller, destination, arguments ->
            val list = ArrayList<Int>()
            list.add(R.id.navigation_homme)
            list.add(R.id.navigation_dashboard)
            list.add(R.id.navigation_notifications)

            if (list.contains(destination.id)) {
                navView.visibility = View.VISIBLE
            } else {
                navView.visibility = View.GONE
            }
            if (destination.id == R.id.navigation_homme &&
                destination.id == R.id.navigation_dashboard &&
                destination.id == R.id.navigation_notifications
            ) {
                getSupportActionBar()?.hide()
            } else {
                getSupportActionBar()?.show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController!!.navigateUp()



    }

    override fun inflateBinding(from: LayoutInflater): ActivityMainBinding {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        TODO("Not yet implemented")
    }

    override fun setupLiveData() {
        TODO("Not yet implemented")
    }


}