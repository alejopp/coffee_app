package com.example.coffeapp.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.ui.theme.CoffeAppTheme

@Composable
fun BodyText(body: String) {
    Text(body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    CoffeAppTheme() {
        TitleText( "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    }
}