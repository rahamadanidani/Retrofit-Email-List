package com.rahma.retrofitemaillist.coroutines.utils

import com.rahma.retrofitemaillist.coroutines.utils.Status.ERROR
import com.rahma.retrofitemaillist.coroutines.utils.Status.LOADING
import com.rahma.retrofitemaillist.coroutines.utils.Status.SUCCESS

/**kelas ini yang akan bertanggung jawab
 * untuk mengomunikasikan status Panggilan Jaringan saat ini ke Lapisan UI*/
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}