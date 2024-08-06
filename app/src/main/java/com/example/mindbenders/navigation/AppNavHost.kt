package com.example.mindbenders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mindbenders.Greeting
import com.example.mindbenders.ui.theme.screens.home.HomeScreen

@Composable
fun AppNavHost(navController:NavHostController= rememberNavController(),
               startDestination: String = ROUTE_REGISTER ){
              NavHost(navController=navController,
                  startDestination=startDestination){
                  composable(ROUTE_REGISTER){ Greeting("Alvin")}
                  composable(ROUTE_HOME){ HomeScreen(navController) }

              }


}

