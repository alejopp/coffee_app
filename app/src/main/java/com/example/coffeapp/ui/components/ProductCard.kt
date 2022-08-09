package com.example.coffeapp.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeapp.R
import com.example.coffeapp.models.Product
import com.example.coffeapp.ui.theme.Blue
import com.example.coffeapp.ui.theme.CoffeAppTheme
import com.example.coffeapp.ui.theme.Green
import com.example.coffeapp.utils.MockDataProvider
import androidx.compose.foundation.layout.padding as padding

enum class CountryISO(
    val alias: String,
    val image: Int,
    val flag: Int,
    val surfaceColor: Color,
) {
    COL("COL", R.drawable.co, R.drawable.flagco, Blue),
    BRA("BRA", R.drawable.br, R.drawable.flagbr, Green),
    CRI("CRI",R.drawable.ri, R.drawable.flagri, Green),
    NIC("NIC",R.drawable.ni, R.drawable.flagni, Blue)
}

@Composable
fun ProductCard(product: Product,
                selectedProduct: () -> Unit
){
    val country = CountryISO.valueOf(product.countryISO)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { selectedProduct() }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
       Image(
            painter = painterResource(id = country.image), contentDescription = null
       )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.surfaceColor.copy(alpha = 0.2f)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ){
                Text(text = product.title, style = MaterialTheme.typography.h4)
                Text(text = product.description, style = MaterialTheme.typography.body1)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row{
                        Image(painter = painterResource(
                            id = country.flag), contentDescription = null
                        )
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductCardPreview(){
    CoffeAppTheme(){
        MockDataProvider.getProductById(0)?.let {
            ProductCard(it) {}
        }
    }
}
