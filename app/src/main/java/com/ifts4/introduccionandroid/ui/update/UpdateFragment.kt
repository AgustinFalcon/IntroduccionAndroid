package com.ifts4.introduccionandroid.ui.update

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ifts4.introduccionandroid.R
import com.ifts4.introduccionandroid.databinding.FragmentUpdateBinding
import com.ifts4.introduccionandroid.data.model.User


class UpdateFragment : Fragment() {

    var user: User? = null

    private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = arguments?.getSerializable("user") as? User

        binding.etName.setText(user?.let { it.name })
        binding.etLastName.setText(user?.let { it.lastName })
        binding.etAge.setText(user?.let { it.age.toString() })


        binding.btnUpdateUser.setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        binding.btndeleteUser.setOnClickListener {
            deleteUser()
        }
    }


    private fun deleteUser() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Desea eliminar?")
        dialog.setMessage("Estas seguro que desea eliminar ha ${user!!.name}")

        dialog.setNegativeButton("No") { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Yes") { _,_ ->
        }

        dialog.create().show()
    }


}