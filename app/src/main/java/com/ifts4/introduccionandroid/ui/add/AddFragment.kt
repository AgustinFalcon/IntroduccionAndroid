package com.ifts4.introduccionandroid.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ifts4.introduccionandroid.R
import com.ifts4.introduccionandroid.databinding.FragmentAddBinding
import com.ifts4.introduccionandroid.data.model.User


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnAddUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val age = binding.etAge.text.toString()

            if (name.isNotBlank() && lastName.isNotBlank() && age.isNotBlank()) {
                val user = User(id = 0, name = name, lastName = lastName, age = age.toInt())


                findNavController().navigate(R.id.action_addFragment_to_listFragment)

            } else {
                Toast.makeText(requireContext(), "Complete todos los datos!", Toast.LENGTH_SHORT).show()
            }

        }
    }


}