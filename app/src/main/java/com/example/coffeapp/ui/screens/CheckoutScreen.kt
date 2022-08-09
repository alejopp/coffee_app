package com.example.coffeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeapp.models.Product
import com.example.coffeapp.ui.components.*
import com.example.coffeapp.ui.theme.CoffeAppTheme
import com.example.coffeapp.utils.MockDataProvider

@Composable
fun CheckoutScreen(navController: NavController, product: Product) {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )
    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}
    var message by remember { mutableStateOf<String?>(null)}

    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Coffee App",
                navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("detail/${product.id}")
            }
        },
        content = {
            Alert(title = "Congratulations", message = message) {
                navController.navigate("feedScreen"){
                    launchSingleTop = true
                    popUpTo("feedScreen")
                }
            }
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ProductCard(
                    product
                ) {}
                Column(modifier = Modifier.padding(16.dp)) {
                    CustomTextField(value = name, placeholder = "Fullname"){
                        name = it
                    }
                    CustomTextField(value = email, placeholder = "Email"){
                        name = it
                    }
                    CustomTextField(value = phone, placeholder = "Phone number"){
                        name = it
                    }
                    CustomTextField(value = address, placeholder = "Address"){
                        name = it
                    }
                    DropdownTextField(
                        suggestions = cities,
                        value = city,
                        placeholder = "Cities" ,
                        onChangeValue = { cityName ->
                            city = cityName
                        })
                    Column {
                        Row {
                            Text("Shipment", style = MaterialTheme.typography.caption)
                            Text(
                                "10 UDS",
                                style = MaterialTheme.typography.caption,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "$45 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        CustomButton(label = "End shipment") {
                            //TODO validate fields
                            message = "Your order has been created."
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    CoffeAppTheme() {
        MockDataProvider.getProductById(0)?.let { product ->
            CheckoutScreen(navController, product)
        }
    }
}