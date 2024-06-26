package com.example.kotlin_room2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ItemEntryActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemEntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_entry)

        viewModel = ViewModelProvider(this).get(ItemEntryViewModel::class.java)

        val itemName = findViewById<EditText>(R.id.item_name)
        val itemQuantity = findViewById<EditText>(R.id.item_quantity)
        val itemPrice = findViewById<EditText>(R.id.item_price)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.setOnClickListener {
            val name = itemName.text.toString()
            val quantity = itemQuantity.text.toString().toIntOrNull() ?: 0
            val price = itemPrice.text.toString().toDoubleOrNull() ?: 0.0

            viewModel.saveItem(name, quantity, price)
        }
    }
}
