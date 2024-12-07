package com.example.crud.States

import com.example.crud.Models.Product

data class ProductState(
    val listaProduct: List<Product> = emptyList()
)
