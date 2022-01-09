package com.lukam.composeseedproject.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lukam.coreui.theme.ComposeSeedProjectTheme
import com.lukam.composeseedproject.navigation.host.HostNavHost

class HostActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeSeedProjectTheme {
                HostNavHost()
            }
        }
    }
}
