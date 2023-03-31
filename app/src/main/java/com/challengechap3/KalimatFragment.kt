package com.challengechap3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.challengechap3.Adapter.KalimatAdapter
import com.challengechap3.data_list.ListHuruf

import com.challengechap3.databinding.FragmentKalimatBinding


class KalimatFragment : Fragment() {

    lateinit var binding: FragmentKalimatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKalimatBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataKalimat = arrayListOf<String>("Anjing", "Alam","Ayam", "AAA",
            "Babi", "Bulgogi","Burung", "Burito",
            "Camar", "Cerutu", "Camell", "Cabai",
            "Dagang", "Denmark", "Daging", "Dagu",
            "Emerald", "Elktronik", "Estetik", "Efisien",
            "Film", "Fantastis", "Fantasi", "Foto",
            "Gajah", "Gading", "Gadai-ulang", "Gabruk",
            "Kebab", "Kabel", "Kabar", "Kertas",
            "Laba", "Labil", "Labuh", "Lada",
            "Makanan", "Mabuk", "Madol", "Madu")
        val data = arguments?.getParcelable<ListHuruf>("Parcelable")

        val kalimatAdapter = KalimatAdapter(dataKalimat.filter { it.startsWith(data?.hurufAbjad ?: "", true) } as ArrayList<String>)

        binding.btnKalimat.layoutManager = LinearLayoutManager(requireContext())
        binding.btnKalimat.adapter = kalimatAdapter
    }

}