package com.lukam.navigation.di

import com.lukam.navigation.source.impl.HostCommands
import com.lukam.navigation.source.impl.HostDispatcher
import com.lukam.navigation.source.impl.HostRoutingSource
import org.koin.dsl.module

fun navigationModule() = module {

    single { HostRoutingSource() }
    single { HostDispatcher(get()) }
    single { HostCommands(get()) }
}
