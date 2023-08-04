package br.senai.sp.jandira.navigationroutes.components

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun botao(textoDoBotao: String, naveController: NavController, navNome: String) {
    Button(
        onClick = { naveController.navigate(navNome) },
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Text(text = textoDoBotao, color = Color.Black)
    }
}




