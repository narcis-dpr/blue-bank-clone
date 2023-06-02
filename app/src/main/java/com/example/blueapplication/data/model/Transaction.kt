package com.example.blueapplication.data.model

import androidx.room.ColumnInfo

data class Transaction(
    val transactionType: Int,
    val date: String,
    val amount: String
)
