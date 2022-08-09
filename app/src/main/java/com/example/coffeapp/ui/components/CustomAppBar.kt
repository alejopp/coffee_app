package com.example.coffeapp.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.ui.theme.CoffeAppTheme

@Composable
fun CustomAppBar(title: String = "", navigationIcon: ImageVector? = null, navigationAction: () -> Unit? = {}) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon =
        navigationIcon?.let {
            {
                IconButton(onClick = { navigationAction() }) {
                    Icon(navigationIcon, contentDescription = null)
                }
            }
        }
    )
}

@Preview
@Composable
fun CustomAppBarPreview() {
    CoffeAppTheme() {
        CustomAppBar("Coffee App")
    }

}