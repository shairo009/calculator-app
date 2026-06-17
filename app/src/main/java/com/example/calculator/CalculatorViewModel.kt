package com.example.calculator

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class CalculatorViewModel : ViewModel() {

    val display: MutableState<String> = mutableStateOf("0")

    private var currentInput = ""
    private var previousValue: Double? = null
    private var pendingOperator: Operator? = null
    private var shouldResetDisplay = false

    enum class Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    fun onNumberClick(number: String) {
        if (shouldResetDisplay) {
            currentInput = number
            shouldResetDisplay = false
        } else {
            if (currentInput == "0" && number != ".") {
                currentInput = number
            } else if (number == "." && currentInput.contains(".")) {
                return
            } else {
                currentInput += number
            }
        }
        display.value = currentInput
    }

    fun onOperatorClick(operator: Operator) {
        val currentValue = currentInput.toDoubleOrNull() ?: return

        if (previousValue != null && pendingOperator != null && !shouldResetDisplay) {
            calculateResult()
        }

        previousValue = currentValue
        pendingOperator = operator
        shouldResetDisplay = true
    }

    fun onEqualsClick() {
        calculateResult()
        pendingOperator = null
        previousValue = null
        shouldResetDisplay = true
    }

    fun onClearClick() {
        currentInput = "0"
        previousValue = null
        pendingOperator = null
        shouldResetDisplay = false
        display.value = "0"
    }

    private fun calculateResult() {
        val currentValue = currentInput.toDoubleOrNull() ?: return
        val prev = previousValue ?: return
        val op = pendingOperator ?: return

        val result = when (op) {
            Operator.ADD -> prev + currentValue
            Operator.SUBTRACT -> prev - currentValue
            Operator.MULTIPLY -> prev * currentValue
            Operator.DIVIDE -> if (currentValue != 0.0) prev / currentValue else Double.NaN
        }

        currentInput = if (result.isNaN()) {
            "Error"
        } else if (result == result.toLong().toDouble()) {
            result.toLong().toString()
        } else {
            result.toString()
        }
        display.value = currentInput
        previousValue = result
    }
}