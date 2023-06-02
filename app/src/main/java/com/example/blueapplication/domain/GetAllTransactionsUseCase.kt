package com.example.blueapplication.domain

import com.example.blueapplication.data.model.Transaction
import com.example.blueapplication.data.repository.GetTransactionsRepository
import com.example.blueapplication.di.IoDispatcher
import com.example.electrobitemap.utiles.ResultWrapper
import com.example.electrobitemap.utiles.UseCaseHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    private val getTransactionsRepository: GetTransactionsRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCaseHelper<Unit, List<Transaction>>(ioDispatcher) {
    override fun execute(parameter: Unit): Flow<ResultWrapper<List<Transaction>>> = flow {
        try {
            emit(ResultWrapper.Loading)
            val transactions = getTransactionsRepository.getAllTransactions()
            emit(ResultWrapper.Success(transactions))
        } catch (e: HttpException) {
            emit(ResultWrapper.Error(e))
        }
    }
}