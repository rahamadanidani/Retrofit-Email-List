package com.rahma.retrofitemaillist.coroutines.data.repository

import com.rahma.retrofitemaillist.coroutines.data.api.ApiHelper
//
class MainRepository(private val apiHelper: ApiHelper) {
/**menggunakan suspendkata kunci untuk mendukung Coroutine sehingga
 * dapat memanggilnya dari Coroutine atau suspend fungsi lainnya.*/
    suspend fun getUsers() = apiHelper.getUsers()
}