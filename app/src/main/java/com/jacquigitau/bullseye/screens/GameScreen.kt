package com.jacquigitau.bullseye.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacquigitau.bullseye.R
import com.jacquigitau.bullseye.components.GameDetail
import com.jacquigitau.bullseye.components.GamePrompt
import com.jacquigitau.bullseye.components.ResultDialog
import com.jacquigitau.bullseye.ui.TargetSlider
import com.jacquigitau.bullseye.ui.theme.BullseyeTheme
import kotlin.math.abs
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

    fun newTargetValue() = Random.nextInt(1, 100)

    var alertIsVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var sliderValue by rememberSaveable { mutableStateOf(value = 0.5f) }
    var targetValue by rememberSaveable {
        mutableStateOf(newTargetValue())
    }

    val sliderToInt = (sliderValue * 100).toInt()

    var totalScore by rememberSaveable {
        mutableStateOf(0)
    }

    var currentRound by rememberSaveable {
        mutableStateOf(1)
    }

    fun differenceAmount() = abs(targetValue - sliderToInt)

    // Function to implement logic that calculates points for the current round.
    fun pointsForCurrentRound(): Int {
        val maxScore = 100
        val difference = differenceAmount()
        var bonus = 0

        if (difference == 0) {
            bonus = 100
        } else if (difference == 1) {
            bonus = 50
        }

        return (maxScore - difference) + bonus
    }

    fun alertTitle(): Int{
        val difference = differenceAmount()

        val title: Int = if (difference == 0){
            R.string.alert_title_1
        } else if (difference < 5){
            R.string.alert_title_2
        } else if (difference <= 10){
            R.string.alert_title_3
        }   else { R.string.alert_title_4}

        return title
    }

    fun startNewGame(){
        totalScore = 0
        currentRound = 1
        sliderValue = 0.5f
        targetValue = newTargetValue()
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
            TargetSlider(value = sliderValue, valueChanged = { value -> sliderValue = value })

            Button(onClick = {
                alertIsVisible = true
                totalScore += pointsForCurrentRound()
            },
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = stringResource(R.string.text_button))
                Log.i("Alert showing?", alertIsVisible.toString())
            }

            GameDetail(
                totalScore = totalScore,
                round = currentRound,
                onStartOver = {startNewGame()},
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.weight(.5f))


        if(alertIsVisible) {
            ResultDialog(
                dialogTitle = alertTitle(),
                hideDialog = { alertIsVisible = false },
                sliderValue = sliderToInt,
                points = pointsForCurrentRound(),
                onRoundValue = {
                    currentRound += 1
                    targetValue = newTargetValue()
                },

                )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.AUTOMOTIVE_1024p,
    widthDp = 864,
    heightDp = 432
)
@Composable
fun GameScreenPreview() {
    BullseyeTheme {
        GameScreen()
    }
}