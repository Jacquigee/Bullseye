package com.jacquigitau.bullseye.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jacquigitau.bullseye.R

/**
 * PROJECT NAME: Bullseye
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/9/23
 * TIME        : 5:57 AM
 */

@Composable
fun GameDetail(
    modifier: Modifier = Modifier,
    totalScore: Int,
    round: Int,
    onStartOver: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        FilledIconButton(
            onClick = { onStartOver() },
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                Icons.Filled.Refresh,
                contentDescription = stringResource(id = R.string.start_over)
            )

        }

        GameInfo(label = stringResource(R.string.score), value = totalScore)
        GameInfo(label = stringResource(R.string.round), value = round)

        FilledIconButton(
            onClick = { }, colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ), modifier = Modifier.size(50.dp)
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = stringResource(id = R.string.info)
            )
        }
    }
}

@Composable
fun GameInfo(label: String, value:Int = 0){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        Text(label)
        Text(
            value.toString(),
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailPreview(){
    GameDetail(totalScore = 0, round = 1, onStartOver = {})
}