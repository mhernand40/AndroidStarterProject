package com.starter.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.starter.ui.MessageUiModel.Loading
import com.starter.ui.MessageUiModel.Loaded

@Composable
internal fun MessageContent(
    uiModel: MessageUiModel,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        when (uiModel) {
            is Loading -> CircularProgressIndicator()
            is Loaded -> Text(text = uiModel.message)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MessageContentPreview_Loading() {
    MessageContent(uiModel = Loading)
}

@Preview(showBackground = true)
@Composable
private fun MessageContentPreview_Loaded() {
    MessageContent(uiModel = Loaded(message = "Hello World!"))
}