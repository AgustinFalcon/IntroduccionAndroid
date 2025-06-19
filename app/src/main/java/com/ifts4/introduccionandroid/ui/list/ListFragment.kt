package com.ifts4.introduccionandroid.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.ifts4.introduccionandroid.R
import com.ifts4.introduccionandroid.data.AppDatabase
import com.ifts4.introduccionandroid.data.model.User
import com.ifts4.introduccionandroid.databinding.FragmentListBinding


class ListFragment : Fragment(), OnUserClick {

    private lateinit var binding: FragmentListBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var adapter: ListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        createDatabase()
        //val list = arrayListOf("Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca","Gato", "Perro", "Loro", "Ballena", "Foca")



        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

    private fun createDatabase() {
        appDatabase = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "app_database"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


        //appDatabase.userDao().insert(User(name = "Pepe", lastName = "Mujica", age = 89))
    }

    private fun setupRecyclerView() {
        /*adapter = ListAdapter { user ->
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
        }*/
        val adapter = ListAdapter(this)
        val layout = LinearLayoutManager(requireContext())
        binding.listadoRecyclerView.layoutManager = layout
        binding.listadoRecyclerView.adapter = adapter


        // Linea divisoria
        val divider = DividerItemDecoration(requireContext(), layout.orientation)
        binding.listadoRecyclerView.addItemDecoration(divider)
    }

    override fun onClick(user: User) {
        val bundle = Bundle()
        bundle.putSerializable("user", user)
        findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
    }

}