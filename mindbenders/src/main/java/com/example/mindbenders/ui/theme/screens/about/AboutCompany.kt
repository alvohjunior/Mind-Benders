package com.example.mindbenders.ui.theme.screens.about


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mindbenders.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About( navController: NavController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.dashboard),
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds
        )
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "This is our about page",
             modifier = Modifier, color = Color.Magenta)
    }
                }







@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutCompanyPreview(){
    About(rememberNavController())
}


