package com.example.coffeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun DetailScreen(product: Product, navController: NavController) {
    val country  = CountryISO.valueOf(product.countryISO)
    Scaffold(
        topBar = {
            CustomAppBar(title = "Coffee App", navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("feedScreen"){
                    popUpTo
                }
            }
                 },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ){
                    Image(
                        painter = painterResource(id = country.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleText(title = product.title)
                    Text(text = product.description, style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(
                        body = product.summary)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "${product.price} ${product.currency}",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continue") {
                            navController.navigate("checkoutScreen/${product.id}")
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    CoffeAppTheme() {
        MockDataProvider.getProductById(0)?.let { product ->
            DetailScreen(product, navController)
        }
    }
}