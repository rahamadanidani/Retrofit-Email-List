package com.rahma.retrofitemaillist.coroutines.data.api

import com.rahma.retrofitemaillist.coroutines.data.model.User
import retrofit2.http.GET
/**ApiService merupakan interface untuk mendefinisikan konfigurasi
 * dari retrofit yang nantinya dipanggil untuk melakukan komunikasi dengan server
 * getuser digunakan untuk mendapatkan informasi user dan mendapatkan daftar  dari user tersebut..*/
interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}