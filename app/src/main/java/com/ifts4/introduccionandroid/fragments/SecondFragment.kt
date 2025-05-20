package com.ifts4.introduccionandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ifts4.introduccionandroid.R
import com.ifts4.introduccionandroid.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private val viewModel: SecondViewModel by viewModels()
    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Otra manera de crear un objeto view model sin libreria
        val thirdViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        binding.etEmail.addTextChangedListener { email ->
            viewModel.validateEmail(email = email.toString())
        }

        binding.etPassword.addTextChangedListener { password ->
            viewModel.validatePassword(password = password.toString())
        }

        viewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
            when(state) {
                is SecondViewModel.SecondStates.SuccessEmail -> {
                    binding.layoutEmail.error = null
                }

                is SecondViewModel.SecondStates.ErrorEmail -> {
                    binding.layoutEmail.error = "Formato email invalido"
                }

                is SecondViewModel.SecondStates.SuccessPassword -> {
                    binding.layoutPassword.error = null
                }

                is SecondViewModel.SecondStates.ErrorPassword -> {
                    binding.layoutPassword.error = "Minimo:${state.password.length}/4"
                }

                is SecondViewModel.SecondStates.SuccessButton -> {
                    binding.btnNext.isEnabled = true
                }

                is SecondViewModel.SecondStates.ErrorButton -> {
                    binding.btnNext.isEnabled = false
                }
            }
        })

        binding.btnNext.setOnClickListener {
            Toast.makeText(requireContext(), "Formulario correcto", Toast.LENGTH_SHORT).show()
        }
    }
}