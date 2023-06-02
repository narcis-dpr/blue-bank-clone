package com.example.blueapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blueapplication.data.local.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class],
    version = 1
)
abstract class BlueApplicationDatabase: RoomDatabase() {
    abstract val transactionsDao: TransactionsDao
}