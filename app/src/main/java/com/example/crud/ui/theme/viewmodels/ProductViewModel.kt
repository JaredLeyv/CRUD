package com.example.crud.ui.theme.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.Models.Product
import com.example.crud.Room.ProductDatabaseDao

import com.example.crud.States.ProductState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProductViewModel(
    private val dao: ProductDatabaseDao
) : ViewModel() {
    var state by mutableStateOf(ProductState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerProducts().collectLatest {
                state = state.copy(
                    listaProduct = it
                )
            }
        }
    }

    fun agregarProduct(product: Product) = viewModelScope.launch {
        dao.agregarProduct(product = product)
    }

    fun actualizarProduct(product: Product) = viewModelScope.launch {
        dao.actualizarProduct(product = product)
    }

    fun borrarProduct(product: Product) = viewModelScope.launch {
        dao.borrarProduct(product = product)
    }
}
