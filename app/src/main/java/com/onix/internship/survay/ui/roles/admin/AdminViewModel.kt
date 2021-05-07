package com.onix.internship.survay.ui.roles.admin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.database.SurvayDatabase
import com.onix.internship.survay.data.database.tables.test.Test
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AdminViewModel(private val database: SurvayDatabase) : ViewModel() {

    val model = AdminModel()

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _isDataLoading = MutableLiveData(true)
    val isDataLoading: LiveData<Boolean> = _isDataLoading

    private val _tests = MutableLiveData<List<Test>>()
    val tests: LiveData<List<Test>> = _tests

    init {
        viewModelScope.launch {
            model.currentUser = database.authDao.getCurrentUser().user
            _isDataLoading.postValue(false)
//            createTests()
            _tests.value = database.testDao.getAllTests()
            delay(300)
        }
    }
//
//    private suspend fun createTests() {
//        database.testDao.apply {
//            insert(
//                Test(
//                    name = "Test na tip hleba",
//                    description = "Try this out! what type of bread you are?"
//                )
//            )
//            insert(Test(name = "Test na IQ", description = "Try this out! est' dva stula..."))
//            insert(
//                Test(
//                    name = "Test na gachi fanata",
//                    description = "Try this out! Who is Billy Herrington?"
//                )
//            )
//        }
//    }
}