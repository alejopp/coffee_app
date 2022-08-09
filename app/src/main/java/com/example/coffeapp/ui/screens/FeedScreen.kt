package com.example.coffeapp.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeapp.ui.components.*
import com.example.coffeapp.ui.theme.CoffeAppTheme
import com.example.coffeapp.utils.MockDataProvider

@Composable
fun FeedScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomAppBar("Coffee App")
        },
        content = {
            val productList = MockDataProvider.listOfProducts()
            CoffeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
                        item {
                            Column {
                                TitleText(title = "Bienvenido")
                                BodyText(body = "Aqui el contenido del body, este es solo un ejemplo")
                            }
                        }
                        items(productList) { product ->
                            ProductCard(product){
                                navController.navigate("detailScreen/${product.id}")
                            }
                        }
                    }
                }
            }
        }
    )

}


@Composable
@Preview(name = "light_mode", showBackground = true)
@Preview(name = "dark_mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun FeedScreenPreview() {
    CoffeAppTheme() {
        val navController = rememberNavController()
        FeedScreen(navController)
    }
}