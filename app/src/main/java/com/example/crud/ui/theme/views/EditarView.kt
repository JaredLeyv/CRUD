package com.example.crud.ui.theme.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crud.Models.Product
import com.example.crud.ui.theme.viewmodels.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(
    navController: NavController,
    viewModel: ProductViewModel,
    id: Int,
    name: String?,
    description: String?,
    category: String?,
    price: Float?,
    quantity: Int?
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Editar Producto", color = Color.White, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentEditarView(it, navController, viewModel, id, name, description, category, price, quantity)
    }
}

@Composable
fun ContentEditarView(
    it: PaddingValues,
    navController: NavController,
    viewModel: ProductViewModel,
    id: Int,
    name: String?,
    description: String?,
    category: String?,
    price: Float?,
    quantity: Int?
) {
    var name by remember { mutableStateOf(name ?: "") }
    var description by remember { mutableStateOf(description ?: "") }
    var category by remember { mutableStateOf(category ?: "") }
    var price by remember { mutableStateOf(price?.toString() ?: "") }
    var quantity by remember { mutableStateOf(quantity?.toString() ?: "") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Descripción") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text(text = "Categoría") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text(text = "Precio") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text(text = "Cantidad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val priceFloat = price.toFloatOrNull() ?: 0.0f
                val quantityInt = quantity.toIntOrNull() ?: 0

                val product = Product(
                    id = id,
                    name = name,
                    description = description,
                    category = category,
                    price = priceFloat,
                    quantity = quantityInt
                )

                viewModel.actualizarProduct(product)
                navController.popBackStack()
            }
        ) {
            Text(text = "Guardar Cambios")
        }
    }
}
