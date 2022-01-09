package com.lukam.navigation.source

import com.lukam.navigation.command.NavigationCommand
import kotlinx.coroutines.flow.Flow

interface QueryRoutingCommands<T: NavigationCommand> {

    operator fun invoke() : Flow<T>
}
