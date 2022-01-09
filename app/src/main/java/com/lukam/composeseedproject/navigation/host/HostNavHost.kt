package com.lukam.composeseedproject.navigation.host

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lukam.composeseedproject.navigation.ObserveRoutingCommands
import com.lukam.navigation.source.impl.HostCommands
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf

@Composable
fun HostNavHost() {
    val hostController = rememberNavController()

    ObserveRoutingCommands(
        get<HostCommands>(),
        get<HostRouter>(parameters = { parametersOf(hostController) })
    )
    NavHost(navController = hostController, startDestination = HostRouter.LANDING) {
        composable(HostRouter.LANDING) {
            Surface {

            }
        }
    }
}


