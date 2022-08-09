package com.example.coffeapp.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.ui.theme.CoffeAppTheme

@Composable
fun TitleText(title: String) {
    Text(title, style = MaterialTheme.typography.h3)
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    CoffeAppTheme() {
        TitleText(title = "Title")
    }
}