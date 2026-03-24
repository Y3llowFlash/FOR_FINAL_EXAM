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
import com.example.inventoryapp.data.local.Item
import com.example.inventoryapp.ui.viewmodel.ItemViewModel

class ItemInsertFragment : Fragment() {
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_insert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        val editTextName = view.findViewById<EditText>(R.id.editTextItemName)
        val editTextPrice = view.findViewById<EditText>(R.id.editTextItemPrice)
        val editTextQuantity = view.findViewById<EditText>(R.id.editTextItemQuantity)
        val buttonSave = view.findViewById<Button>(R.id.buttonSaveItem)

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val priceText = editTextPrice.text.toString().trim()
            val quantityText = editTextQuantity.text.toString().trim()

            if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceText.toDoubleOrNull()
            val quantity = quantityText.toIntOrNull()

            if (price == null || quantity == null) {
                Toast.makeText(
                    requireContext(),
                    "Enter valid price and quantity",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val item = Item(
                itemName = name,
                itemPrice = price,
                itemQuantity = quantity
            )

            itemViewModel.insertItem(item)

            editTextName.text.clear()
            editTextPrice.text.clear()
            editTextQuantity.text.clear()

            Toast.makeText(requireContext(), "Item saved successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
