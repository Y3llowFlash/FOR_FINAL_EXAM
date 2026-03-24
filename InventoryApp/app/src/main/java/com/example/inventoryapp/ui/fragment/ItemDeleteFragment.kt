package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.viewmodel.ItemViewModel

class ItemDeleteFragment : Fragment() {
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        val editTextDeleteName = view.findViewById<EditText>(R.id.editTextDeleteItemName)
        val buttonDelete = view.findViewById<Button>(R.id.buttonDeleteItem)

        buttonDelete.setOnClickListener {
            val name = editTextDeleteName.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter item name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            itemViewModel.deleteItem(name)
            editTextDeleteName.text.clear()

            Toast.makeText(requireContext(), "Item deleted successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
