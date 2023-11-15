package com.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(content = "Hello World")
        }
    }
}