package com.ifts4.introduccionandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.ifts4.introduccionandroid.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Forma nativa de inflado de android
        //setContentView(R.layout.activity_main)

        //val editTextName = findViewById<EditText>(R.id.editTextHelloWorld)
        //val btnNext = findViewById<Button>(R.id.butonNavigate)

        editTextName = findViewById<EditText>(R.id.editTextName)


        binding.btnNext.setOnClickListener {
            //Toast.makeText(this, "Hola, ${binding.editTextHelloWorld.text.toString()}", Toast.LENGTH_SHORT).show()
            val age = binding.editTextAge.text.toString()
            val name = binding.editTextName.text.toString()
            val lastName = binding.editTextLastName.text.toString()

            if (age.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty()) {
                val preferences = getSharedPreferences(CREDENTIALS, MODE_PRIVATE)
                val edit = preferences.edit()

                edit.putString("name", name)
                edit.putString("lastName", lastName)
                edit.putInt("age", age.toInt())
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

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }


    companion object { // static
        const val CREDENTIALS = "Credenciales"
    }
}