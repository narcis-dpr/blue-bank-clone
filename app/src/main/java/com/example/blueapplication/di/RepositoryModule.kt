package com.example.blueapplication.di

import com.example.blueapplication.data.repository.GetTransactionsRepository
import com.example.blueapplication.data.repository.GetTransactionsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindGetTransactionRepository(
        getTransactionsRepositoryImpl: GetTransactionsRepositoryImpl
    ): GetTransactionsRepository
}