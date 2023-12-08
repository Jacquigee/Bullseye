package com.jacquigitau.bullseye

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * PROJECT NAME: Bullseye
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/8/23
 * TIME        : 4:23 AM
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GamePrompt(modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = stringResource(R.string.instruction_text))
        Text(
            text = stringResource(R.string.target_vaue),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}