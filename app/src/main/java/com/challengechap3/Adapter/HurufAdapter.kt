package com.challengechap3.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.challengechap3.KalimatFragment
import com.challengechap3.R
import com.challengechap3.data_list.ListHuruf
import com.challengechap3.databinding.TombolHurufBinding

class HurufAdapter(val dataHuruf : ArrayList<ListHuruf>) : RecyclerView.Adapter<HurufAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: TombolHurufBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun binding(list: String){
               binding.tombolHuruf.text = list
                binding.tombolHuruf.setOnClickListener{
                    val kalimatFragment = KalimatFragment()
                    val fActivity = it.context as FragmentActivity
                    val bundle = Bundle()
                    bundle.putParcelable("Parcelable", ListHuruf(list))
                    kalimatFragment.arguments = bundle
                    fActivity.supportFragmentManager.beginTransaction().replace(R.id.frame_container, kalimatFragment)
                        .commit()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val binding = TombolHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.binding(dataHuruf[position].hurufAbjad)

    override fun getItemCount() = dataHuruf.size


}

