package com.ifts4.introduccionandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
//import com.google.gson.Gson
import com.ifts4.introduccionandroid.databinding.ActivityRegisterBinding
import java.text.FieldPosition


class RegisterActivity : AppCompatActivity()/*,AdapterView.OnItemSelectedListener*/ {

    private lateinit var binding: ActivityRegisterBinding

    val arrayColors: Array<Colors> = Colors.values()
    var colorSelected: Colors? = null

    /*override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        colorSelected = arrayColors.get(position)
        Log.d("RegisterActivity","Selecciono $colorSelected")
        Toast.makeText(this, "Selecciono $colorSelected", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        colorSelected = null
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, R.layout.my_simple_spinner_item, arrayColors)
        binding.spinnerColors.adapter = adapter
        //binding.spinnerColors.onItemSelectedListener = this
        binding.spinnerColors.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                colorSelected = arrayColors.get(position)
                Log.d("RegisterActivity","Selecciono $colorSelected")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                colorSelected = null
            }
        }


        binding.btnNext.setOnClickListener {
            //Toast.makeText(this, "Hola, ${binding.editTextHelloWorld.text.toString()}", Toast.LENGTH_SHORT).show()
            val age = binding.editTextAge.text.toString()
            val name = binding.editTextName.text.toString()
            val lastName = binding.editTextLastName.text.toString()

            if (age.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty() && colorSelected != null) {
                val preferences = getSharedPreferences(CREDENTIALS, MODE_PRIVATE)
                val edit = preferences.edit()

                val person = Person(name = name, lastName = lastName, age = age.toInt(), colorSelected!!)
                val gson = Gson()

                val personInJsonFormat = gson.toJson(person)
                edit.putString("person", personInJsonFormat)

                /*edit.putString("name", name)
                edit.putString("lastName", lastName)
                edit.putInt("age", age.toInt())*/

                edit.apply()
                goToMainActivity()

            } else {
                Toast.makeText(this, "Complete el formulario", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    companion object { // static
        const val CREDENTIALS = "Credenciales"
    }
}