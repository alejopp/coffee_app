package com.example.coffeapp.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeapp.ui.theme.CoffeAppTheme

@Composable
fun Alert(title: String, message: String?, onClose: () -> Unit) {
    if (message != null){
        AlertDialog(
            onDismissRequest = { onClose()},
            title = {
                Text(title, style = TextStyle(color = Color.Black))
            },
            text = {
                Text(message)
            },
            confirmButton = {
                Button(onClick = { onClose()}) {
                    Text("Ok")
                }
            }
        )
    }
}


@Composable
@Preview(name = "light_mode", showBackground = true)
@Preview(name = "dark_mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun AlertPreview(){
    CoffeAppTheme() {
        Surface {
            Alert(title = "", message = null) {
            }
        }
    }
}