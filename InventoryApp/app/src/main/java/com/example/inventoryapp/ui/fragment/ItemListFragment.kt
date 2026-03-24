package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.adapter.ItemAdapter
import com.example.inventoryapp.ui.viewmodel.ItemViewModel

class ItemListFragment : Fragment() {
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewItems)
        itemAdapter = ItemAdapter()

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        itemViewModel.getAllItems().observe(viewLifecycleOwner) { itemList ->
            itemAdapter.setData(itemList)
        }
    }
}
