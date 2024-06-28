package com.example.kotlin_room2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val preco: Double,
    val quantidade: Int
)
