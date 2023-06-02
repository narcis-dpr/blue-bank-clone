package com.example.blueapplication.presentation.state

import com.example.blueapplication.data.model.Transaction

data class TransactionState (
    val isLoading: Boolean = false,
    val transactions: List<Transaction> = emptyList(),
    val error: String = ""
        )