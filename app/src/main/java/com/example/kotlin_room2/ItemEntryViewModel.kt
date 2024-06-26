package com.example.kotlin_room2

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kotlin_room2.data.AppDatabase
import com.example.kotlin_room2.data.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class ItemEntryViewModel : ViewModel() {

    private lateinit var database: AppDatabase

    fun initDatabase(context: Context) {
        database = AppDatabase.getDatabase(context)
    }

    fun saveItem(name: String, quantity: Int, price: Double) {
        val item = Item(name = name, quantity = quantity, price = price)
        viewModelScope.launch(Dispatchers.IO) {
            database.itemDao().insert(item)
        }
    }
}


