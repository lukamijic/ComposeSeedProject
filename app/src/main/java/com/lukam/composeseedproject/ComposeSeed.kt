package com.lukam.composeseedproject

import android.app.Application
import com.lukam.composeseedproject.di.routerModule
import com.lukam.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposeSeed : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@ComposeSeed)
            modules(
                listOf(
                    routerModule(),
                    navigationModule()
                )
            )
        }
    }
}
