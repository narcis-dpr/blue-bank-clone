package com.example.blueapplication.di

import android.content.Context
import androidx.room.Room
import com.example.blueapplication.data.local.BlueApplicationDatabase
import com.example.blueapplication.data.local.MIGRATIONS
import com.example.blueapplication.data.local.TransactionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTransactionDatabase(@ApplicationContext context: Context): BlueApplicationDatabase{
        return Room.databaseBuilder(
            context,
            BlueApplicationDatabase::class.java,
            "blueApplication.db"
        ).addMigrations(*MIGRATIONS).build()
    }

    @Provides
    @Singleton
    fun provideTransactionTable(blueApplicationDatabase: BlueApplicationDatabase): TransactionsDao {
        return blueApplicationDatabase.transactionsDao
    }
}