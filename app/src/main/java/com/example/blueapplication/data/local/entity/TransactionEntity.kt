package com.example.blueapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionTable")
data class TransactionEntity (
    @ColumnInfo(name = "transaction_type")
    val transactionType: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "amount")
    val amount: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    )