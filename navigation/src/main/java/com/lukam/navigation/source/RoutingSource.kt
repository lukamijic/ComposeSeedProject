package com.lukam.navigation.source

import com.lukam.navigation.command.NavigationCommand
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class RoutingSource<T: NavigationCommand>() : DispatchRoutingCommand<T>, QueryRoutingCommands<T> {

    private val routingCommands = MutableSharedFlow<T>()

    override suspend fun invoke(command: T) {
        routingCommands.emit(command)
    }

    override fun invoke(): Flow<T> = routingCommands
}
