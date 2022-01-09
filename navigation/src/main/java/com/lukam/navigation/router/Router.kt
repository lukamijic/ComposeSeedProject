package com.lukam.navigation.router

import com.lukam.navigation.command.NavigationCommand

interface Router<T: NavigationCommand> {

    fun route(command: T)
}
