package com.example.crud.Models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey(autoGenerate = true) // Asegura que se generen IDs únicos automáticamente
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "price")
    val price: Float,
    @ColumnInfo(name = "quantity")
    val quantity: Int
)

