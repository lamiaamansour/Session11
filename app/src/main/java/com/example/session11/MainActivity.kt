package com.example.session11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.session11.ui.theme.Session11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session11Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController)
                    }

                    composable(
                        "register/{fname},{lname},{age},{email}",
                        arguments = listOf(
                            navArgument("fname") { type = NavType.StringType },
                            navArgument("lname") { type = NavType.StringType },
                            navArgument("age") { type = NavType.StringType },
                            navArgument("email") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val fname: String =
                            backStackEntry.arguments?.getString("fname") ?: "no name add"
                        val lname: String =
                            backStackEntry.arguments?.getString("lname") ?: "no name add"
                        val age: String = backStackEntry.arguments?.getString("age") ?: "no age add"
                        val email: String =
                            backStackEntry.arguments?.getString("email") ?: "no email add"

                        RegisterScreen(fname = fname, lname = lname, age = age, email = email )
                    }
                }
            }
        }
    }
}
