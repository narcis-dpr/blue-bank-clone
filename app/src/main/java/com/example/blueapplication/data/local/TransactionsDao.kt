package com.example.blueapplication.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blueapplication.data.local.entity.TransactionEntity

@Dao
interface TransactionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactions(transaction: TransactionEntity)

    @Query("SELECT * FROM transactionTable ")
    fun getAllTransactions() : List<TransactionEntity>

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)
}