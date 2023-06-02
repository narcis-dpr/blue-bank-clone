package com.example.blueapplication.data.repository

import com.example.blueapplication.data.model.Transaction

interface GetTransactionsRepository {
    suspend fun getAllTransactions(): List<Transaction>
    suspend fun saveTransaction(transaction: Transaction)
}