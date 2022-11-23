package com.rahma.retrofitemaillist.coroutines.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rahma.retrofitemaillist.coroutines.data.api.ApiHelper
import com.rahma.retrofitemaillist.coroutines.data.repository.MainRepository
import com.rahma.retrofitemaillist.coroutines.ui.main.viewmodel.MainViewModel
/**ViewModelFactory adalah kelas custom constructor
untuk ViewModel agar bisa digunakan bersamaan dengan ViewModelProvider*/
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

