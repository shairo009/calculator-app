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
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
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
    val displayValue: String = viewModel.display

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CalcColors.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        // Display area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 24.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = displayValue,
                fontSize = if (displayValue.length > 9) 48.sp else 64.sp,
                fontWeight = FontWeight.Light,
                color = CalcColors.textWhite,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Row 1: AC, +/-, %, ÷
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FunctionButton("AC", CalcColors.functionBtn) { viewModel.onClearClick() }
                FunctionButton("+/-", CalcColors.functionBtn) { }
                FunctionButton("%", CalcColors.functionBtn) { }
                OperatorButton("÷") { viewModel.onOperatorClick(CalculatorViewModel.Operator.DIVIDE) }
            }

            // Row 2: 7, 8, 9, ×
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                NumberButton("7") { viewModel.onNumberClick("7") }
                NumberButton("8") { viewModel.onNumberClick("8") }
                NumberButton("9") { viewModel.onNumberClick("9") }
                OperatorButton("×") { viewModel.onOperatorClick(CalculatorViewModel.Operator.MULTIPLY) }
            }

            // Row 3: 4, 5, 6, −
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                NumberButton("4") { viewModel.onNumberClick("4") }
                NumberButton("5") { viewModel.onNumberClick("5") }
                NumberButton("6") { viewModel.onNumberClick("6") }
                OperatorButton("−") { viewModel.onOperatorClick(CalculatorViewModel.Operator.SUBTRACT) }
            }

            // Row 4: 1, 2, 3, +
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                NumberButton("1") { viewModel.onNumberClick("1") }
                NumberButton("2") { viewModel.onNumberClick("2") }
                NumberButton("3") { viewModel.onNumberClick("3") }
                OperatorButton("+") { viewModel.onOperatorClick(CalculatorViewModel.Operator.ADD) }
            }

            // Row 5: 0 (wide), ., =
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumberButton("0", wide = true) { viewModel.onNumberClick("0") }
                NumberButton(".") { viewModel.onNumberClick(".") }
                OperatorButton("=") { viewModel.onEqualsClick() }
            }
        }
    }
}

@Composable
fun RowScope.NumberButton(text: String, wide: Boolean = false, onClick: () -> Unit) {
    val weight = if (wide) 2f else 1f
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(weight)
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CalcColors.numberBtn,
            contentColor = CalcColors.textWhite
        ),
        shape = if (wide) RoundedCornerShape(20.dp) else CircleShape
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun RowScope.OperatorButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CalcColors.operatorBtn,
            contentColor = CalcColors.textWhite
        ),
        shape = CircleShape
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RowScope.FunctionButton(text: String, backgroundColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = CalcColors.textWhite
        ),
        shape = CircleShape
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
