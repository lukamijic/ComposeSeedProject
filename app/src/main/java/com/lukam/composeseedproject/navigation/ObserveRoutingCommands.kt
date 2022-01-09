package com.lukam.composeseedproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.lukam.navigation.command.NavigationCommand
import com.lukam.navigation.router.Router
import com.lukam.navigation.source.QueryRoutingCommands
import kotlinx.coroutines.launch

@Composable
fun <T : NavigationCommand> ObserveRoutingCommands(commands: QueryRoutingCommands<T>, router: Router<T>) {
    val scope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        scope.launch { commands().collect { router.route(it) } }

        onDispose {}
    }
}
