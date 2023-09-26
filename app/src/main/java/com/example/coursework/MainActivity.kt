package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.NonSdkApiUsedViolation
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.coursework.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host)
    }
}