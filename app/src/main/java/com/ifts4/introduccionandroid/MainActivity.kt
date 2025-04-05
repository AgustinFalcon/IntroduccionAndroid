package com.ifts4.introduccionandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ifts4.introduccionandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Forma nativa de inflado de android
        //setContentView(R.layout.activity_main)

        //val editTextName = findViewById<EditText>(R.id.editTextHelloWorld)
        //val btnNext = findViewById<Button>(R.id.butonNavigate)

        editTextName = findViewById<EditText>(R.id.editTextName)


        binding.butonNavigate.setOnClickListener {
            //Toast.makeText(this, "Hola, ${binding.editTextHelloWorld.text.toString()}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", binding.editTextName.text.toString())
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }


}