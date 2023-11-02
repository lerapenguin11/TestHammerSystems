package com.example.testhammersystems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testhammersystems.databinding.ActivityMainBinding
import com.example.testhammersystems.presentation.BasketFragment
import com.example.testhammersystems.presentation.MenuFragment
import com.example.testhammersystems.presentation.ProfileFragment
import com.example.testhammersystems.utilits.APP_ACTIVITY
import com.example.testhammersystems.utilits.replaceFragmentMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY = this

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.menu -> replaceFragmentMain(MenuFragment())
                R.id.profile -> replaceFragmentMain(ProfileFragment())
                R.id.basket -> replaceFragmentMain(BasketFragment())
            }
            true
        }
    }
}