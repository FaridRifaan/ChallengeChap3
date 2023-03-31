package com.challengechap3.Adapter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.challengechap3.KalimatFragment
import com.challengechap3.R
import com.challengechap3.data_list.ListHuruf
import com.challengechap3.databinding.TombolHurufBinding
import com.challengechap3.databinding.TombolKalimatBinding

class KalimatAdapter(val dataKalimat : ArrayList<String>) : RecyclerView.Adapter<KalimatAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: TombolKalimatBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun binding(data: String){
            binding.tombolHuruf.text = data
            binding.tombolHuruf.setOnClickListener{
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${data}")))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TombolKalimatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.binding(dataKalimat[position])

    override fun getItemCount() = dataKalimat.size


}