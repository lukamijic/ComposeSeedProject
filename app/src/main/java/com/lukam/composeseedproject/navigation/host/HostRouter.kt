package com.lukam.composeseedproject.navigation.host

import androidx.navigation.NavHostController
import com.lukam.navigation.command.HostCommand
import com.lukam.navigation.command.Landing
import com.lukam.navigation.router.Router

class HostRouter(private val controller: NavHostController) : Router<HostCommand> {

    companion object {

        const val LANDING = "landing"
    }

    override fun route(command: HostCommand) = when(command) {
        Landing -> controller.navigate(LANDING)
    }
}
