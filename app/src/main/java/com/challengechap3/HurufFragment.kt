package com.challengechap3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challengechap3.Adapter.HurufAdapter
import com.challengechap3.data_list.ListHuruf
import com.challengechap3.databinding.FragmentHurufBinding


class HurufFragment : Fragment() {
    private lateinit var binding: FragmentHurufBinding
    private lateinit var recyclerViewer: RecyclerView
    private var condition = false
    private lateinit var adapter: HurufAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHurufBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HurufAdapter(arrayListOf(
            ListHuruf("A"),
            ListHuruf("B"),
            ListHuruf("C"),
            ListHuruf("D"),
            ListHuruf("E"),
            ListHuruf("F"),
            ListHuruf("G"),
            ListHuruf("H"),
            ListHuruf("I"),
            ListHuruf("J"),
            ListHuruf("K"),
            ListHuruf("L"),
            ListHuruf("M")))
        recyclerViewer = view.findViewById(R.id.rv_huruf_home)
        recyclerViewer.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewer.adapter = adapter

        changeLayout()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.item_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.change_mode -> {
                condition = !condition
                changeLayout()
                if(condition){
                    item.setIcon(R.drawable.view_list)
                }else{
                    item.setIcon(R.drawable.grid_view)
                }
                true
            }
            else -> false
        }
    }

    fun changeLayout() {
        recyclerViewer.layoutManager = if (condition) {
            GridLayoutManager(requireContext(), 2)
        } else {
            LinearLayoutManager(requireContext())
        }
        recyclerViewer.adapter?.notifyDataSetChanged()
    }
}
