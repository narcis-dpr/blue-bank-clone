package com.example.blueapplication.data.mapper

import com.example.blueapplication.data.local.entity.TransactionEntity
import com.example.blueapplication.data.model.Transaction
import com.example.blueapplication.data.model.TransactionResponse

fun TransactionEntity.mapToTransaction(): Transaction {
    return Transaction(
        transactionType = transactionType,
        date = date,
        amount = amount
    )
}

fun Transaction.mapToEntity(): TransactionEntity {
    return TransactionEntity(
        transactionType = transactionType,
        date = date,
        amount = amount
    )
}

fun TransactionResponse.mapToTransaction(): Transaction {
    return Transaction(
        transactionType = transactionType,
        date = date,
        amount = amount
    )
}

fun Transaction.mapToResponse(): TransactionResponse {
    return TransactionResponse(
        transactionType = transactionType,
        date = date,
        amount = amount
    )
}