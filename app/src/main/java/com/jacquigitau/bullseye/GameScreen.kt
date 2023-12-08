package com.jacquigitau.bullseye

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacquigitau.bullseye.ui.TargetSlider
import com.jacquigitau.bullseye.ui.theme.BullseyeTheme
import kotlin.random.Random

/**
 * PROJECT NAME: Bullseye
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/4/23
 * TIME        : 9:33 PM
 */

@Composable
fun GameScreen() {

    var alertIsVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var sliderChange by rememberSaveable { mutableStateOf(value = 0.5f) }
    var targetValue by rememberSaveable {
        mutableStateOf(Random.nextInt(1,100))
    }

    val sliderToInt = (sliderChange * 100).toInt()

    fun pointsForCurrentRounds(): Int{
        return 999
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            GamePrompt(targetValue = targetValue)
            TargetSlider(value = sliderChange, valueChanged = { value -> sliderChange = value })

            Button(onClick = {
                alertIsVisible = true
            }) {
                Text(text = stringResource(R.string.text_button))
                Log.i("Alert showing?", alertIsVisible.toString())
            }
        }
        Spacer(modifier = Modifier.weight(.5f))

        if(alertIsVisible) {
            ResultDialog(
                hideDialog = { alertIsVisible = false },
                sliderValue = sliderToInt,
                points = pointsForCurrentRounds()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreenPreview() {
    BullseyeTheme {
        GameScreen()
    }
}