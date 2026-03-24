package com.example.inventoryapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.local.InventoryDatabase
import com.example.inventoryapp.data.local.Item
import com.example.inventoryapp.data.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    private val allItemsLiveData: LiveData<List<Item>>

    init {
        val itemDao = InventoryDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        allItemsLiveData = repository.getAllItems()
    }

    fun insertItem(item: Item) {
        viewModelScope.launch {
            repository.insertItem(item)
        }
    }

    fun deleteItem(name: String) {
        viewModelScope.launch {
            repository.deleteItemByName(name)
        }
    }

    fun getAllItems(): LiveData<List<Item>> {
        return allItemsLiveData
    }
}
