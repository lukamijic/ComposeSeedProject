package com.lukam.navigation.command

sealed class HostCommand : NavigationCommand
object Landing: HostCommand()
