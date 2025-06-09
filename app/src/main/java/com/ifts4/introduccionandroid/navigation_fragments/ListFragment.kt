package com.ifts4.introduccionandroid.navigation_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts4.introduccionandroid.R
import com.ifts4.introduccionandroid.databinding.FragmentListBinding
import com.ifts4.introduccionandroid.ui.ListAdapter


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val list = arrayListOf("Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca")
        val adapter = ListAdapter { user ->
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
        }

        val layout = LinearLayoutManager(requireContext())
        binding.listadoRecyclerView.layoutManager = layout
        binding.listadoRecyclerView.adapter = adapter


        // Linea divisoria
        val divider = DividerItemDecoration(requireContext(), layout.orientation)
        binding.listadoRecyclerView.addItemDecoration(divider)


        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

}