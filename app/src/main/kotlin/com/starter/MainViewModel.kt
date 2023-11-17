package com.starter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import com.starter.ui.MessageUiModel.Loaded
import com.starter.ui.MessageUiModel.Loading
import com.starter.ui.MessageUiModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
internal class MainViewModel @Inject constructor() : ViewModel() {
    val uiModel: StateFlow<MessageUiModel> =
        flow<MessageUiModel> {
            delay(2.seconds)
            emit(Loaded(message = "Hello World!"))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Loading,
        )
}