package com.example.crud.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud.Models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDatabaseDao {
    @Insert
    suspend fun agregarProduct(product: Product)

    @Query("SELECT * FROM Product")
    fun obtenerProducts(): Flow<List<Product>>

    @Update
    suspend fun actualizarProduct(product: Product)

    @Delete
    suspend fun borrarProduct(product: Product)
}
