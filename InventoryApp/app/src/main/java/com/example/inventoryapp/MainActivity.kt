package com.example.inventoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.inventoryapp.data.local.Item
import com.example.inventoryapp.ui.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        val editTextName = findViewById<EditText>(R.id.editTextItemName)
        val editTextPrice = findViewById<EditText>(R.id.editTextItemPrice)
        val editTextQuantity = findViewById<EditText>(R.id.editTextItemQuantity)
        val buttonSave = findViewById<Button>(R.id.buttonSaveItem)

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val priceText = editTextPrice.text.toString().trim()
            val quantityText = editTextQuantity.text.toString().trim()

            if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceText.toDoubleOrNull()
            val quantity = quantityText.toIntOrNull()

            if (price == null || quantity == null) {
                Toast.makeText(this, "Enter valid price and quantity", Toast.LENGTH_SHORT).show()
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

            Toast.makeText(this, "Item saved successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
