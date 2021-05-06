package com.onix.internship.survay.ui.autorisation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.survay.data.database.tables.user.UsersDao

class LoginViewModelFactory(
    private val usersDao: UsersDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(usersDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}