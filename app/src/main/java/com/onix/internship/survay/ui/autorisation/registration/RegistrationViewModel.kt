package com.onix.internship.survay.ui.autorisation.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.database.tables.user.User
import com.onix.internship.survay.data.database.tables.user.UsersDao
import com.onix.internship.survay.data.security.md5
import com.onix.internship.survay.ui.autorisation.AuthFragmentDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(private val usersDao: UsersDao) : ViewModel() {

    val model = RegistrationModel()

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _errorLogin = MutableLiveData(ErrorStates.NONE)
    val errorLogin: LiveData<ErrorStates> = _errorLogin

    private val _errorPassword = MutableLiveData(ErrorStates.NONE)
    val errorPassword: LiveData<ErrorStates> = _errorPassword

    private val _errorFirstName = MutableLiveData(ErrorStates.NONE)
    val errorFirstName: LiveData<ErrorStates> = _errorFirstName

    private val _errorLastName = MutableLiveData(ErrorStates.NONE)
    val errorLastName: LiveData<ErrorStates> = _errorLastName

    fun onSubmitClick() {
        model.apply {
            _errorLogin.value = isLoginCorrect()
            _errorFirstName.value = isFirstNameCorrect()
            _errorLastName.value = isLastNameCorrect()
            _errorPassword.value = isPasswordCorrect()
            if (isCorrect()) {
                registerNewUser()
            }
        }
    }

    private fun registerNewUser() {
        viewModelScope.launch(Dispatchers.IO) {
            model.apply {
                val user = User(
                    login = login,
                    password = md5(password),
                    firstName = firstName,
                    lastName = lastName,
                    role = 1
                )
                usersDao.insert(user)
                _navigationEvent.postValue(AuthFragmentDirections.actionAuthFragmentToAdminFragment())
            }
        }
    }
}