package com.rahma.retrofitemaillist.coroutines.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahma.retrofitemaillist.coroutines.R.*
import com.rahma.retrofitemaillist.coroutines.data.api.ApiHelper
import com.rahma.retrofitemaillist.coroutines.data.api.RetrofitBuilder
import com.rahma.retrofitemaillist.coroutines.data.model.User
import com.rahma.retrofitemaillist.coroutines.ui.base.ViewModelFactory
import com.rahma.retrofitemaillist.coroutines.ui.main.adapter.MainAdapter
import com.rahma.retrofitemaillist.coroutines.ui.main.viewmodel.MainViewModel
import com.rahma.retrofitemaillist.coroutines.utils.Status.ERROR
import com.rahma.retrofitemaillist.coroutines.utils.Status.LOADING
import com.rahma.retrofitemaillist.coroutines.utils.Status.SUCCESS
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
/**panggil kelas super onCreate untuk menyelesaikan pembuatan aktivitas seperti
// hierarki tampilan*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)  /**mengatur tata letak antarmuka pengguna untuk aktivitas ini
    // file layout didefinisikan dalam file proyek res/layout/main_activity.xml*/
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }
/**recyclerView meminta tampilan tersebut, dan mengikat tampilan ke datanya, d
 * engan memanggil metode di adapterr*/
    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
    /** Perintah ini digunakan untuk  menampilkan list data pengguna*/
    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
               when (resource.status) {
                    SUCCESS -> { /** Jika aplikasi berhasil dijalankan maka akan menampilkan data-data
                     yang terdapat didalam url dan tampilannya berupa list data*/
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    ERROR -> { /** Perintah ini digunakan untuk memuat pesan error jika aplikasi tidak
                     dapat dijalankan*/
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {   /** perintah ini digunakan untuk proses memuat tampilan*/
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }
/**Perintah ini merupakan MainAdapter*/
    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}
