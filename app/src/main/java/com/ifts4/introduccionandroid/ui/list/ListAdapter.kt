package com.ifts4.introduccionandroid.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts4.introduccionandroid.databinding.ItemRecyclerviewListBinding
import com.ifts4.introduccionandroid.data.model.User

class ListAdapter(val onUserClick: ListFragment/*val onUserClick:(user: User) -> Unit*/): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var userList = listOf<User>(
        User(1, "Pepe", "Mujica", 89),
        User(2, "Mary", "Jane", 29),
        User(3, "Leo", "Messi", 37),
        User(4, "Dibu", "Martinez", 32)
    )


    inner class ListViewHolder(private val binding: ItemRecyclerviewListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            with(binding) {
                tvName.text = user.name
                tvLastName.text = user.lastName
                tvAge.text = user.age.toString()
                tvId.text = user.id.toString()
            }

            binding.root.setOnClickListener {
                //onUserClick(user)
                onUserClick.onClick(user)
                //val bundle = Bundle()
                //bundle.putSerializable("animal", user)
                //itemView.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRecyclerviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = userList.get(position)
        holder.bind(user = user)
    }

    override fun getItemCount(): Int = userList.size

}