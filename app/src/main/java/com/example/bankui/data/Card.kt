package com.example.bankui.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class Card(
    val cardType: String,
    val accountType: String,
    val cardNumber: String,
    val cardHolderName: String,
    val balance: Double,
    val color: Brush,
)
