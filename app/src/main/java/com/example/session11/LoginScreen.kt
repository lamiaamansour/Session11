package com.example.session11

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var age  by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(value = firstName, onValueChange = {newValue ->
            firstName=newValue
        } ,
            label = { Text(text = "firstName") })

        OutlinedTextField(value = lastName, onValueChange = {newValue ->
            lastName=newValue
        } ,
            label = { Text(text = "lastName") })

        OutlinedTextField(value = age, onValueChange = {newValue ->
            age=newValue
        } ,
            label = { Text(text = "age") })

        OutlinedTextField(value = email, onValueChange = {newValue ->
            email=newValue
        } ,
            label = { Text(text = "email") })

        Button(onClick = {navController.navigate("register/$firstName,$lastName,$age,$email")}) {
            Text(text = "Register")
        }
    }
}