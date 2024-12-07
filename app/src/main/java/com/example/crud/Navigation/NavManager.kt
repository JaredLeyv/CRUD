package com.example.crud.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.crud.ui.theme.viewmodels.ProductViewModel
import com.example.crud.ui.theme.views.AgregarView
import com.example.crud.ui.theme.views.EditarView
import com.example.crud.ui.theme.views.InicioView

@Composable
fun NavManager(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{name}/{description}/{category}/{price}/{quantity}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("name") { type = NavType.StringType },
            navArgument("description") { type = NavType.StringType },
            navArgument("category") { type = NavType.StringType },
            navArgument("price") { type = NavType.FloatType },
            navArgument("quantity") { type = NavType.IntType }
        )) {
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("name"),
                it.arguments?.getString("description"),
                it.arguments?.getString("category"),
                it.arguments?.getFloat("price"),
                it.arguments?.getInt("quantity")
            )
        }
    }
}
