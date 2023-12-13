package com.jacquigitau.bullseye.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jacquigitau.bullseye.R

/**
 * PROJECT NAME: Bullseye
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/5/23
 * TIME        : 11:22 PM
 */

@Composable
fun ResultDialog(
    dialogTitle: Int,
    hideDialog: () -> Unit,
    onRoundValue: () -> Unit,
    sliderValue: Int,
    points: Int,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = {
            hideDialog()
            onRoundValue()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hideDialog()
                    onRoundValue()
                }) {
                Text(stringResource(R.string.button_dialog_text))
            }
        }, title = { Text(text = stringResource(id = dialogTitle)) }, text = {
            Text(
                text = stringResource(
                    R.string.dialog_text, sliderValue, points
                )

            )
    })
}