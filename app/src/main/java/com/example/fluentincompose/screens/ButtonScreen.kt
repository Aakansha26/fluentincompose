package com.example.fluentincompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fluentincompose.controls.FluentButton
import com.example.fluentincompose.controls.FluentButtonLarge
import com.example.fluentincompose.controls.FluentOutlinedButton
import com.example.fluentincompose.controls.FluentTextButton

@Composable
fun ButtonScreen() {

    Column(
        Modifier
            .padding(0.dp, 92.dp, 0.dp, 0.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        FluentButton(onClick = {}) {
            Text(text = "BUTTON")
        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentButton(onClick = {}, enabled = false) {
            Text(text = "BUTTON")
        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentOutlinedButton(onClick = {}) {
            Text(text = "OUTLINED BUTTON")

        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentOutlinedButton(onClick = {}, enabled = false) {
            Text(text = "OUTLINED BUTTON")

        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentTextButton(onClick = {}) {
            Text(text = "BUTTON BORDERLESS")
        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentTextButton(onClick = {}, enabled = false) {
            Text(text = "BUTTON BORDERLESS")
        }

        Spacer(modifier = Modifier.height(20.dp))


        FluentButtonLarge(onClick = {}) {
            Text(text = "BUTTON LARGE")
        }

        Spacer(modifier = Modifier.height(20.dp))

        FluentButtonLarge(onClick = {}, enabled = false) {
            Text(text = "BUTTON LARGE")
        }

        Spacer(modifier = Modifier.height(20.dp))
        
        Button(onClick = {}) {
            Text(text = "hello")
        }

    }
}