package com.ifts4.introduccionandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifts4.introduccionandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogOut.setOnClickListener {
            val preferences = getSharedPreferences(RegisterActivity.CREDENTIALS, MODE_PRIVATE)
            preferences.edit().clear().apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}