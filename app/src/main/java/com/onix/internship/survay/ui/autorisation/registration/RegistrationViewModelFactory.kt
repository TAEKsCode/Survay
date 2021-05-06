package com.onix.internship.survay.ui.autorisation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.survay.data.database.tables.user.UsersDao

class RegistrationViewModelFactory(
    private val usersDao: UsersDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return RegistrationViewModel(usersDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}