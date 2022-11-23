package com.rahma.retrofitemaillist.coroutines.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahma.retrofitemaillist.coroutines.R
import com.rahma.retrofitemaillist.coroutines.data.model.User
import com.rahma.retrofitemaillist.coroutines.ui.main.adapter.MainAdapter.DataViewHolder
import kotlinx.android.synthetic.main.item_layout.view.imageViewAvatar
import kotlinx.android.synthetic.main.item_layout.view.textViewUserEmail
import kotlinx.android.synthetic.main.item_layout.view.textViewUserName

class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<DataViewHolder>() {
/**kelas ini di gunakan untuk Berikan referensi untuk jenis tampilan yang di gunakan
 * (custom ViewHolder).*/
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.apply { // merupakan view
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)
            }
        }
    }
/**Membuat tampilan baru dan akan dipanggil oleh pengelola tata letak*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        /**Membuat tampilan baru, yang menentukan UI item daftar*/
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size
/**Mengganti konten tampilan yang mana akan dipanggil oleh pengelola tata letak*/
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply { //daftar  user dalam bentuk array
            clear()
            addAll(users)
        }

    }
}