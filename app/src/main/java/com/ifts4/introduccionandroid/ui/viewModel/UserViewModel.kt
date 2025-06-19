package com.ifts4.introduccionandroid.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifts4.introduccionandroid.data.model.User
import com.ifts4.introduccionandroid.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val repository = UserRepository()

    val readAllData: LiveData<List<User>> = repository.readAllData

    fun insertUser(user: User) {
        //CoroutineScope(Dispatchers.IO).launch {}
        viewModelScope.launch {
            repository.insertUser(user = user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repository.updateUser(user = user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            repository.deleteUser(user = user)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }


}