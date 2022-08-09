package com.example.coffeapp.ui.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeapp.ui.components.CountryISO
import com.example.coffeapp.ui.screens.CheckoutScreen
import com.example.coffeapp.ui.screens.DetailScreen
import com.example.coffeapp.ui.screens.FeedScreen
import com.example.coffeapp.ui.theme.CoffeAppTheme
import com.example.coffeapp.utils.MockDataProvider

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    CoffeAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feedScreen" ){
                composable(route = "feedScreen"){
                    FeedScreen(navController)
                }
                composable(route = "detailScreen/{productId}"){
                    val productIdString = it.arguments?.getString("productId") ?: "0"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductById(productId)
                    DetailScreen(product!!,navController)
                }
                composable(route = "checkoutScreen/{productId}"){ it ->
                    val productIdString = it.arguments?.getString("productId") ?: "0"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductById(productId)
                    CheckoutScreen(navController, product!!)
                }
            }
        }
    }
}