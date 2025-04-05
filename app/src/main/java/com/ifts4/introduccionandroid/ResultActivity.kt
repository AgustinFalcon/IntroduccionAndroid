package com.ifts4.introduccionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifts4.introduccionandroid.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_result)
        setContentView(binding.root)

        val newIntent = getIntent().getStringExtra("name")
        binding.textViewResult.text = newIntent
    }
}