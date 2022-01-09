package com.lukam.navigation.source

import com.lukam.navigation.command.NavigationCommand

interface DispatchRoutingCommand<T : NavigationCommand> {

    suspend operator fun invoke(command: T)
}
