package com.example.blueapplication.data.repository

import com.example.blueapplication.data.local.TransactionsDao
import com.example.blueapplication.data.mapper.mapToEntity
import com.example.blueapplication.data.mapper.mapToTransaction
import com.example.blueapplication.data.model.Transaction
import com.example.blueapplication.data.remote.TransactionApi
import javax.inject.Inject

class GetTransactionsRepositoryImpl @Inject constructor(
        private val transactionApi: TransactionApi,
        private val transactionsDao: TransactionsDao
): GetTransactionsRepository {
    override suspend fun getAllTransactions(): List<Transaction> {
        if (transactionsDao.getAllTransactions().isNotEmpty()) {
            return transactionsDao.getAllTransactions().map { it -> it.mapToTransaction() }
        } else {
            transactionApi.getTransactions().forEach {
                    saveTransaction(it.mapToTransaction())
                }
        return transactionsDao.getAllTransactions().map { it -> it.mapToTransaction() }
        }
    }

    override suspend fun saveTransaction(transaction: Transaction) {
        transactionsDao.insertTransactions(transaction.mapToEntity())
    }
}