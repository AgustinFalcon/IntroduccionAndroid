package com.ifts4.introduccionandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.ifts4.introduccionandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val preferences by lazy { getSharedPreferences(RegisterActivity.CREDENTIALS, MODE_PRIVATE) }
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_result)
        setContentView(binding.root)

        //val preferences = getSharedPreferences(RegisterActivity.CREDENTIALS, MODE_PRIVATE)

        when("RED") {
            Colors.RED.name -> {

            }
            Colors.YELLOW.name -> {

            }
        }
        checkAutoLogin()
        setUpListeners()
    }

    override fun onResume() {
        super.onResume()
        checkAutoLogin()
    }

    private fun checkAutoLogin() {
        Log.d("LoginActivity", "autlogin = ${preferences.getBoolean("autoLogin", false)}, isLoggedIn = ${preferences.getBoolean("isLoggedIn", false)}")
        if (preferences.getBoolean("autoLogin", false) && preferences.getBoolean("isLoggedIn", false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpListeners() {
        binding.btnLogin.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val lastName = binding.editTextLastName.text.toString()
            val checkBox = binding.checkbox.isChecked

            val edit = preferences.edit()
            if (validateData(name, lastName)) {
                edit.putBoolean("autoLogin", checkBox)
                edit.putBoolean("isLoggedIn", true)
                edit.apply()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                //edit.putBoolean("isLoggedIn", false)
                edit.apply()
                Toast.makeText(this, "Alguno de los campos es incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun validateData(name: String, lastName: String): Boolean {
       try {
           val personInJsonFormat = preferences.getString("person", null)
           val person = gson.fromJson(personInJsonFormat, Person::class.java)

           if (name == person.name && lastName == person.lastName) {
               return true
           } else {
               return false
           }
       } catch (e: java.lang.Exception) {
           e.printStackTrace()
           return false
       }
    }

    private fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}