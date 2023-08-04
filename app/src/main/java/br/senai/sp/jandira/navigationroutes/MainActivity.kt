package br.senai.sp.jandira.navigationroutes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.navigationroutes.app.loginScreen
import br.senai.sp.jandira.navigationroutes.app.menuScreen
import br.senai.sp.jandira.navigationroutes.app.pedidosScreen
import br.senai.sp.jandira.navigationroutes.app.perfilScreen
import br.senai.sp.jandira.navigationroutes.ui.theme.NavigationRoutesTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationRoutesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentScope.SlideDirection.End, tween(1000)
                            )
                        }) {
                        composable(route = "login") {
                            AnimatedVisibility(visible = true, enter = fadeIn(), exit = fadeOut()) {
                                login(navController)
                            }
                        }
                        composable(route = "menu") { menu(navController) }
                        composable(route = "perfil") { perfil(navController) }
                        composable(route = "pedidos") { pedidos(navController) }


                    }

                }
            }
        }
    }
}

@Composable
fun login(navController: NavController) {
    loginScreen(
        textoHeader = "LOGIN",
        corDeFundo = Color.Magenta,
        textoBotao = "entrar",
        navController = navController
    )
}

@Composable
fun menu(navController: NavController) {
    menuScreen(
        textoHeader = "MENU",
        corDeFundo = Color.Blue,
        textoBotao1 = "PERFIL",
        textoBotao2 = "PEDIDOS",
        textoBotao3 = "SAIR",
        navController = navController

    )
}

@Composable
fun perfil(navController: NavController) {
    perfilScreen(
        textoHeader = "PERFIL",
        corDeFundo = Color.Green,
        textoBotao = "VOLTAR",
        navController = navController
    )

}

@Composable
fun pedidos(navController: NavController) {
    pedidosScreen(
        textoHeader = "PEDIDOS",
        corDeFundo = Color.Gray,
        textoBotao = "VOLTAR",
        navController
    )

}




