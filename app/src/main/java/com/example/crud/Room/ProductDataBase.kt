package com.example.crud.Room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crud.Models.Product

@Database(entities = [Product::class], version = 2, exportSchema = false) // Incrementa la versión si hay cambios
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDatabaseDao
}
