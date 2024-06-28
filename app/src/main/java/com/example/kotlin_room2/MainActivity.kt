package com.example.kotlin_room2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemEntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ItemEntryViewModel::class.java)
        viewModel.initDatabase(this)

        val itemName = findViewById<EditText>(R.id.item_name)
        val itemQuantity = findViewById<EditText>(R.id.item_quantity)
        val itemPrice = findViewById<EditText>(R.id.item_price)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener {
            val name = itemName.text.toString()
            val quantity = itemQuantity.text.toString().toIntOrNull() ?: 0
            val price = itemPrice.text.toString().toDoubleOrNull() ?: 0.0

            if (name.isNotBlank()) {
                Log.d("MainActivity", "Salvando item com o nome: $name, quantidade: $quantity, preço: $price")
                viewModel.saveItem(name, quantity, price)
                Toast.makeText(this, "Item salvo", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor insira um nome", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


