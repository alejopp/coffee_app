package com.example.coffeapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeapp.ui.theme.CoffeAppTheme


typealias ButtonAction = () -> Unit
@Composable
fun CustomButton(label: String, action: ButtonAction) {
    val upperCaseLabel = label.uppercase()

    Button(
        onClick = {action()},
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = upperCaseLabel)
    }
}


@Preview( showBackground = true)
@Composable
fun CustomButtonPreview() {
    CoffeAppTheme() {
        Box(modifier = Modifier.padding(16.dp)) {
            CustomButton("Button"){}
        }
    }
}