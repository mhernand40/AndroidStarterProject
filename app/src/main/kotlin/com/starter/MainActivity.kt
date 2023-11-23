package com.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.starter.message.ui.MessageScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

  @Inject internal lateinit var circuit: Circuit

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val backstack = rememberSaveableBackStack { push(MessageScreen) }
      val navigator = rememberCircuitNavigator(backstack)
      CircuitCompositionLocals(circuit) { NavigableCircuitContent(navigator, backstack) }
    }
  }
}
