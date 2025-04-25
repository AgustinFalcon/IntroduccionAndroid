package com.ifts4.introduccionandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ifts4.introduccionandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_result)
        setContentView(binding.root)

        val preferences = getSharedPreferences(RegisterActivity.CREDENTIALS, MODE_PRIVATE)
        val edit = preferences.edit()

        val sharedPrefName = preferences.getString("name","")
        // comparar datos desde la shared preferences con lo que escribe el usuario en pantalla
        binding.btnLogin.setOnClickListener {
            if (binding.editTextName.text.toString() == sharedPrefName) {
                Toast.makeText(this, "Tu nombre es correcto, $sharedPrefName", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}