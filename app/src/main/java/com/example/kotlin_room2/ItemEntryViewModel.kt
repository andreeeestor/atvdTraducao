package com.example.kotlin_room2

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_room2.data.AppDatabase
import com.example.kotlin_room2.data.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemEntryViewModel : ViewModel() {

    private lateinit var database: AppDatabase

    fun initDatabase(context: Context) {
        database = AppDatabase.getDatabase(context)
    }

    fun saveItem(name: String, quantity: Int, price: Double) {
        val item = Item(nome = name, quantidade = quantity, preco = price)
        Log.d("ItemEntryViewModel", "Salvando item: $item")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                database.itemDao().insert(item)
                Log.d("ItemEntryViewModel", "Item salvo com sucesso!")
            } catch (e: Exception) {
                Log.e("ItemEntryViewModel", "Error ao salvar: ${e.message}")
            }
        }
    }
}



