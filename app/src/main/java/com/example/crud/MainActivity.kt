package com.example.crud

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.crud.Navigation.NavManager
import com.example.crud.Room.ProductDatabase
import com.example.crud.ui.theme.CrudTheme

import com.example.crud.ui.theme.viewmodels.ProductViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val database = Room.databaseBuilder(
                        applicationContext,
                        ProductDatabase::class.java,
                        "db_product"
                    ).build()
                    val dao = database.productDao()

                    val viewModel = ProductViewModel(dao)

                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CrudTheme {
        Text(text = "Hello, World!")
    }
}
