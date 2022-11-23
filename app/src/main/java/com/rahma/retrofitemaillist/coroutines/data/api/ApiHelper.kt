package com.rahma.retrofitemaillist.coroutines.data.api
class ApiHelper(private val apiService: ApiService) {
    /**menggunakan suspendkata kunci untuk mendukung Coroutine sehingga
    * dapat memanggilnya dari Coroutine atau suspend fungsi lainnya.*/
    suspend fun getUsers() = apiService.getUsers()
}