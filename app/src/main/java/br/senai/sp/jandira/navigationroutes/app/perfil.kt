package br.senai.sp.jandira.navigationroutes.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.navigationroutes.components.botao

@Composable
fun perfilScreen(textoHeader: String, corDeFundo: Color, textoBotao: String, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corDeFundo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = textoHeader, fontSize = 30.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.size(300.dp))
        botao(textoDoBotao = textoBotao, navController, "menu")
    }

}