package com.rahma.retrofitemaillist.coroutines.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rahma.retrofitemaillist.coroutines.data.repository.MainRepository
import com.rahma.retrofitemaillist.coroutines.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
/**ini merupakan Live data Scope-resorce daftar user yang mana pada saat aplikasi dijalanka maka data
 * akan ditampilan namun jika data tidak berhasil ditampilkan maka akan ada pesan yang menyatakan bahwa
 * terjadi kesalahan*/
    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}