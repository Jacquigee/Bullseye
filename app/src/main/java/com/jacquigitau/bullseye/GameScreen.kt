package com.jacquigitau.bullseye

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.jacquigitau.bullseye.ui.theme.BullseyeTheme

/**
 * PROJECT NAME: Bullseye
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/4/23
 * TIME        : 9:33 PM
 */

@Composable
fun GameScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "PUT THE BULLSEYE AS CLOSE AS YOU CAN")
        Text(text = "89")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "1")
            Slider(
                value = 0.5f,
                valueRange = 0.01f..1f,
                onValueChange = {}
            )
            Text(text = "100")
        }

        Button(onClick = {  }) {
            Text(text = "Hit Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BullseyeTheme {
        GameScreen()
    }
}