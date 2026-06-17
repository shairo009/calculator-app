package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextOverflow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CalculatorTheme {
                CalculatorScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val display by viewModel.display

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        // Display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFF1E1E1E))
                .padding(24.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = display,
                fontSize = 80.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Row 1: Clear, ÷
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalculatorButton(
                    text = "C",
                    onClick = { viewModel.onClearClick() },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFF333333),
                    textColor = Color.White
                )
                CalculatorButton(
                    text = "÷",
                    onClick = { viewModel.onOperatorClick(CalculatorViewModel.Operator.DIVIDE) },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9F0A),
                    textColor = Color.White
                )
            }

            // Row 2: 7, 8, 9, ×
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                numberButton("7") { viewModel.onNumberClick("7") }
                numberButton("8") { viewModel.onNumberClick("8") }
                numberButton("9") { viewModel.onNumberClick("9") }
                CalculatorButton(
                    text = "×",
                    onClick = { viewModel.onOperatorClick(CalculatorViewModel.Operator.MULTIPLY) },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9F0A),
                    textColor = Color.White
                )
            }

            // Row 3: 4, 5, 6, −
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                numberButton("4") { viewModel.onNumberClick("4") }
                numberButton("5") { viewModel.onNumberClick("5") }
                numberButton("6") { viewModel.onNumberClick("6") }
                CalculatorButton(
                    text = "−",
                    onClick = { viewModel.onOperatorClick(CalculatorViewModel.Operator.SUBTRACT) },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9F0A),
                    textColor = Color.White
                )
            }

            // Row 4: 1, 2, 3, +
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                numberButton("1") { viewModel.onNumberClick("1") }
                numberButton("2") { viewModel.onNumberClick("2") }
                numberButton("3") { viewModel.onNumberClick("3") }
                CalculatorButton(
                    text = "+",
                    onClick = { viewModel.onOperatorClick(CalculatorViewModel.Operator.ADD) },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9F0A),
                    textColor = Color.White
                )
            }

            // Row 5: 0, ., =
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalculatorButton(
                    text = "0",
                    onClick = { viewModel.onNumberClick("0") },
                    modifier = Modifier.weight(2f).fillMaxWidth(),
                    backgroundColor = Color(0xFF333333),
                    textColor = Color.White
                )
                numberButton(".") { viewModel.onNumberClick(".") }
                CalculatorButton(
                    text = "=",
                    onClick = { viewModel.onEqualsClick() },
                    modifier = Modifier.weight(1f),
                    backgroundColor = Color(0xFFFF9F0A),
                    textColor = Color.White
                )
            }
        }
    }
}

@Composable
fun numberButton(text: String, onClick: () -> Unit) {
    CalculatorButton(
        text = text,
        onClick = onClick,
        modifier = Modifier.weight(1f),
        backgroundColor = Color(0xFF333333),
        textColor = Color.White
    )
}

@Composable
fun CalculatorButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF333333),
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
        )
    }
}