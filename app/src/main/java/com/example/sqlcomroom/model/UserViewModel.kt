package com.example.sqlcomroom.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqlcomroom.data.RepositoryUser
import com.example.sqlcomroom.data.UserDao
import com.example.sqlcomroom.data.UserDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (context: Context?) :ViewModel(){

val lerTodososDados: LiveData <List<User>>

private val repository : RepositoryUser

init {
    val userDao = UserDataBase.getDataBase(context!!).userDao()
    repository = RepositoryUser(userDao)

    lerTodososDados = repository.lerTodosOsDados
}

    fun addUser (user:User) {
        viewModelScope.launch ( Dispatchers.IO ){
           repository.addUser(user)
        }

    }

}