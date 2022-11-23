package com.rahma.retrofitemaillist.coroutines.data.model
/**Class ini di gunakan untuk data-data yang akan ditampilkan pada saat aplikasi dijalankan dalam bentuk Json*/
data class User(
    val avatar: String,
    val email: String,
    val id: String,
    val name: String
)