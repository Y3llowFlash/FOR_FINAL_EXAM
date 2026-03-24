package com.example.inventoryapp.data.repository

import androidx.lifecycle.LiveData
import com.example.inventoryapp.data.local.Item
import com.example.inventoryapp.data.local.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    private val allItemsLiveData: LiveData<List<Item>> = itemDao.getAllItems()

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    suspend fun deleteItemByName(name: String) {
        itemDao.deleteItemByName(name)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return allItemsLiveData
    }
}
