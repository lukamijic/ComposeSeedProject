package com.lukam.composeseedproject.di

import androidx.navigation.NavHostController
import com.lukam.composeseedproject.navigation.host.HostRouter
import org.koin.dsl.module

fun routerModule() = module {

    factory { (controller: NavHostController) ->
        HostRouter(controller)
    }
}


